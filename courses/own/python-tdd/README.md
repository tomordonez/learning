# Unit Testing and TDD in Python

From this Linkedin Learning course. [Unit Testing and TDD in Python](https://www.linkedin.com/learning/unit-testing-and-test-driven-development-in-python)

## Setup Testing in VSC

This is not in the course.

Side note on PyCharm vs VSC. PyCharm is like going to a sushi bar. They have sushi and they specialize in sushi. VSC is like a strip mall restaurant that has so many themes like pizza, burgers, tacos, pasta, they aren't sure what to sell, so they sell everything. PyCharm is made for Python. VSC is made for anything and it has these odd configuration ways to add Python libraries.

Back to topic. I followed these resources:

* VSC docs on Python testing [here](https://code.visualstudio.com/docs/python/testing#_example-test-walkthroughs) * Stackoverflow answer about `unittest` not finding test files in a project, [here](https://stackoverflow.com/a/5089954)
* Python docs about Test Discovery, [here](https://docs.python.org/3/library/unittest.html#test-discovery)

**The top level directory of the project must be a Python package**

A Python package is basically a directory with the file `__init__.py` (this file can be empty).

Given this directory, where Python test files have the prefix `test_something.py`

    awesomeproject/
        src/
        tests/
            test_something.py

The top level directory `awesomeproject` should be a package. Create the file `__init__.py` inside these directories.

    awesomeproject/
    __init__.py
        src/
            __init__.py
        tests/
            __init__.py
            test_something.py

**Configure Tests**

* Go to the Command Palette `Ctrl Shift P` and type `Python Configure Tests`
* Alternatively, go to the Testing module (beaker icon, left margin) and click `Configure Python Tests`
* Select `unittest`
* Select the location of the test folder. By default it only shows the top-level directories in the workspace. In above example it should show `awesomeproject`
* Select the prefix to find test files with this format. For example select `test_*.py`

This updates the `settings.json` file in the workspace:

    {
        "explorer.autoReveal": true,
        "python.testing.unittestEnabled": true,
        "python.testing.unittestArgs": [
            "-v",
            "-s",
            ".",
            "-p",
            "test_*.py"
        ]
    }

**Tests are not found***

In the beaker module it says "No tests have been found in this workspace yet".

I had this problem. My workspace top-level directory was three levels up. I didn't want to make those folders Python packages because they were not related to Python.

    mytoplevel/
        2ndlevel/
            3rdlevel/
                awesomeproject/

Finding tests in a project can be checked in the terminal using this command with `-v` (verbose), `-s` (directory to start discovery with `.` as default), `-p` (using pattern in this case `"test_*.py`):

    python -m unittest discover -v -s . -p "test_*.py"

If you are outside of `awesomeproject/` and you run this command, given that this directory is a Python package, then it will find the test files.

    $ pwd
    /home/.../3rdlevel
    $ ls
    awesomeproject
    $ python -m unittest discover -v -s . -p "test_*.py"
    test_something ...ERROR
    Ran 1 test in 0.000s
    FAILED (errors=1)

Modify the `-s` flag to set the correct directory if you are levels outside of the project directory.

    $ pwd
    /home/.../2ndlevel
    $ ls
    3rdlevel
    $ python -m unittest discover -v -s ./3rdlevel -p "test_*.py"
    test_something ...ERROR
    Ran 1 test in 0.000s
    FAILED (errors=1)

In VSC change the `settings.json` to set the correct `-s` directory. In my example:

    {
        "explorer.autoReveal": true,
        "python.testing.unittestEnabled": true,
        "python.testing.unittestArgs": [
            "-v",
            "-s",
            "./mytoplevel/2ndlevel/3rdlevel/",
            "-p",
            "test_*.py"
        ]
    }

You can also add multiple directories. Like this example:

I have this directory structure:

    learning/
        java-oop/
        learning-python/
            Code/
                __init__.py
                src/
                tests/
                    __init__.py
                    test_helloworld.py
        python-koans/
            python3/
                koans/
                    __init__.py
                    about_classes.py
        python-tdd/
            Code/
                s1overview/
                    __init__.py
                    src/
                    tests/
                        __init__.py
                        test_fizzbuzz.py

In `settings.json`

    "python.testing.unittestArgs": [
            "-v",
            "-s",
            "./learning/python-tdd/Code/",
            "-s",
            "./learning/learning-python/Code/",
            "-p",
            "test_*.py"
    ]

I could add `python-koans` as well, although it uses the `sniffer` program to auto run the tests in the terminal. The tests have a different prefix `about_*.py`.

In `settings.json`

    "python.testing.unittestArgs": [
            "-v",
            "-s",
            "./learning/python-tdd/Code/",
            "-s",
            "./learning/learning-python/Code/",
            "-p",
            "test_*.py",
            "-s",
            "./learning/python-koans/python3/",
            "-p",
            "about_*.py"
    ]

**Run tests**

Run from the gutter on the test file or using the beaker icon

## 1. Overview

**What is unit testing**

Levels of testing:
* Unit testing: function level
* Component testing: library and compiled binary level
* Systems testing: External interface of a system or subsystem
* Performance testing: System level to verify acceptable timing/resource usage

**What is TDD**

The usual TDD intro, plus 3 laws of TDD from Clean Code, reversing the prose so it's easier to read:

* Write a failing unit test, then write production code
* Write a test small enough to fail, including compile failing
* Write production code small enough to pass the test

**FizzBuzz Kata**

This video is in PyCharm using pytest. I used VSC with unittest. First I tried my own implementation with commits for every passed test. Then watched the video to compare. Finally I optimized my test case based on the video.

Code in `Code/s1overview/`.