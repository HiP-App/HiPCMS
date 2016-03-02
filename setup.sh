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

sbt 'update' 'npm install' 'bower install' 'grunt build'
