#!/bin/bash

echo "🧹 Cleaning and building Maven project..."
mvn clean install

if [ $? -ne 0 ]; then
  echo "❌ Maven build failed. Exiting."
  exit 1
fi

echo "🐳 Building Docker image..."
docker build -t zuvocloud-automotive:latest .

if [ $? -ne 0 ]; then
  echo "❌ Docker build failed. Exiting."
  exit 1
fi

echo "🚀 Starting Docker Compose..."
docker-compose up -d
