# 1. Classes and Objects

**Using classes as blueprints**

* Create a `Tree` class
  * Add an enum field for `treeType`
  * Add double fields for `heightFt`, `trunkDiameterInches`
  * Add a function `grow` that increases height by 10 and diameter by 1

**Building objects with a constructor**

* Create a `Tree` constructor
* Create a `Main` class
* Create a Tree instance
* Print the tree type

**Using concrete instances for application logic**

* Print a message if the tree's height is > 100
* Create another tree instance, shorter, and wider
* Do another height comparison
* Create a function in `Tree` to print if a tree is tall (greater than 100 ft)

**Class vs instance members**

* Instance members are not static, must be accessed from the object's instance
* Class members are static, they are accessed from the class, not from an instance
* Create a class member of type `Color` with reference variable in uppercase
* In `Main` access the color attribute
* Create a static method in `Tree` to print out a message

**Built-in Java class**

* Read the source code of `Color` class
* In `Main` create a default white color variable using a static member
* Create a blue color variable using a static method

**Build an employee class**

* Create an Employee class
* Attributes: name, age, salary, location
* Behavior: raiseSalary
* Create a Main class
  * Build two instances
  * Give an employee a raise
  * Display salary of both employees

# 2. Encapsulation

**Access modifiers**

* Public: visible anywhere in the program
* Private: visible in the class
* Protected: visible to the package and subclasses
* No modifier: visible in the package

**Implement encapsulation with access modifiers**

* Set fields to private in Tree class
* Create getters
* Use them in `Main` to print each field
* Create a `grow` method in Tree to change the height
* Create setters

# 3. Inheritance
# 4. Polymorphism
# 5. Abstraction