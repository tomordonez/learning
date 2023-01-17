# SOLID Principles

Course on Linkedin Learning. [Learning SOLID Programming Principles](https://www.linkedin.com/learning/learning-solid-programming-principles)

The author uses Python for examples.

## 0. Introduction

**Five principles**

The author says the most pragmatic order is:

1. Interface segregation
   1. Classed depend on the smallest interface
   2. Helps design good classes
   3. Helps write unit test cases
   
2. Liskov substitution
   1. Objects of some superclass can be replaced with objects of any subclass
   2. Constrains subclass design
   3. Helps design good polymorphism
   
3. Open/Closed design
   1. Open to extension: adding subclasses as needed
   2. Closed to modification: avoids changing the code to handle new situations
   
4. Dependency inversion
   1. A direct dependency on a concrete class needs to be inverted to be indirect
   2. Depend on abstract classes or interfaces
   3. Avoid concrete class name dependencies
   
5. Single-responsibility
   1. After applying previous principles. Class has one responsibility
   2. Follow-up questions:
      1. At what level of abstraction?
      2. How are the responsibilities counted?

**My understanding of these principles**

Based on current knowledge up to the current commit.

* Software needs to be written in OOP
  * Once an interview feedback said that the candidate wrote all the code in `main` and didn't seem inclined to use functions or even classes.
  * Software cannot be a one giant script. Break it down into classes. Classes must have methods. One of these files should have the main entry point. I assume in a coding interview, if you can't create many files. Then have one file and add all classes to it to simulate the individual files.

* Visualize software structure with a class diagram, even without all the formal UML syntax
  * A class diagram is a great way to visualize how the software is to be structured. Even without all the formal UML syntax, a drawing describing the class name and its attributes/operations, and connecting lines among classes, where each line could say "is a" (generalization. A SalesPerson is a Person) and "has" (composition. A Computer has Component). "is a" has an arrow-ended line, while "has" is a diamond-ended line.
  * From this diagram, you can tell which classes inherit from others like `class SalesPerson(Person)`

* Abstracting functionality
  * From Java I learned that the order of abstraction should be from interface down to abstract class down to implementation of the class.
  * Use an abstract class if there are different ways to implement such feature. Like `BreakfastMaker`. There are many ways of making breakfast, assuming that you can eat almost anything for breakfast. Implementation of this abstract class could be `BreakfastCerealMaker` or `BreakfastEggsMaker`.

* A class should do one thing and do it well
  * Low coupling: A class should have low dependencies on other classes. If a class depends on five other classes. Changing this class means changing five other more. That sounds like a lot of work. This might also be the reason for writing mock tests, which I still don't grasp quite well. If the software depends on an API but you can't connect to it. Then how do you know the functionality even works?
  * High cohesion: A class should have all attributes and methods "glued" well
  * A class like `BreakfastCerealMaker` inherits from `BreakfastMaker` and it should describe how to make cereal, but it shouldn't describe how to also make waffles, or how to buy the cereal.

* A class should have private attributes
  * Java enforces this well with the `private` keyword. Python has weird ways to lightly enforce privacy.
  * The subclass shouldn't be able to access private attributes from the superclass

* Classes should be small (or smaller than longer)
  * I find it generally easier to identify responsibilities that can be extracted, which would make the class shorter, and harder to think how a solution should be optimized. It requires a lot of experience and practice to find an appropriate solution

* An object could have many forms (polymorphism in plain terms)
  * At compile time, the constructor can have different signatures with specific parameters or using `*args`
  * At runtime, a class method can be overriden to implement an inheritance

* Simplify repeated code
  * When you seem to write the same code all over, this can be refactored with a method or other artifact.

* Write tests to validate the features
  * If I were to convince someone to write tests, I would write a class `Discount` to calculate the total price of a product where a method `calculateDiscount` could calculate it as `price * (1 - discount)`. However I will make the case that a developer could mistakenly type the multiplication symbol twice as `price ** (1 - discount)`. If a retailer buys computers at $2000/ea from a seller at 20% discount. `price * (1 - discount)` is $1,600, while `price ** (1 - discount)` is $437. This is a $1,163 difference. If the buyer was buying 100 computers. This would be a ~ $100K loss from the seller. A simple unit test that checks the correct operation could avoid this giant price mistake. Then replicate the problem with every other feature and estimate the impact as a function of value (time or money) on the lack of other tests.

**Use case**

* The course has a use case of a software used to find a correlation in a dataset

## 1. Interface Segregation (I)

**Intro**

* No client should be forced to depend on methods it does not use
* A client should depend on the smallest set of interface features
* The fewest methods and attributes
* What can go wrong?
  * Client bound to irrelevant methods

**Use case**

Interface segregation distinct verbs
* Main has to
  * Read samples
  * Analyze samples

Conceptual classes
* Sample: foundational object we're working with
  * This was a list of samples, and each sample was a dictionary
  * Created a SampleList wrapper for `list[Sample]` with fewer built-in list methods
    * Narrows the interface to only those methods in this class
* Reader: reads a collection of Sample instances from a source file
  * This class had a read method for csv and a Sample factory for each row
  * Created a SampleBuilder class to create the samples, this class can be customized to different csv formats or source files.
* Analysis: performs analytics on a collection of Sample instances
  * This was a Correlation class with all the computations

**Identifying interfaces**

* The problem domain behaviors
* Methods for building objects
* Persistence processing to save objects
* GUI view and control
  
## 2. Liskov Substitution (L)

**Intro**

* Replace objects of a superclass with objects of any subclass without breaking that program
* The behavior of a subclass should be as correct as the behavior of the superclass
* Example
  * Create an abstract class and implement it
  * An abstract class Reader with read method
  * Implement reading different types of files using this method
* Late binding
  * Choice made at runtime
  * In main, depending on the type of file, a subclass is chosen to open it

**Duck Typing**

* Alternative to creating an abstract class
* Two objects with the same methods and same attributes behave like subclasses of a common superclass
* In Python use the keyword `Union`
* Create a class for each type of file reader
* Then `Reader = Union[CSVReader, JSONReader`
  * Either of the two implementations meet the requirements of the `Reader` interface
* However, there is no inheritance
* Alternatively implement a class using the type `Protocol`

**Interface variations**

* When the use case for a subclass requires to add more parameters and a parameter is added
* It won't match the signature of the superclass and an exception is raised
* Rethink if this is distinction is necessary or push the distinction up to a superclass
  * Add a method unique to this subclass
  * Use default parameters that are optional
    * In Python use keyword parameters
    * `def read(self, *, table_index: int = 0) -> None`
    * The `*` means that the parameter name is required like `reader.read(table_index=1)`

Note:

* Python can't check subclass methods for compatibility with superclass methods
* No language can check the implementation to be sure the subclass meets the superclass semantics
* Only unit tests can validate Liskov substitution

**Avoiding isinstance()**

Use type annotation and mypy, instead of checking that an object `isinstance` of the class.

Instead of this:

    class Correlation:
        def __init__(self, reader):
            if not isinstance(reader, Reader):
                raise TypeError(f"{reader} must be a Reader")
            self._samples = reader.samples

Do this:

    class Correlation:
        def __init__(self, reader: Reader) -> None:
            self._samples = reader.samples

*My understanding*
* Compared to Java where you define the types of everything, you can clearly see what is the type of a parameter or a function. At compile time, it also checks if you incorrectly initialized an object with the wrong type.
* In Python there is no such static typing initializing a class, unless you use dataclass or type annotation (type signature).

Instead of this:

    class Dog:
        def __init__(self, name):
            self._name = name

To this, you define the parameter with a type:

    from dataclasses import dataclass

    @dataclass
    class Dog:
        _name: str

Or using parameters with types.

    class Dog:
        def __init__(self, name: str) -> None:
            self._name = name

        def add(hot: str, dog: str) -> str:
            return hot + dog

Which is similar to Java:

    public class Dog {
        public Dog(String name) {

        }
        public String add(String hot, String dog) {}
    }

**Conclusion**

Be sure every subclass can replace its superclass
  
## 3. Open/Closed Design (O)
## 4. Dependency Inversion (D)
## 5. Single-Responsibility (S)