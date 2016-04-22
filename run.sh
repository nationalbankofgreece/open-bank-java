#! /bin/bash

# Stop on errors
set -e
# Export .env variables
export $(cat .env | xargs)

# Log commands
set -x
javac -cp "lib/*:./src" src/com/sourcelair/openbankjava/*.java
java -cp "lib/*:./src" com.sourcelair.openbankjava.JavaSample
