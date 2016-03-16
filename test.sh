#!/bin/bash
function exit_on_error {
  echo "Step \"$1\" of test.sh failed"
  exit 1
}


sbt clean coverage test  || exit_on_error "sbt clean coverage test"
sbt coverageReport       || exit_on_error "sbt coverageReport"
sbt coverageAggregate    || exit_on_error "sbt coverageAggreagate"
sbt codacyCoverage       || exit_on_error "sbt codacyCoverage"
