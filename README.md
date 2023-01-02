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

***

## Testing/BDD

**Setup IntelliJ Cucumber**

As seen in the Jetbrains doc [here](https://www.jetbrains.com/help/idea/enabling-cucumber-support-in-project.html#c839be76)

In IntelliJ Ultimate the plugins are enabled by default.

- Settings/Plugins
- Scroll down to see Gherkin, then Cucumber for Java

**Add the Cucumber library to Maven**

- Open `pom.xml`
- Do `Alt+Insert`
- Select `Add Dependency`
- Search for Cucumber
- Look for `Cucumber-JVM: Java io.cucumber:cucumber-java`
- Click Add
- Look for `Cucumber-JVM: JUnit io.cucumber:cucumber-junit`
- Click Add

It should look like this:

	<dependency>
				<groupId>io.cucumber</groupId>
				<artifactId>cucumber-java</artifactId>
				<version>7.10.1</version>
				<scope>test</scope>
	</dependency>
	<dependency>
				<groupId>io.cucumber</groupId>
				<artifactId>cucumber-junit</artifactId>
				<version>7.10.1</version>
				<scope>test</scope>
	</dependency>

**Reload Maven**

- Open the Maven tab (on the right). Click on the reload icon (first icon, hovering says 'Reload all Maven projects')

**Prepare folder structure. Inside the `test` directory**

- There should be a green `java` directory. It's green because it should have been (right-clicked) `Mark Directory As` then selected `Test Sources Root`
- Create another directory `resources`. Right-click the `test` directory, and it should give the option to add a `resources` subdirectory already marked as `Test Resources Root` (the icon has a red/green diamond as shown in the Jetbrains page). Otherwise, create a subdirectory, Mark Directory As, then select `Test Resources Root`

**Create feature files**

- As seen in the Cucumber blog [here](https://cucumber.io/blog/bdd/solving-how-to-organise-feature-files/). Don't create a feature file for each user story.
- Inside `resources` create a directory `features`. Inside this directory, create the `file-name.feature` files.
- In my case, since I have many packages for many course sections. Recreate the package tree as seen in the `test/java/` directory. However, the `resources` directory won't let you create a package, instead create a directory.
    - In `test/resources/`
    - Create the directory using the template `course-example`
    - Inside this directory, create the directory `features`
    - It will now show the directory as `resources/course-example.features/`
    - Create the feature file in this directory using the template `FeatureName.feature`
    - A file is created and it shows the cucumber icon next to it
    - Right-click/Run the `.feature` file to see Test Results

**Create step definitions**

* As seen in the Jetbrains doc [here](https://www.jetbrains.com/help/idea/creating-step-definition.html), steps definitions should be located in a dedicated package.
* In `test/java/`, in the specific `course-example` package created by JUnit (if created), create a package `cucumber`
* Go to the `feature` file and hover over a step (it should be underlined in yellow). In the popup menu select `Create step definition`
* Name the file `FeatureNameSteps`, select Java, and specify the location.
* Copy the methods from Test Results that have the annotations `@Given`, `@When`, `@Then`. Import these classes.
* From a `feature` file step go to a step definition by placing the cursor at a step, press `Ctrl`, it turns into a link, click the link to go to the step definition

**Run Cucumber tests with JUnit**

* Right-click the package with the step definitions
* Select New, Java Class
* Name the class `FeatureNameTest`
* Right-click Run

Add the following code to `FeatureNameTest`:

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;
	import org.junit.runner.RunWith;
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
		features = {"classpath:course-example/features/FeatureName.feature"},
		glue = {"com.tom.course-example.cucumber"})
	public class RunCucumberTest {
	}

**Testing Life Cycle**

As seen in this LinkedIn Learning course about Cucumber [here](https://www.linkedin.com/learning/cucumber-essential-training)

1. Define acceptance tests
2. Define features - cover as many scenarios (write BDD tests)
3. Write TDD unit tests

**3 key components of Cucumber**

1. Feature files (Feature, Scenario, Given/When/Then) in business domain language (using Gherkin)

	Feature: Reading an ebook
		Scenario: View Index Section
			Given: I am on any page of my ebook
			When: I access "Index" section
			Then: I should be navigated to the Index section

2. Step definition files: In code write `Given/When/Then` annotations with methods

3. Test runner: Glues feature with step definition files using JUnit

**Example Mapping**

Story: Create a list of odd numbers
- Rule: A list of positive integers should keep only odd numbers
	- Example: Input [0, 1, 2, 3, 4, 5] Output [1, 3, 5]
	- Example: Input [5, 5, 2, 0, 3, 1] Output [5, 5, 3, 1]

Story: Create a list of even numbers
- Rule: A list of positive integers should keep only even numbers
	- Example: Input [0, 1, 2, 3, 4, 5] Output [0, 2, 4]
	- Example: Input [5, 5, 2, 0, 3, 1] Output [2, 0]

Story: Create a list of prime numbers
- Rule: A list of positive integers should keep only prime numbers
	- Example: Input [0, 1, 2, 3, 4, 5] Output [2, 3, 5]
	- Example: Input [5, 5, 2, 0, 3, 1] Output [5, 5, 2, 3]

**Create a feature file**

* In the corresponding `features` package in the `test/resources` directory
* Create a features file `CreateNumbersList.feature`

Example:

	Feature: Create Numbers List

	  Scenario: Create a list of positive odd numbers
	    Given I have a list of positive numbers
	    When I filter by odd numbers
	    Then A list of positive odd numbers is created

**Create steps file**

* In the corresponding package in `test/java/package-name/cucumber`
* Create the Java class `CreateNumbersListSteps`

Example:
	
	import com.tom.conditionarray.ConditionArrayList;
	import com.tom.conditionarray.RandomNumberList;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	
	import java.util.ArrayList;
	
	public class CreateNumbersListSteps {
	
		ConditionArrayList numberList;
		ArrayList<Integer> filteredNumberList;

		@Given("I have a list of positive numbers")
		public void iHaveAListOfPositiveNumbers() {
			numberList = new ConditionArrayList(RandomNumberList.createList(5, 10, 10));
		}
	
		@When("I filter by odd numbers")
		public void i_filter_by_odd_numbers() {
			filteredNumberList = numberList.filterByPredicate(listElement -> (listElement % 2 == 1));
		}

		@Then("A list of positive odd numbers is created")
		public void a_list_of_positive_odd_numbers_is_created() {
			System.out.println(filteredNumberList);
		}
	}

**Create JUnit Cucumber Test Runner**

* In the same directory `test/java/package-name/cucumber`
* Create the Java class `CreateNumbersListTest`
* Run this file to see the test results

***

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
