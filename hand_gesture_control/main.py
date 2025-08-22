import cv2
from hand_tracker import HandTracker
from gesture_controller import GestureController
from actions import ActionExecutor

def main():
    cap = cv2.VideoCapture(0)
    tracker = HandTracker()
    gesture_controller = GestureController()
    action_executor = ActionExecutor()

    print("[INFO] Starting hand gesture control...")

    while True:
        success, frame = cap.read()
        if not success:
            print("[ERROR] Failed to grab frame.")
            break

        frame = tracker.find_hands(frame, draw=True)
        landmarks = tracker.find_position(frame)

        if landmarks:
            gesture = gesture_controller.detect_gesture(landmarks)
            action_executor.perform_action(gesture)

            # Displays gesture name
            cv2.putText(frame, f'Gesture: {gesture}', (10, 50),
                        cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 0), 2)

        cv2.imshow("Hand Gesture Control", frame)

        if cv2.waitKey(1) & 0xFF == 27:  # ESC to exit
            break

    cap.release()
    cv2.destroyAllWindows()

if __name__ == "__main__":
    main()
