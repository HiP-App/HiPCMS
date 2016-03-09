#!/bin/bash
echo "Tests"
sbt clean coverage test
sbt coverageReport
sbt coverageAggregate
sbt codacyCoverage
exit 0
