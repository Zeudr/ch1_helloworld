#!/bin/bash

BASEDIR=$(realpath "$(dirname "$(readlink "$0")")")

cd "$BASEDIR"/tmp
java -cp "$BASEDIR"/lib/*:. Main
