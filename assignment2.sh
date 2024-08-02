#! /bin/bash 

# Compile NodeType.java
javac -d bin src/NodeType.java

# Compile DoublyLinkedList.java
javac -d bin -cp bin src/DoublyLinkedList.java

# Compile DoublyLinkedListDriver.java
javac -d bin -cp bin src/DoublyLinkedListDriver.java

# Run DoublyLinkedListDriver
java -cp bin DoublyLinkedListDriver

# Clean up compiled files
rm -rf bin
