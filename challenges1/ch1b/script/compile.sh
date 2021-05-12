#!/bin/bash

# ln -s ../../ch1a/src/Main.java ../src/Main.java
# ln -s ../../ch1a/src/Person.java ../src/Person.java

cd ../tmp
javac -d . ../src/*.java
