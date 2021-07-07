#!/bin/bash

mkdir src/common
mkdir lib
#ln -s ../../../ch1a/src/common/*.java ../src/common/*.java

ln -s ../../../ch1a/src/common/Customer.java src/common/Customer.java
ln -s ../../../ch1a/src/common/CustomerService.java src/common/CustomerService.java
ln -s ../../../ch1a/src/common/CustomerRepository.java src/common/CustomerRepository.java
ln -s ../../../ch1a/src/common/AbstractController.java src/common/AbstractController.java
ln -s ../../../ch1a/src/common/DBapi.java src/common/DBapi.java


ln -s ../../ch1a/lib/mysql-connector-java-8.0.23.jar lib/mysql-connector-java-8.0.23.jar
ln -s ../../ch1b/lib/hsqldb.jar lib/hsqldb.jar
