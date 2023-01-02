# Learning

This repo contains a summary of courses and code I am learning outside Gatech. Also, here is my [reading](https://github.com/tomordonez/reading) progress.

**In Progress**

* LL: Java OOP
* LL: Python OOP
* LL: Python TDD
* LL: Cucumber Essential Training
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

## Course exercises

A course has many sections and each section has many videos. Each video follows an exercise and I have seen these variations:

* An exercise is built iteratively after each section.
* Different exercises are built in each section.
* Different exercises are built in each section's videos.

Organize exercises in packages by course sections (with template `S#_SectionName`). For example if Java:

	Course 1
	  Code/
	    src/
		  S1_Objects/
			name-of-excercise-package/
			  ExerciseName.java
		  S2_Encapsulation/
			...
		test/
		  java/
			S1_Objects/
			  name-of-excercise-package/
				cucumber/
					FeatureNameSteps.java
					FeatureNameTest.java
				ExerciseNameTest.java
		  resources
			features/
			  S1_Objects/
				name-of-excercise-directory/
					FeatureName.feature

## Testing/TDD

So far courses aren't in TDD or don't use testing.

**Learning with TDD**

Follow this learning methodology:

* Play/pause the video and take notes in the corresponding course README
* After the video is done, without looking at it, write the exercise using TDD
* Commit everytime a test passes
* Google things when feeling stuck
* Re-watch the video as a last resource.

**Test methods naming convention**

Use this format `methodName_StateUnderTest_ExpectedBehavior` with the exact letter casing and underscore. Such as:

    void getUsingMod_PositiveIndexInRange_IndexedItem()
    void getUsingMod_PositiveIndexOutOfRange_ModIndexedItem()
    void getUsingMod_NegativeIndex_ModIndexedItem()
    void getUsingMod_IndexIsAString_ExceptionThrown()

It follows the guideline from [this](https://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html) blog post by Roy Osherove.

**Setup Java JUnit in IntelliJ**

* Use Maven
* Go to `pom.xml`, type `Alt+Insert` to add a dependency.
* Add `org.junit.jupiter:junit-jupiter`.
* Then reload the maven icon.

**Setup Python unittest in PyCharm**

See below `Organizing code with packages`.

* Create a `tests` package directory

Go to a class. Right-click. `Go to` and select `Test`.

* Create a test case per class
* Import `from unittest import TestCase`
* Import `from unittest.mock import Mock, patch`

## Testing/BDD

**Setup Cucumber in IntelliJ**

I wrote a detailed blog post about it here: [BDD with Cucumber in IntelliJ](https://www.tomordonez.com/bdd-cucumber-intellij/)

## Branches

I went through a few workflows for creating branches. I tried `course/section/summary` but this turns out to be too many branches.

Now I am using a branch per course with dashes separating words, all lower case.

**Branch name**

    course-name

## Commits

**Commit frequency**

Following an answer in Stackoverflow [here](https://softwareengineering.stackexchange.com/a/74765).

Commit every time a new test passes.

**Commit message**

Following these best practices I found on git commits [here](https://gist.github.com/robertpainsi/b632364184e70900af4ab688decf6f53).

Separate the subject from the body with a blank line. In IntelliJ/PyCharm

	Here is the subject

	Then the body

In the command line as seen in [this](https://stackoverflow.com/a/40506149) Stackoverflow answer. Separate subject and body with two `-m` messages. This concatenates the messages as separate paragraphs, separated by an empty line.

	git commit -m "Here is the subject" -m "Then the body"

**Commit Subject**

Use this template, where `course-name` can be the same as `branch-name`.

    course-name/section-number/short-video-title

Such as:

    java-OOP/4/runtime-polymorphism

**Commit body**

The best practices I found said that this is for the subject line. It should complete the following sentence `If applied, this commit will (subject line)` and start with an imperative verb.

For example, use `Test that constructor removes even numbers`, instead of `Tested that constructor...`. The subject line should complete the sentence `If applied, this commit will test that constructor removes even numbers`.

I am applying this concept to the commit body, since I am using the `course/section/title` template as the subject line to try to organize commits in the soup of courses.

A complete example:

	java-OOP/4/runtime-polymorphism

	Test that constructor removes even numbers

### Creating branches

**CLI**

    (main)$ git checkout -b branch-name 
    (react-BMP)$ git add .
    (react-BMP)$ git commit -m "Subject line" -m "body of commit"
    (react-BMP)$ git push -u origin branch-name

In GitHub create a PR and merge with main. If updating local main then:

    (react-BMP)$ git checkout main
    (main)$ git pull

**IntelliJ**

* Bottom right, click on `main`, click New Branch
* Make changes
* Left margin, click on tab `commit`
* Select files under Changes and Unversioned files
* Enter a message. Subject line, empty line, Body of commit
* Click Commit
* Top menu Git/Push

## Organizing code with packages

**Java**

If a course uses different exercises, then create a package by exercise. (Omit the parentheses)

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
