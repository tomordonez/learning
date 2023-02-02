# Set up an IntelliJ project with Java and Maven

Set up a Java project with Maven as seen in the Jetbrains docs [here](https://www.jetbrains.com/help/idea/convert-a-regular-project-into-a-maven-project.html#add_maven_support)

* After creating an IntelliJ project
* In the Project window. Right-click on the root folder
* Select Add Framework Support
* Select Maven

## Project structure

* Package names should be all lowercase without dashes/underscores.
* Optional: Add `cucumber` (see below for details)

Ignore the text in parentheses.

	Course Name/
      README.md
	  Code/
	    src/
            main/
                java/
                    s1sectionname/ (package)
                        exercisename/ (package)
                            AJavaClass.java
                            Main.java
                resources/
                    data.txt
            test/
                java/
                    s1sectionname/ (package)
                        exercisename/ (package)
                            cucumber/ (package)
                                FeatureNameSteps.java
                                FeatureNameTest.java
                            ExerciseNameTest.java
                resources/
                    features/
                      s1sectionname/ (directory)
                        exercisename/ (directory)
                            FeatureName.feature

## Setup JUnit in IntelliJ

* Use Maven
* Go to `pom.xml`, type `Alt+Insert` to add a dependency.
* Add `org.junit.jupiter:junit-jupiter`.
* Then reload the maven icon.

Use this format `methodName_StateUnderTest_ExpectedBehavior` with the exact letter casing and underscore. Such as:

    void getUsingMod_PositiveIndexInRange_IndexedItem()
    void getUsingMod_PositiveIndexOutOfRange_ModIndexedItem()
    void getUsingMod_NegativeIndex_ModIndexedItem()
    void getUsingMod_IndexIsAString_ExceptionThrown()

It follows the guideline from [this](https://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html) blog post by Roy Osherove.

## Setup Cucumber in IntelliJ

I wrote a detailed blog post about it here: [BDD with Cucumber in IntelliJ](https://www.tomordonez.com/bdd-cucumber-intellij/)
