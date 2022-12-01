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

For example, formatting the number `10_000.53;` to have commas like `10,000.53`.

    import java.text.NumberFormat;
    
    var doubleValue = 10_000.53;
    var numF = NumberFormat.getNumberInstance();
    System.out.println(numF.format(doubleValue));

Other methods:
* `NumberFormat.getIntegerInstance()`
* `NumberFormat.getCurrencyInstance()`
* `NumberFormat.getPercentInstance()`

Format the number using a locale for a specific country. For example in Latin America you use periods for thousands, and commas for decimals. The Locale constructor requires two string parameters for the language and country.

Get a list of available languages and countries:

    System.out.println(Locale.getISOLanguages());

This returns an object so wrap the array to string:

    System.out.println(Arrays.toString(Locale.getISOLanguages()))
    System.out.println(Arrays.toString(Locale.getISOCountries()))

Then create the Locale object to format `10_000.53` to Latin American format `10.000,53`

    var locale = new Locale("es", "CO");
    var numES = NumberFormat.getNumberInstance(locale);
    System.out.println("Number " + numES.format(doubleValue);

Format a number with two decimals using the pattern `$0.00`

    var decimal = new Decimal("$0.00")
    System.out.println("Price: " + decimal.format(3.4555));
    // Output: $3.45

**Interpolate strings with placeholders**

* Use placeholders `%s` or `%f` or similar in a string template. Use `%.2f` to print two decimals.
* Then use `String.format()` passing the template and the objects or variables corresponding to the placeholders.

**Compare string values**

* Strings aren't compared with double equal operator but using the string method `String.equals()`, otherwise you might be comparing references to the same object.

**Parse string values**
**Get string values from user input**

# 5. Manage program flow
# 6. Debugging and exception handling
# 7. Create custom classes
# 8. Work with inheritance
# 9. Manage data collections
