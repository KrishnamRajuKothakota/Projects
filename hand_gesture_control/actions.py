# actions.py

import os
import pyautogui
import platform

class ActionExecutor:
    def __init__(self):
        self.system = platform.system()

    def perform_action(self, gesture_name):
        if gesture_name == "Thumbs Up":
            self.volume_up()
        elif gesture_name == "Fist":
            self.volume_down()
        elif gesture_name == "Index Up":
            self.open_calculator()
        elif gesture_name == "Open Palm":
            self.open_notepad()
        elif gesture_name == "Pinch":
            print("[Gesture] Pinch detected – no action assigned.")
        elif gesture_name == "Unknown":
            print("[Gesture] Unknown gesture.")
        elif gesture_name == "No Hand":
            pass  # No hand detected
        else:
            print(f"[Gesture] No mapping for: {gesture_name}")

    def volume_up(self):
        print("[Action] Volume Up")
        pyautogui.press("volumeup")

    def volume_down(self):
        print("[Action] Volume Down")
        pyautogui.press("volumedown")

    def open_notepad(self):
        print("[Action] Opening Notepad")
        if self.system == "Windows":
            os.system("start notepad")
        elif self.system == "Darwin":  # macOS
            os.system("open -a TextEdit")
        elif self.system == "Linux":
            os.system("gedit &")

    def open_calculator(self):
        print("[Action] Opening Calculator")
        if self.system == "Windows":
            os.system("start calc")
        elif self.system == "Darwin":
            os.system("open -a Calculator")
        elif self.system == "Linux":
            os.system("gnome-calculator &")
