import os
import cv2
import numpy as np
from tensorflow.keras.utils import to_categorical

EMOTIONS = ['angry', 'disgust', 'fear', 'happy', 'neutral', 'sad', 'surprise']
emotion_label_to_index = {label: idx for idx, label in enumerate(EMOTIONS)}

def load_data(data_dir, image_size=(48, 48)):
    X, y = [], []

    for emotion in EMOTIONS:
        emotion_folder = os.path.join(data_dir, emotion)
        if not os.path.isdir(emotion_folder):
            continue
        for img_file in os.listdir(emotion_folder):
            img_path = os.path.join(emotion_folder, img_file)
            img = cv2.imread(img_path, cv2.IMREAD_GRAYSCALE)
            if img is None:
                continue
            img = cv2.resize(img, image_size)
            X.append(img)
            y.append(emotion_label_to_index[emotion])

    X = np.array(X).reshape(-1, 48, 48, 1) / 255.0
    y = to_categorical(y, num_classes=len(EMOTIONS))
    return X, y
