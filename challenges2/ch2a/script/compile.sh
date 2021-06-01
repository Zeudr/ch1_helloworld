#!/bin/bash

# ln -s ../../ch1a/src/Main.java ../src/Main.java
# ln -s ../../ch1a/src/Person.java ../src/Person.java



#cd ../tmp

BASEDIR=$(realpath "$(dirname "$(readlink -f "$0")")")
echo "$BASEDIR"
#javac -d . ../src/*.java
