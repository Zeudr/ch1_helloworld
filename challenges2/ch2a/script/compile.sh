#!/bin/bash

# ln -s ../../../challenges1/ch1a/src/Main.java ../src/Main.java
# ln -s ../../ch1a/src/Person.java ../src/Person.java

BASEDIR=$(realpath "$(dirname "$(readlink "$0")")")

javac -d "$BASEDIR"/tmp "$BASEDIR"/src/*.java
