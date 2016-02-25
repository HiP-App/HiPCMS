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
#
#####################################################################


cd $PROJECT_ROOT/client
echo "npm install:"
npm install
echo "npm install bower:"
npm install bower
echo "bower install:"
./node_modules/bower/bin/bower install
echo "update webdriver:"
./node_modules/protractor/bin/webdriver-manager update
cd $PROJECT_ROOT/server
sbt update
