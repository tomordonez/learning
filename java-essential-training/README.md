# 1. What is Java

* JDK = JRE, JVM
* Follow conventions for naming classes, methods, variables, constants
* Managing memory: Minimize number of objects created, use system methods that
    report memory usage or with IntelliJ.

# 2. Get started with Java

Using command line:

* Use `jshell` to try things out
* Source `.java` files are compiled to bytecode `.class` files
* Always compile from `src` directory such as `javac com/company/Main.java`
* Run file as `java com.company.Main`

Pass arguments in IntelliJ

* Run/Edit configurations
* Program arguments

# 3. Declare and manage variables

* Inferred data types for primitives using `var`
* Use wrapper classes for primitives like `Double.parseDouble(stringValue)`
* An object's default value is `null`
* Manage currency values with BigDecimal from a string value like `new
    BigDecimal(stringValue)`
* Use casting like `(short) longValue` to convert among primitives but there
    might be loss of data.
* Use the `Math` class to round values and other operations.
* A default boolean value is set to `false`
* A default primitive numeric value is set to `0` like `int intValue;`

# 4. Manage String values

**Strings are immutable**

* Concatenating a String will not modify the current String like `String s1 =
    "java"; s1.concat(" rules");`. Printing `s1` will return `java` and not
    `java rules`. However a new String object is created with `java rules`
    without a reference. The new object remains in an area of memory called
    String constant pool. Running `s1.concat(" rules")` on jshell will output
    `$2 ==> "java rules"` and typing `$2` will return such String object.
* Use `StringBuilder(stringValue)` to create a String object like
    `StringBuilder s2 =
    new StringBuilder("java"); s2.append(" rules);`. Printing `s2` will return
    `java rules`. Although, the append method will still create an additional
    object to the String constant pool.

**Convert primitive values to strings**
* Concatenate a primitive number with a string to get a string
* `int result = 5; String answer = "The answer is " + result;`

**Format numeric values as strings**
**Interpolate strings with placeholders**
**Compare string values**
**Parse string values**
**Get string values from user input**

# 5. Manage program flow
# 6. Debugging and exception handling
# 7. Create custom classes
# 8. Work with inheritance
# 9. Manage data collections
