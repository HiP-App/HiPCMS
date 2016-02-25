#!/bin/bash
PROJECT_ROOT=$(pwd)
echo "\nStarting server test\n"
cd $PROJECT_ROOT/server
sbt clean coverage test
sbt coverageAggregate
echo "\nStarting client test\n"
cd $PROJECT_ROOT/client
# We need to tell npm that we use the local installation of grunt
# We do not install grunt globally because this would prevent us from using the
# container based travis ci infrastructure
./node_modules/.bin/grunt test