# Details

LinkedIn Learning. "Python Object-Oriented Programming". Link [here](https://www.linkedin.
com/learning/python-object-oriented-programming)

# 1. Object-Oriented Python

Code: `S1_OOP`

**Basic class definition**

* Create a `class` called `Book`. Use parenthesis if it inherits from another class
* Override the builtin `init` function with `def __init__(self, title)`
  * This is the initializer function (Python way of saying the constructor)
  
**Instance methods and attributes**

* Initialize the Book class with: `title`, `author`, `number_of_pages`, `price`
* Create the instance method `get_price`
  * Use the `hasattr` function to check if `_discount` was set
  * If set then return the discounted price
* Create the instance method `set_discount` with an internal attribute: `_discount`
* Create a private attribute `__secret`. Python uses name mangling to prevent subclasses from 
  overriding this attribute. When it's called on an object it modifies its name to `_Book__secret`

More about leading underscore `_variable` (not in the video)
* According to [this](https://dbader.org/blog/meaning-of-underscores-in-python) blog post, about 
  the meaning of underscores in Python.
* The leading underscore is equivalent to the `private` keyword in Java, a variable for internal 
  use.
* Although the underscore is a convention, and it doesn't change the behavior of the program.

Here is an explanation about the purpose of the double underscore aka dunder as in `__init__`
* In [this](https://amontalenti.com/2013/04/11/python-double-under-double-wonder) blog post
* The dunder (double underscore) is reserved for the Python core team
* Not recommended to use the dunder for your own methods
* Not recommended to call them "magic methods"

**Checking instance types**
**Class methods and members**

# 2. Inheritance and Composition

Code: `S2_Inheritance`

**Understanding inheritance**
**Abstract base classes**
**Using multiple inheritance**
**Interfaces**
**Understanding composition**

# 3. Magic Object Methods

Code: `S3_Magic`

**What are magic methods**
**String representation**
**Equality and comparison**
**Attribute access**
**Callable objects**

# 4. Data Classes

Code: `S4_Class`

**Defining a data class**
**Using post initialization**
**Using default values**
**Immutable data classes**

