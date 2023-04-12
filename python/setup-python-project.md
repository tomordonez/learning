# Set up a Python project

Set up a Python project in PyCharm or VSC.

## Project structure.

* Packages (directories should be lowercase without underscores).
  * Tests package (details below in "Set up unit tests")
* Modules (files should be lowercase with underscores).

Ignore the text in parentheses.

    Course Name/
        README.md
        Code/
            s1sectionname/ (package)
                exercisename/ (package)
                    app.py
                    __main__.py
                    src/ (package)
                        class-file (py file)
                    tests/ (package)
                    data/ (package, if needed)
                
                otherexercisename/ (package)

            s2othersectionname/
                ...

## Set up `app.py`

Inside `app.py` import other packages like this:

    from s1sectionname.exercisename.src.class-file import ClassName

    run():
        pass

## Set up `__main__.py`

Inside `__main__.py`. Enter the following:

    from s1sectionname.exercisename import app
    
    if __name__ == '__main__':
        app.run()

## Run the app:

**In PyCharm**

* Right click/run `__main__.py`

See more details about [setting a project in PyCharm](https://github.com/tomordonez/learning/tree/main/python-pycharm#setup-a-project).

**In VSC**

* Open the terminal, go to the root directory. In above example this would be `cd Code`
* Run as a module `python -m s1sectionname.exercisename`
* If you Right-click/run `main`, most likely you get `ModuleNotFoundError` if the imports use absolute paths.

**In the Terminal**

* Use absolute paths in the import
* Run the same as VSC above

## Set up unit tests

**In PyCharm**

Create a `tests` package directory by going to a class. Right-click. `Go to` and select `Test`.

* Create a test case per class
* Import `from unittest import TestCase`
* Import `from unittest.mock import Mock, patch`

**In VSC**

Full details in `courses/python-tdd/`