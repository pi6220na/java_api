# java_api
Java API GUI part 2 of 2 - Final Project Java 2545 Fall 2016

This is the GUI application that runs against the java_api database. 

Background: The database is generated using the JavaAPILoader application (part 1 of 2). The database contains records stored in seven tables. This data has been extracted from the downloaded HTML files from Oracle's website for Java SE Version 8 and can be found at this link for the online version: https://docs.oracle.com/javase/8/docs/api/index.html?overview-summary.html and the downloadable zip file containing all the files (beware, it's huge): 
http://www.oracle.com/technetwork/java/javase/documentation/jdk8-doc-downloads-2133158.html

Note that the database only contains data from the Java and JavaX libraries.

An overview of the documentation structure can be found on the help link of the API at:
http://docs.oracle.com/javase/8/docs/api/
This page provides a good overview of the documentation structure and forms the basis of the database design.

Please see file new_java_api_eer.png for the Entity Relationship diagram generated by MySQL Workbench.

Please see file Java API Help.png, off the root Github, for instructions on how to use this application.

This application is intended to answer questions such as:
- What classes or interfaces constain a method called toString?
- What classes or interfaces constain a method called size(double, double)?
- What classes or interfaces constain a method with the string 'prime' somewhere in the method name (or description)?
- What methods will accespt a Random as a parameter?
- What classes implement the java.security.Guard interface?

In addition, packages, classes, exceptions, errors, methods, fields, and constructors tables can be searched on either the name or description/summary.

This is an evolving project that I intend to continue refining and enhancing to improve its useability and usefullness.