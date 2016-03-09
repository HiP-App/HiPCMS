HiPCMS
======

This content management system is developed by the project group [History in 
Paderborn](http://is.uni-paderborn.de/fachgebiete/fg-engels/lehre/ss15/hip-app/pg-hip-app.html).
It is developed to fill the system 'History in Paderborn' with data. This 
Backend is only used to manage the data. We also develop an Android app to 
view the data, i.e. end users can use this app to view the data in HiP.

In another team of the project group, an Android app is developed that will 
make the content of HiPCMS accessable to the public. Information about the app 
will be added as soon as it is available.

HiPCMS will replace the original project which was known as [HiPBackend](https://hip.upb.de/).
HiPBackend's code unfortunately was not maintainable anymore and a rewrite was decided. 

See the LICENSE file for licensing information.

See [the graphs page](https://github.com/HiP-App/HiPCMS/graphs/contributors) 
for a list of code contributions.

## Requirements:

 * [Jana JDK 8](http://www.oracle.com/technetwork/java/javase/)
 * [node.js](http://nodejs.org/)
 * [MySQL](https://www.mysql.de/)

By default HiPCMS expects a database called ```HiPCMSdb``` and uses ```hipcms``` 
without password to connect. You can override this setting by specifying a 
jdbc-URL in an Environment Variable called ```DATABASE_URL```.

Then you must install the node packages [yo](http://yeoman.io), [grunt](http://gruntjs.com/) 
and [bower](http://bower.io/):

```
npm install -g yo grunt grunt-cli bower
```

## Getting started

 * Use ```setup.sh``` to install all sbt and node-dependencies
 * Use ```test.sh``` to execute the tests
 * You can **start the application** via ```./activator run``` with auto-reload enabled
 * For more information about the Activator see [the product homepage](https://www.lightbend.com/activator/download)

Note: the scripts setup.sh and test.sh are also used by TravisCI; they were 
created to keep setup and test-execution independent of a CI server.


## How to develop

 * The latest code is available on [the project's Github-page](https://github.com/HiP-App/HiPCMS/)
 * You can [fork the repo](https://help.github.com/articles/fork-a-repo/) or [clone our repo](https://help.github.com/articles/cloning-a-repository/)
   * To submit patches you should fork and then [create a Pull Request](https://help.github.com/articles/using-pull-requests/)
   * If you are part of the project group, you can create new branches on the main repo as described [in our internal
     Confluence](http://atlassian-hip.cs.upb.de:8090/display/DCS/Conventions+for+git)

We are using [IntelliJ Ultimate](https://www.jetbrains.com/idea/) which is [free-to-use for students](https://www.jetbrains.com/student/). 
To import the project into IntelliJ, you can use *import project* (*from 
external model* - *SBT*). Just select the ```build.sbt``` which is located in 
the project root directory.

## How to submit Defects and Feature Proposals

Please write an email to [hip-app@campus.upb.de](mailto:hip-app@campus.upb.de).

## Documentation

Documentation is currently collected in our [internal Confluence](http://atlassian-hip.cs.upb.de:8090/dashboard.action). If something is missing in 
this README, just [send an email](mailto:hip-app@campus.upb.de).


## Contact

> HiP (History in Paderborn) ist eine Plattform der:
> Universität Paderborn
> Warburger Str. 100
> 33098 Paderborn
> http://www.uni-paderborn.de
> Tel.: +49 5251 60-0

You can also [write an email](mailto:hip-app@campus.upb.de).