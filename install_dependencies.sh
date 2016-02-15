#!/bin/sh
PROJECT_ROOT=$(pwd)
. $HOME/.nvm/nvm.sh
nvm install stable
nvm use stable
cd $PROJECT_ROOT/client
npm install
./node_modules/bower/bin/bower install
cd $PROJECT_ROOT/server
sbt update
