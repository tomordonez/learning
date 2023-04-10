# 1. Getting Started

**Configure JDK**

* Install any number of Java versions
* File > New Project Setup > Structure > Platform Settings > SDK > Plus sign to install a Java version

**Setup a new project**

* File > New Project > Java
* Project Name: HelloWorld
* Project location: (leave default)
* Base package: com.example

**Use the template shortcuts**

* Type `sout` and hit tab to autocomplete `System.out.println()`
* Use `Ctrl + J` to see other Java shortcuts

**Add Java SDK API docs to project**

* File > Project Structure > Project > SDK > Edit > Documentation path 
* Click the `+` sign with the earth globe to add URL 
* Leave the default if applicable to the corresponding SDK version

# 2. Explore the user interface

* Bottom left has an icon shortcut that shows most used windows
* Left window top left has a dropdown with different ways to view the files:
    Project, Packages, Project files (production, tests)

# 3. Edit and debug code

Create a class in a new package. In `com.example`, right click and add the
package `model`, then create the class `Person`.

Add the fields:

    private String firstName;
    private String lastName;
    private int age;

Add setters and getters:

* Menu Code > Generate > Getter and Setter
* Select all and OK


Create a constructor:

* Menu Code > Generate > Constructor
* Select all and OK


Move code around:

* `Ctrl + Shift + arrow up/down`


Correct indentation:

* Menu Code > Reformat code


Optimize imports:

* Menu Code > Optimize imports


Search everywhere:

* Use `Shift + Shift`


Generate toString()

* Code > Generate > toString()


Rename a variable with refactor

* Position the cursor on a variable
* Menu > Refactor > Rename

Extract method with refactor

* Select lines of code
* Menu > Refactor > Refactor This > Extract Method

Use scratch files to draft code or transfer code between projects:

* File > New > Scratch File
* Select the type of file
* The file is created under the `Scratches and Consoles`

# 4. Analyze and debug code

* Use breakpoints, on a statement, click on the left margin to see a red dot
* Use step over or step in
* Run the code in debug mode (bug icon)
* The current value of a statement is displayed to the right side of the
    statement or in the debugging window

# 5. Build, compile, and package Java projects

* The `out` directory can be deleted and recreated once the project is built
    again.

**Example importing a library without Maven or Gradle**

* Create a new project with only main
* Download a library like gson, download the jar file
* Create a new directory `lib`
* Copy the jar file location
* Right click `lib` directory and paste the file
* Right click the file and `add as library`
* In `main` create a Gson object: `Gson gson = new Gson();`
* The library is imported as `import com.google.gson.Gson;`

**Example importing a library with Maven**

* Create a new project, select Maven as the build system
* In the Project Structure > Modules > Dependencies
* Bottom left `+` > library > from maven
* Type `gson` and click `search`
* Find the most recent version. It was `com.google.code.gson:gson:2.10`
* Build the project
* The library should appear under `idea/libraries`
* Create a new package under `src/main/java` called `com.example`
* Under the package create a `Main` class.

# 6. Version control

**Add Github in IntelliJ**

* Settings > Version Control > Github
* Add account
* Login with Github
* A website opens to Authorize JetBrains IDE Integration































