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

* Create a `Newspaper` class
* Print the instance of two objects Book and Newspaper
* Compare if a Book instance is an instance of Book
* Compare if a Book instance is an instance of the object class

**Class methods and members**

In `Book` class
* Create a class attribute `BOOK_TYPES` with tuple values: Hardcover, Paperback, Ebook
* Initialize this attribute and check that a valid value is passed, otherwise raise a ValueError
* Create a class method with `@classmethod` that returns the book types list
* Print the book types using this method
* Keeping track of a list of books
  * Implement a singleton design pattern (only one instance of a variable or obj is created)
  * Instead of creating a global variable, encapsulate the behavior in the Book class
  * Create a private `__booklist` variable and create a static method that accesses this behavior
    * Initialize to `None`
  * Create a static method `get_book_list`
    * Check if the `__booklist` is None then create a new one, else return the existing one.
    * In main, use the reference of the static method in `thebooks` variable
    * Append books to this list
    * Print the books

# 2. Inheritance and Composition

Code: `S2_Inheritance`

**Understanding inheritance**

* Create 3 classes:
  * Book: title, price, author, pages
  * Magazine: title, price, period, publisher
  * Newspaper: title, price, period, publisher
* Refactor repetitive code
  * Create a class Publication
    * Book inherits from this class
    * Create a class Periodical that inherits from this class
      * Magazine and Newspaper inherit from this class

**Abstract base classes**

* Create a super class `Shape` with a method to calculate the area
  * Prevent from being instantiated
  * Import `ABC` and `abstractmethod`
  * Inherit class from `ABC`
  * Use `@abstractmethod` decorator for `calculate_area`
    * No implementation `pass`
    * Each subclass has to override this method
* Create subclasses and enforce they use the `calculate_area` method
  * `Circle`: radius
  * `Square`: side

**Using multiple inheritance**

* Create two classes
  * Add an attribute or method with the same name
* Create a third class that inherits from the two above
* In main, create an object (from third class)
  * Calling the attribute, will print the attribute from the first class only.
  * This is based on `MRO` (method resolution order), in the order in which they are defined in 
    the subclass, from left to right
  * See an object's MRO with `obj.__mro__`

My example:

* Superclasses: Superhero, Human
* Subclasses: Avenger

**Interfaces**

* Python doesn't have a built-in interface feature
  * As seen in Stackoverflow [here](https://stackoverflow.
    com/questions/372042/difference-between-abstract-class-and-interface-in-python). The 
    Java-style distinction between abstract and interface doesn't exist. The only difference 
    would be the stated intent in the docstring
* In the `Shape` example
  * Create an abstract class `JSONify`
    * Create an abstract method `toJSON`
  * In the `Circle` class, inherit `JSONify`
    * Implement the `toJSON` method. Create a JSON representation of the object
      * `{"Circle": area}`

**Understanding composition**

* An object `has` another
* A Book (title, price, author) has an Author (first_name, last_name)
* Create a Book class
  * title, price, author_first_name, author_last_name, chapters []
  * Create an instance method `add_chapter` (name_of_chapter, number_of_pages)
    * Append a tuple
    * name_of_chapter can be "Ch1", "Ch2", etc.
* Refactor
  * Extract author info in another class
    * Override the repr method to return first_name, last_name
  * In Book use as a parameter an author object
  * Extract chapter in another class
  * In Book create a book page count (based on pages by chapter)
  * In add_chapter use as parameter a chapter object

# 3. Magic Object Methods

Code: `S3_Magic`

**What are magic methods**

* Define how objects are represented as strings
* Control access to attribute values for get and set
* Allow objects to be called like functions


**String representation**

* Create a Book class with title, author, price, discount
* Override the `__str__` function
  * "Title by Author $price"
* Override the `__repr__` function
  * "title={title}, author={author}, price={price}"
  
**Equality and comparison**

* Create two Book objects with same values and print their comparison (should be false)
* Override the `__eq__` method:
  * Check if the other object is an instance of Book
  * Compare if the values of self are equal to the values of the other object
  * Compare two objects (with same values) again
  * Compare a Book object with an integer, should get the value error exception
* Override the `__ge__` (greater than or equal to) method
  * Check if other object is an instance of Book
  * Compare prices of two objects
  * Print the comparison as `b1 >= b2`
* The `sort` method uses the `__lt__` (less than) method
  * Create 4 book objects
  * Append books to a list
  * Apply the `sort` method and print using list comprehension
  
**Attribute access**

* Use `__getattribute__` when an attribute is retrieved
  * Don't directly access the attribute name or a recursive loop is created
  * Override with the object and the name of the attribute
  * You can perform operations on an attribute before it gets returned
  * Check if the name is `price` (for this example)
    * You can't access `self.name` or it will create a recursive loop
      * This calls `self.__getattribute__` inside the already override of `def __getattribute__(self)`
    * Call super `price = super().__getattribute__("price")`
    * Call the same for `discount`
    * Return the price with the discount
  * Else
    * Return the super attribute with name
  * When you print the object, with `__str__` override that has price, it will return the discounted price
* Use `__setattr__` to modify an attribute's value
  * Example: When a discount is used, format the result in decimals
  * Use the parameters `name` and `value`
  * Check if the name is `price`
    * Check if the type for `value` is float, otherwise raise an error
  * Return super with name and value
  * In main set the price `book.price = 40` and print book should raise the error
  * Pass the error by casting `float(40)`
* Use `__getattr__` when `__getattribute__` lookup fails
  * Comment out the previous `__getattribute__` override
  * Pass the parameter `name`
  * Return that the `name` doesn't exist
  * In main print `book.publisher` should return the above error
  * More about the difference between `getattr` and `getattribute` in this stackoverflow [link](https://stackoverflow.com/a/3278104)
  
**Callable objects**

* Use the `__call__` method to call the object like a function
  * Take the same parameters as `init`
* Call the object and change the values
  * Example: `book("Book name", "book author", 40, 1.10)`
  
# 4. Data Classes

Code: `S4_Class`

**Defining a data class**
**Using post initialization**
**Using default values**
**Immutable data classes**

