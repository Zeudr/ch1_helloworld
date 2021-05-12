#!/bin/bash

ln -s ../../ch1a/src/Main.java ../../ch1b/src/Main.java
ln -s ../../ch1a/src/Person.java ../../ch1b/src/Person.java

cd ../src
javac Main.java

mv Main.class ../tmp/Main.class
mv Person.class ../tmp/Person.class
mv PersonService.class ../tmp/PersonService.class
