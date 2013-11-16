#!/bin/sh

# Simple wrapper to change current working directory so that
# joose-farm.js can find the correct path to joose.js.

cd `dirname $0`
./joose-farm.js
