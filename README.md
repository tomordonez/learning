# Learning

This repo contains a summary of courses and code I am learning outside Gatech. Also, here is my [reading](https://github.com/tomordonez/reading) progress.

**In Progress**

* LL: Java OOP
* LL: Python OOP
* LL: Python TDD
* W: Python Koans

**Done**

* LL: IntelliJ Refresher
* LL: Java Essential Training (took in 2021, reviewed in 2022)
* LL: Python with PyCharm
* LL: Learning Python

**Backlog**

*Java*
* LL: Java Algorithms
* LL: Advanced Java Programming
* LL: Java Data Structures
* LL: Java Lambdas and Streams
* LL: Java and Docker
* LL: Java data structures and algorithms (this course is pure theory)
* LL: Java Objects and APIs
* LL: JUnit
* LL: Spring Boot
* LL: Java design patterns
* LL: React and Spring

*Data Engineering*

* LL: Data engineering foundations
* LL: Apache Spark Essential Training
* LL: Introduction to Spark SQL and DataFrames
* LL: Apache PySpark by Example
* LL: Big data analytics with Hadoop and Apache Spark
* LL: Architecting big data applications: Batch mode application engineering
* LL: Architecting big data applications: Real time application engineering
* LL: Stream processing design patterns with spark
* LL: Cloud Hadoop: Scaling Apache Spark
* LL: Advanced Snowflake
* LL: Learning Terraform

*AWS*
* Y: AWS Certified Cloud Practitioner
* LL: Learning AWS for Developers
* LL: Amazon Web Services: Data Analytics
* LL: Amazon Web Services: Data Services

*DevOps*
* LL: Learning Kubernetes

*Analytics*
* LL: Statistics Foundations
* LL: Looker Studio for Beginners
* LL: Tableau Essential Training
* LL: Master SQL for Data Science

*JS*
* LL: JavaScript Essential Training
* LL: Learning the JavaScript Language
* LL: ReactJS Essential Training
* LL: ReactJS Building an Interface
* LL: Creating and Hosting a Full Stack Site
* LL: React Hooks
* LL: Building Modern Projects with React
* LL: React Design Patterns
* LL: React Software Architecture
* LL: React Authentication

Legend

* LL: Linkedin Learning
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

## Testing/TDD

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

It follows the guideline from [this](https://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html) blog post by Roy Osherove.

## Branches and Commits

I went through a few workflows for creating branches. I tried `course/section/summary` but this turns out to be too many branches. Now I am using a branch per course with dashes separating words.

**Branch name**

    course-name

For commits, I am following a convention of creating one commit per video. A course has many sections, and a section has many videos. Following this format for the message where everything after the colon (inclusive) is optional.

**Commit message**

    course-name/section-number/video-title: Short description.

### Creating branches

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

## Organizing code with packages

**Java**

If a course uses different examples, then create a package by example. (Omit the parentheses)

    src
        main
            java (directory)
                example-name (package)
                    AClass (class)
                    AnotherClass (class)
                other-example-name (package)
                    AClassOther (class)
                    AnotherClassOther (class)
        test
            java (directory)
                example-name ...

**Python**

See more details about [setting a project in PyCharm](https://github.com/tomordonez/learning/tree/main/python-pycharm#setup-a-project).

Create this structure (Omit the parentheses)

    course-name (directory)
        example-name (package)
            app.py
            __main__.py
            src (package)
                class-file (py file)
            tests (package)
            data (package, if relevant)
        other-example (package)
            ...

Inside `__main__.py`. Right click to run or in the terminal use `python -m example-name`:

    from example_name import app
    
    if __name__ == '__main__':
    app.run()

Inside `app.py` import other packages like this:

    from example-name.src.class-file import ClassName
