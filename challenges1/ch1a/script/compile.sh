#!/bin/bash

 ln -s ../../ch1a/src/Customer.java ../src/Customer.java
 ln -s ../../ch1a/src/CustomerService.java ../src/CustomerService.java
 ln -s ../../ch1a/src/CustomerRepository.java ../src/CustomerRepository.java
 ln -s ../../ch1a/src/CustomerController.java ../src/CustomerController.java

BASEDIR=$(realpath "$(dirname "$(readlink "$0")")")

javac -d "$BASEDIR"/tmp "$BASEDIR"/src/*.java
