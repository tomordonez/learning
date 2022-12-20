# Learning

This repo contains a summary of courses and code I am learning outside Gatech. Also, here is my [reading](https://github.com/tomordonez/reading) progress.

**In Progress**

* LIL: Java OOP

**Done**

* LIL: IntelliJ Refresher
* LIL: Java Essential Training (took in 2021, reviewed in 2022)
* LIL: Python with PyCharm
* LIL: Learning Python

**Backlog**

*Java*
* LIL: Java Algorithms
* LIL: Advanced Java Programming
* LIL: Java Data Structures
* LIL: Java Lambdas and Streams
* LIL: Java and Docker
* LIL: Java data structures and algorithms (this course is pure theory)
* LIL: Java Objects and APIs
* LIL: JUnit
* LIL: Spring Boot
* LIL: Java design patterns
* LIL: React and Spring

*Data Engineering*
* LIL: Data engineering foundations
* LIL: Apache Spark Essential Training
* LIL: Introduction to Spark SQL and DataFrames
* LIL: Apache PySpark by Example
* LIL: Big data analytics with Hadoop and Apache Spark
* LIL: Architecting big data applications: Batch mode application engineering
* LIL: Architecting big data applications: Real time application engineering
* LIL: Stream processing design patterns with spark
* LIL: Cloud Hadoop: Scaling Apache Spark
* LIL: Advanced Snowflake
* LIL: Learning Terraform

*AWS*
* Y: AWS Certified Cloud Practitioner
* LIL: Learning AWS for Developers
* LIL: Amazon Web Services: Data Analytics
* LIL: Amazon Web Services: Data Services

*DevOps*
* LIL: Learning Kubernetes

*Analytics*
* LIL: Statistics Foundations
* LIL: Looker Studio for Beginners
* LIL: Tableau Essential Training
* LIL: Master SQL for Data Science

*JS*
* LIL: JavaScript Essential Training
* LIL: Learning the JavaScript Language
* LIL: ReactJS Essential Training
* LIL: ReactJS Building an Interface
* LIL: Creating and Hosting a Full Stack Site
* LIL: React Hooks
* LIL: Building Modern Projects with React
* LIL: React Design Patterns
* LIL: React Software Architecture
* LIL: React Authentication

Legend

* LIL: Linkedin Learning
* ACG: A Cloud Guru
* Y: Youtube
* W: Web Tutorial

## Documenting

I didn't want to create a repo for each course. Instead, documenting all my learning in one big repo following this directory structure:

    Learning
        Course 1
            Code
            Readme
        Course 2
            Code
            Readme

### Testing/TDD

So far courses aren't in TDD or don't use testing.

**Java**

Using JUnit. In IntelliJ.

* Use Maven
* Go to `pom.xml`, type `Alt+Insert` to add a dependency.
* Add `org.junit.jupiter:junit-jupiter`.
* Then reload the maven icon.


**Test methods naming convention**

Use this format `methodName_StateUnderTest_ExpectedBehavior` with the exact letter casing and underscore. Such as:

    void getUsingMod_PositiveIndexInRange_IndexedItem()
    void getUsingMod_PositiveIndexOutOfRange_ModIndexedItem()
    void getUsingMod_NegativeIndex_ModIndexedItem()
    void getUsingMod_IndexIsAString_ExceptionThrown()

It follows the guideline from [this](https://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html) blog post by Roy Osherove. In the past I named tests just using the method name, or methodName_Test1, which found it confusing after running many tests, also for a while I thought that having long names was a bad practice, but having a descriptive name with input and expected output improved readability while looking at code I wrote in the past. It was easier to decipher the program's features by reading the test names.


### Branches

I've seen two types of course content for Linkedin Learning, where a course has sections and each section has videos.

* Each video is an independent example/code that doesn't build upon the previous video.
* Each video is an example/code that builds upon the previous video.

Also, sometimes I find the examples trivial and I want to add my own spice, like using OOP, adding test cases, or other methods that might be outdated in the content.

After some experimentation, I found it easier to follow this naming convention:

    course-name-short/section-number/section-name-short

Such as:

    Java-ET/7/custom-classes
    Java-ET/8/inheritance

Each section has videos like the following structure

    7. Custom Classes
      - Declare and use custom classes
      - Organize code with packages
      - Create instance fields and methods

Create a commit for each video and use the exact video title as the commit comment.

When adding my own research then use:

    course-name/section-number/research/short-description

Such as:

    Java-ET/7/research/load-csv


**CLI**

    (main)$ git checkout -b branch-name 
    (react-BMP)$ git add .
    (react-BMP)$ git commit -m "a message..."
    (react-BMP)$ git push -u origin branch-name
    (react-BMP)$ git checkout main
    (main)$ git pull

**IntelliJ**

* Bottom right, click on `main`, click New Branch
* Make changes
* Left margin, click on tab `commit`
* Select files under Changes and Unversioned files
* `Ctrl+K` or right click select Commit
* Enter a message
* Top menu Git/Push

### Organizing code with packages

In Java courses, as they go through the sections, they often change examples and overwrite `Main` with completely different code. Then it is confusing to read the branch changes history in `Main` that don't correspond to classes created for every example.

A solution is to create packages for each example and contain all classes and a `Main` class for that example. For example there were two examples in a course, one was about a banking app, another was about an employee app:

    java
        com.tom
            bank
                BankMain
                Account
                Menu
            employee
                EmployeeMain
                Employee
                Job
