#!/bin/sh
PROJECT_ROOT=$(pwd)
. $HOME/.nvm/nvm.sh
nvm install stable
nvm use stable
cd $PROJECT_ROOT/client
npm install bower grunt-cli
bower install
cd $PROJECT_ROOT/server
sbt update