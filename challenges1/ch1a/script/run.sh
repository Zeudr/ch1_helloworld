#!/bin/bash

BASEDIR=$(realpath "$(dirname "$(readlink -f "$0")")")

cd "$BASEDIR"/tmp
java -cp "$BASEDIR"/lib/*:. Main
