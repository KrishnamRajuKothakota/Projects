import math

class GestureController:
    def __init__(self):
        pass

    def _distance(self, p1, p2):
        """Calculate Euclidean distance between two points."""
        return math.hypot(p2[0] - p1[0], p2[1] - p1[1])

    def fingers_up(self, landmarks):
        """Returns a list indicating which fingers are up."""
        if not landmarks or len(landmarks) < 21:
            return []

        fingers = []

        # Thumb
        fingers.append(landmarks[4][0] > landmarks[3][0])  # Right hand assumption

        # Other fingers
        fingers.append(landmarks[8][1] < landmarks[6][1])  # Index
        fingers.append(landmarks[12][1] < landmarks[10][1])  # Middle
        fingers.append(landmarks[16][1] < landmarks[14][1])  # Ring
        fingers.append(landmarks[20][1] < landmarks[18][1])  # Pinky

        return fingers  # [Thumb, Index, Middle, Ring, Pinky]

    def detect_gesture(self, landmarks):
        """Returns the name of the gesture based on landmarks."""
        fingers = self.fingers_up(landmarks)

        if not fingers:
            return "No Hand"

        if fingers == [0, 0, 0, 0, 0]:
            return "Fist"
        elif fingers == [1, 1, 1, 1, 1]:
            return "Open Palm"
        elif fingers == [1, 0, 0, 0, 0]:
            return "Thumbs Up"
        elif fingers == [0, 1, 0, 0, 0]:
            return "Index Up"

        # Pinch detection (distance between thumb and index tip)
        thumb_tip = landmarks[4][1], landmarks[4][2]
        index_tip = landmarks[8][1], landmarks[8][2]
        distance = self._distance(thumb_tip, index_tip)
        if distance < 40:
            return "Pinch"

        return "Unknown"
