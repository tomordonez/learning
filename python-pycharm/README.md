# Background

I used Python for courses at Gatech and to complete a couple of work projects. However, I mostly
used Vim or Sublime. Since I've been using IntelliJ for Java, I decided to use PyCharm
(Community Edition) since the interface is the same.

*Course Review*

* The course has some tips on how to use PyCharm, however there is another one in IntelliJ with
  much more detail, and they are the same interface.
* The sound is not great, the voice comes in and out in a rather monotone.
* There isn't a structure example to learn from. A small OOP tested example would have been
  ideal to follow through the sections. Instead, the example is Conway's game of life, but this
  isn't built from scratch.
* There are some TDD exercises.

# 1. Getting to know PyCharm

**Installing**

I had conda installed. When creating a new project, selected conda and previous interpreter
installed.

**Interface Settings**

I updated the same settings I had in IntelliJ

* Enabled `Editor/General/Soft Wrap/Soft wrap these files`
* Customize soft wrap for Markdown in `Editor/Code Style/Markdown`. Hard wrap at: 100, Wrap on
  typing: Yes.
* Font set to `16` in `Editor/Color Scheme/Color Scheme Font`
* Console font set to `15`. In Settings search `Console`
* Updated Markdown to have more distinction in `Editor/Color Scheme/Markdown`

# 2. Git and Github

* Configure Github in Settings/Version Control/Github

# 3. Managing Dependencies

* Browse packages in [Pypi.org](https://pypi.org/)
* Browse project packages in `Settings/Project Code/Project Interpreter`. Upgrade using the arrow up
  icon from the Last version column.
* Create a conda environment in `Settings/Project Code/Project Interpreter`, on the right `Add
  interpreter`. Select the Python version and enter the environment name (follow Python naming
  conventions, lowercase, underscore). There doesn't seem to
  be a way to export an `environment.yml` file. Export it from the terminal `conda env export >
  environment.yml`
* Alternatively, create `Requirements.txt` from `Tools/Sync Python Requirements`

# 4. Code Quality

* Set breaking points in the same way as IntelliJ
* Create a test in the same way, right-click a class/method, but then follow `Go to > Test`. It uses
  `from unittest import TestCase`

# Setup a Project

This is not on the videos. After watching all the lessons and playing with PyCharm, I learned
that it doesn't create any project structure in the same way that IntelliJ does.

Follow the structure as seen in [this](https://dev.to/codemouse92/dead-simple-python-project-structure-and-imports-38c6) blog post. Author of a book "Dead Simple Python".

Create this structure (omit the words in parentheses):

    github_repo
        README.md
        .gitignore
        project_name (package)
            app.py
            __main__.py
            src (package)
            data (package)
            tests (package)

**More details below**

Create a repo and clone a local copy. Add a `README.md`, and `.gitignore`

    README.md
    .gitignore

Create a new PyCharm project at the above repo location.

Create a conda environment in PyCharm (usually set when creating a new project).

Create a package with the name of the project.

    project_name

Inside `project_name` create the files:

    app.py
    __main__.py

Then right click `app.py` to run the file that has the initializing environment. The `__main__.
py` is used to run with Python directly as `python -m project_name` or right-click this file to
run in PyCharm.

    from project_name import app
    
    if __name__ == '__main__':
        app.run()

Inside `project_name` create packages for:

    src
    data
    tests

For `src` package, right-click, Mark Directory as Sources Root. Add source files here.

For `tests` package, right-click, Mark Directory as Test Sources Root. Add tests here.

Let's say there is a file in `src` called `calculator.py` with a class `Calculator`.

In `app.py` the import should be `from project_name.src.calculator import Calculator`.

Creating a test is different from IntelliJ, which was to right-click on the class, context actions,
create test. In PyCharm after right-click on the class, select `Go to > Test > Create new test`.
It should detect the target directory as `tests`.  
