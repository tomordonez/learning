# Python with VSC

From the Linkedin Learning course "VSC for Python Developers". [Link](https://www.linkedin.com/learning/visual-studio-code-for-python-developers)

## Personal Settings

These settings are not in this course.

**Create packages like in Pycharm**

* There isn't an option to right-click create a Python package like in Pycharm
* Solution:
  * Create a New folder and inside create an empty `__init__.py` file
  * If you run the app by right-click/run, the imports must be relative
  * If you run the app from the terminal, the imports can be absolute or relative, depending where you run the app from. If code is in `a_root_folder` with contents `src/` and `__main__`.
    * If you are one level above root folder, use absolute imports so you can run `python -m a_root_folder`
    * If you are inside the root folder, use relative imports so you can run `python __main__.py`

**Installed extensions**

* Material Theme
* Github Pull Requests and Issues
* Python

**Preferences Settings**

With `Ctrl+Shift+P`, open the `Open User Settings JSON` file.

Added these changes:

    {
        "workbench.colorTheme": "Material Theme",
        "files.autoSave": "onFocusChange",
        "editor.cursorSurroundingLines": 20,
        "editor.fontSize": 14,
        "editor.lineHeight": 26,
        "editor.fontLigatures": true,
        "terminal.integrated.fontSize": 14,
        "window.zoomLevel": 1.0,
        "explorer.decorations.badges": false,
        "workbench.editor.wrapTabs": true,
        "python.condaPath": "/home/tom/miniconda3/bin/python",
        "python.autoComplete.extraPaths": [
        
        ],
        "python.analysis.extraPaths": [],
        "editor.tokenColorCustomizations": {
            "[Material Theme]": {
                "textMateRules": [
                    {
                    "scope": "markup.raw.block.markdown",
                    "settings": {
                        "foreground": "#C792EA",
                    }
                    },
                    {
                        "scope": "markup.inline.raw.string.markdown",
                        "settings": {
                        "foreground": "#C792EA",
                        }
                    },
                    {
                        "scope": "markup.heading.markdown",
                        "settings": {
                            "fontStyle": "bold",
                        }
                    }
                ]
            }
        },
        "git.autofetch": true
    }

## 1. Overview

* Select Python interpreter
  * `Ctrl+Shift+P`
  * Python select interpreter
  * Alternatively, opening a Python file, on the IDE bottom right, it shows the interpreter selected. Click that field to change to another one.
  * Using my `base` conda environment
    * For another environment. Create a new conda env or use an `environment.yml`

* Create a Hello program and run to see the output
  * Created a class and ran main
  * Imported the class with relative paths to avoid the notmodulefound error


## 2. Code Editing

* Use `Ctrl + Space` to activate Intellisense on a line to see an object methods
* On automcomplete use snippets as code templates
* Use the REPL (python shell) by selecting lines and press `Shift+Enter`
* Install PEP8
  * `pip3 install autopep8`
    * Instead I installed to my conda env with `conda install autopep8`. Although this requires the interpreter to be set to that conda env.
    * Find the path `which autopep8`
  * Go to Preferences/Settings, search for Python formatting
    * Scroll down to Path and enter the path found above
    * Scroll down to Provider and select autopep8 
  * In Settings, search for `formatonsave` and enable
  * In comparison to PyCharm, the formatting there shows up as warning popups that you have to click to fix. In VSC, when you save the file, then PEP autoformats the file.

**Refactoring**
* Rename
  * Right click it shows `Rename symbol`. 
  * If the change doesn't work, choose to install the `rope` library globally
* Extract
  * Select a statement or a line, right-click `Refactor` a popup shows to extract method or variable

## 3. Code Debugging
## 4. Coding Extensions