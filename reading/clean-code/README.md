# 3. Functions



# 10. Classes

* Classes should be small and have a single responsibility `SRP: Single Responsibility Principle`
* The name of a class should describe its responsibility
* If the name is too ambiguous then it's more likely to have many responsibilities
* As exercise, describe a class in a few words. If you use a lot of 'and', 'or', 'if', then it has too many responsibilities.
* Two different activities: getting software to work, making software clean
* High cohesion: classes should have fewer instance variables, each method in the class should use those variables. The methods and variables of the class are co-dependent.
  * Break larger classes into classes/methods that have high cohesion
  * A method doesn't use one or more variables? Add it to a new class with the corresponding cohesion/responsibility.
* Refactoring a class
  * Write a test suite that verifies the precise behavior of the original program
  * Make many small changes, after each change, verify the behavior wasn't changed
* A class should be open to extend and closed from modification `Open-Closed Principle`
  * Such as a superclass `Shape` that can be extended to `Square` or `Circle`
  * However, the superclass should be closed from modification
* A class should depend on abstractions and not specific details `DIP: Dependency Inversion Principle`
  * For example a stock Portfolio class depending on an external TokyoStockExchange API
  * Instead, create a testable implementation of the abstraction StockExchange interface that emulates TokyoStockExchange
  * A test can be created to assert the value of an exchange locally (table lookup) without having to test a value from connecting to the API

# 17. Smells and Heuristics

**Comments**

* Comments in code should describe a technical detail that cannot be described by the code.
* Don't add redundant comments that are described by the code.
* Review spelling and grammar.
* Remove commented-out code (...that was previously committed).

Redundant comment of a Javadoc:

    /** Starts the app */
    public static void startApp()

Redundant inline comment:

    private static String firstName; // the first name

**Environment**

* Build a project in short and simple to follow steps
* Run all unit tests with one command

**Functions**

* It's better to have fewer arguments, if possible none or no more than 3.
* Avoid boolean arguments, instead change the state of the object that was called
* Remove functions that are not called.

**General**

* Avoid many languages in one source file or try to reduce the number of languages in one file. For example mixing Java, JS, HTML, all in one source file.
* Implement the behavior of a function/class in a way that another programmer should expect.
* Write tests for corner cases and boundary condition, instead of relying on intuition.
* Don't turn off compiler warnings or failing tests.
* Don't repeat yourself (DRY). Replace switch/case or if/else that test the same conditions with polymorphism
* Separate high level from lower level concepts of abstraction. Variables/functions that belong in detailed implementation, should not be in the base class.
* Base classes shouldn't depend on their derivatives. Also deploy each in different files.
* A class shouldn't have too much information. Fewer methods in a class. Fewer variables in a function.
