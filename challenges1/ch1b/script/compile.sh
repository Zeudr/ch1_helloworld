#!/bin/bash

ln -s ../../ch1a/src/Main.java ../src/Main.java
ln -s ../../ch1a/src/Person.java ../src/Person.java

cd ../src
javac Main.java

mv Main.class ../tmp/Main.class
mv Person.class ../tmp/Person.class
mv PersonService.class ../tmp/PersonService.class
