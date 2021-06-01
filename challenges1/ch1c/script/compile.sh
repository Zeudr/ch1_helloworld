#!/bin/bash

BASEDIR=$(realpath "$(dirname "$(readlink "$0")")")

javac -d "$BASEDIR"/tmp "$BASEDIR"/src/*.java
