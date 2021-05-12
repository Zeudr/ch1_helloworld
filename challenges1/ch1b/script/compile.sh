#!/bin/bash

ln -s ../../ch1a/src/Main.java ../../ch1b/src/ch1aMain.java
ln -s ../../ch1a/src/Person.java ../../ch1b/src/ch1aPerson.java

cd ../src
javac ch1aMain.java
