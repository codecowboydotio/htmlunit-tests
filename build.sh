#!/bin/sh

unzip htmlunit-2.23-bin.zip
javac -cp .:htmlunit-2.23/lib/* test.java
