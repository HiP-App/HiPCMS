#!/bin/sh
PROJECT_ROOT=$(pwd)

#####################################################################
#
# Preparations: checking if some necessary programs are installed
#
#####################################################################

travisSetup(){
  if [ hash ". $HOME/.nvm/nvm.sh" 2>/dev/null ]; then
    . $HOME/.nvm/nvm.sh || return 1
    nvm install stable  || return 1
    nvm use stable      || return 1
  fi
}

travisSetup || echo >&2 "Travis setup failed. Installation will try to continue without nvm."

hash npm 2>/dev/null || { echo >&2 "npm is not installed. Installation cannot continue."; exit 1; }
hash sbt 2>/dev/null || { echo >&2 "sbt is not installed. Installation cannot continue."; exit 1; }

#####################################################################
#
# Actual Installation
# See also README.md
#
#####################################################################

# We're using the node_modules here for two reasons:
#  - support for Travis CI
#  - more independence of the environment

sbt update

npm install
npm install bower
./node_modules/bower/bin/bower install
./node_modules/bower/bin/bower grunt
./node_modules/protractor/bin/webdriver-manager

sbt 'grunt build'
