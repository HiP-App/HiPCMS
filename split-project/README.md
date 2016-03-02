https://hip.upb.de/
===================

 * develop: [![Build Status Develop](https://travis-ci.org/HiP-App/HiPCMS.svg?branch=develop)](https://travis-ci.org/HiP-App/HiPCMS)
 * master: [![Build Status Master](https://travis-ci.org/HiP-App/HiPCMS.svg?branch=develop)](https://travis-ci.org/HiP-App/HiPCMS)
 * Code Quality: [![Codacy Badge](https://api.codacy.com/project/badge/grade/b905a3e6757a49979e2135f84f8feaef)](https://www.codacy.com/app/lippertsjan/HiPCMS)

This application is developed to fill the system 'History in Paderborn' with data. We also develop an [Android app](https://git.cs.upb.de/HiP/HiP-Android/) to view the data, i.e. end users can use this app to view the data in HiP.

See the LICENSE file for licensing information. 

See the git history for information about authors. The [graphs page](https://git.cs.upb.de/HiP/HiPCMS/graphs/master) has a nice visual overview of contributors.

Documentation
=============

The documentation of this project is done in the [project groups's Confluence wiki](http://jira-hip.cs.upb.de:8090/display/DOC/).

Getting Started
===============

A step-wise guide to setup your development environment can be found in the Confluence article ["Set up development environment"](http://jira-hip.cs.upb.de:8090/display/DOC/Set+up+development+environment).

Running HiP
===========

 1. Clone the repository
 2. Run ```./activator run```

More information about the activator can be found at [typesafe](https://www.typesafe.com/get-started).

How to develop
==============

The source code is hosted at [the gitlab server of the University of Paderborn](https://git.cs.upb.de/HiP/HiPBackend).


To run the application you can either use your IDE or you can use the activator file: ```./activator run```

For more information about using the activator script, see https://www.typesafe.com/community/core-tools/activator-and-sbt

Dependency updates
------------------

To see the dependencies that can be updated, the plugin [sbt-updates](https://github.com/rtimush/sbt-updates) is used. It 
provides the tasks "dependencyUpdates" and "dependencyUpdatesReport". The first one shows the updateable dependencies whereas the second one 
generates a report file.

Testing
=======

TODO: Add testing description.


Reporting issues
================

This project group is using the Scaled Agile Framework. See [Scaled Agile Framework® (SAFe®)](http://jira-hip.cs.upb.de:8090/pages/viewpage.action?pageId=3276965) and [Scrum](http://jira-hip.cs.upb.de:8090/display/SEM/Scrum) for an introduction.

All Issues of this project are tracked on http://jira-hip.cs.upb.de:8080/

Application stack
=================

From A full application stack for a Modern Web application, lets review the components:

TODO: add the list of components.
