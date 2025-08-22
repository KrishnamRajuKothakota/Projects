import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))

import os
import kagglehub
from tensorflow.keras.optimizers import Adam
from tensorflow.keras.callbacks import ModelCheckpoint

from utils.dataset_utils import load_data
from model import build_emotion_model

# Download dataset using kagglehub
dataset_path = kagglehub.dataset_download("msambare/fer2013")
train_path = os.path.join(dataset_path, "train")
val_path = os.path.join(dataset_path, "test")  

print("Loading training data...")
X_train, y_train = load_data(train_path)

print("Loading validation data...")
X_val, y_val = load_data(val_path)

model = build_emotion_model()

model.compile(
    optimizer=Adam(learning_rate=0.0001),
    loss='categorical_crossentropy',
    metrics=['accuracy']
)

# Training
os.makedirs("models", exist_ok=True)
checkpoint = ModelCheckpoint(
    "models/emotion_model.h5",
    monitor='val_accuracy',
    save_best_only=True,
    verbose=1
)

print("Starting training...")
model.fit(
    X_train, y_train,
    validation_data=(X_val, y_val),
    epochs=30,
    batch_size=64,
    callbacks=[checkpoint]
)
