#!/bin/bash

# ln -s ../../../challenges1/ch1a/src/Main.java ../src/Main.java
# ln -s ../../ch1a/src/Person.java ../src/Person.java
# ln -s ../../ch1a/src/PersonService.java ../src/PersonService.java
# ln -s ../../ch1a/src/PersonRepository.java ../src/PersonRepository.java
# ln -s ../../ch1a/script/compile.sh ../script/compile.sh
# ln -s ../../ch1a/script/run.sh ../script/run.sh

BASEDIR=$(realpath "$(dirname "$(readlink "$0")")")

javac -d "$BASEDIR"/tmp "$BASEDIR"/src/*.java
