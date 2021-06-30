#!/bin/bash

BASEDIR=$(realpath "$(dirname "$(readlink -f "$0")")")

javac -sourcepath .:$BASEDIR/../src/common/* -d $BASEDIR/../tmp $BASEDIR/../src/*.java
