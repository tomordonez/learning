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
    `java rules`. However, a new String object is created with `java rules`
    without a reference. The new object remains in an area of memory called
    String constant pool. Running `s1.concat(" rules")` on `jshell` will output
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

* Find the position of a string with `indexOf`, trim whitespace with `trim`, use `substring` with either a start value or start and end values.

**Get string values from user input**

Use the scanner class to capture user input in the command line

    var scanner = new Scanner(System.in);

Use `nextLine()` to capture input until enter is pressed.

    System.out.println("Enter your name: ");
    var name = scanner.nextLine();

Convert a string to date and get the age from a birthdate.

    System.out.println("Enter your birthdate: ");
    var birthdateString = scanner.nextLine();

    try {
        var birthdate = LocalDate.parse(birthdateString, DateTimeFormatter.ofPattern("MM-d-yyyy"));
        var age = LocalDate.now().getYear() - birthdate.getYear();
        System.out.printf("You are %s years old", age);
    } catch (Exception e) {
        System.out.println("Wrong format, enter birthdate as MM-DD-YYYY")
    }

**A simple calculator**

The example problem was to get user input from the command line for two numbers, then divide them and print the result. I added JUnit tests and followed TDD.

* Switched the project to Maven. Right-click the project root, add framework support, select Maven.
* Add JUnit to `pom.xml` with `Alt+Insert`, add dependency, search for `org.junit.jupiter:junit-jupiter`, click add, at the top right load maven changes.
* Created a `Calculator` class
* Created an empty `divide` method
* Created a test for this class and method (right click on class name, show context actions, create test)
* Modified the test to assert that `divide(4, 2)` equals `2`
* Ran the test to see it fails
* Implemented the `divide` method

# 5. Manage program flow

**Evaluate conditions with if-else**

Just the usual if else

    if (namorBirthYear > ThorBirthYear) {
        System.out.println("Namor is older");
    } else {
        System.out.println("Thor is older");
    }

Not on the video. Here is the shorthand if else, aka ternary operator

    var result = (namorBirthYear > ThorBirthYear) ? "Namor is older" : "Thor is older";
    System.out.println(result);

**Evaluate conditions with switch-case**

Just the usual switch/case/default

    switch(parameter) {
        case parameter1:
            // do something
            break;
        case parameter2:
            // do something
            break;
        default:
            // do something else
    }

Not on the video here is the switch enhanced, which IntelliJ gives a warning to refactor to. It uses the arrow: dash with greater than sign `->` and it doesn't need the `break` keyword.

    switch(parameter) {
        case parameter1 -> // do something
        case parameter2 -> // do something
        default -> // do something else
    }

**Create looping code blocks**

Use the typical for loop:

    for (var i = 0; i < variable.length; i ++) {
        // do something like
        System.out.println(i);
    }

Iterating an array using for each:

    String[] months = {"January", "February", "March"}
    for (var month : months) {
        System.out.println(month);
    }

**Create reusable code with methods**

* Refactor/Extract/Method

**Create overloaded methods**

Create methods with the same name but different signature

    private static int addValues (int a, int b) {
        return a + b;
    }

    private static int addValues (int a, int b, int c) {
        return a + b + c;
    }

Use the triple dot syntax to pass multiple arguments

    private static int addValues (int... values) {
        return a + b + c + d;
    }

**Pass arguments by reference vs value**

* Passing an argument into a method, it is making a copy of the variable
* The values referenced by the two copies may be the same

# 6. Debugging and exception handling

**Handle exceptions with try/catch**

* Surround an expression with code/surround with/try catch
* The default creates `throw new RuntimeException(e)`
* Alternatively use `e.printStackTrace()`

**Create multiple catch blocks**

Chain multiple catch expressions for specific exception

    try {
        // do something
    } catch (NullPointerException e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
    } catch (StringIndexOutOfBoundsException e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Similar to default keyword in switch to catch everything else")
    }

**Close objects with try-with-resources**

This is similar to `with open('some-file.csv') as file` in python to open and close files. Using try/catch, create the reading and buffering objects inside a `try(objects)`. Although the following code will only read the first line, it needs the data to be stored in an `ArrayList<String[]>`, where each row is a `String[]`, reading each line into a temporary String list variable, then adding this to the array. See the complete code in the branch `java-ET/6/research/load-csv`

    var file = "some-file.csv";
    InputStream inputStream = Main.class.getClass.getClassLoader.getResourceAsStream(file);
    try (InputStreamReader streamReader = new InputStreamReader(inputStream);
         BufferedReader reader = new BufferedReader(streamReader);) {
        System.out.println(reader.readLine());
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }

**Complex Calculator**

Add the option to type in the operation (+ - * /). However I found that when capturing input using `nextDouble` and `nextLine` it moves the cursor forward skipping input for the operation. This doesn't work:

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter first number: ");
    var firstNumber = scanner.nextDouble();
    System.out.print("Enter second number: ");
    var secondNumber = scanner.nextDouble();
    System.out.print("Enter operation (+ - * /): ");
    var operation = scanner.nextLine();

The output is:

    Enter first number: 1 (enter number 1 and press enter)
    Enter second number: 2 (enter number 2 and press enter)
    Enter operation (+ - * /):  (this is skipped and it exits the program)

What I learned is that pressing enter, after number `2` is captured by `scanner.nextLine()`. Instead, use only `scanner.nextLine()` but parsing the input to the corresponding primitive.

    ...
    var firstNumber = Double.parseDouble(scanner.nextLine());
    ...
    var secondNumber = Double.parseDouble(scanner.nextLine());
    System.out.print("Enter operation (+ - * /): ");
    var operation = scanner.nextLine();

# 7. Create custom classes

**Declare and use custom classes**

I implemented this in the previous section. Creating a class and methods corresponding to the Calculator exercise. For example:

    public class Calculator {
        public static double addNumbers(double... operands) {
            return operands[0] + operands[1];
        }
    }

**Organize code with packages**

Explains what a package is and how libraries are imported. For example

Main.java

    package com.company;

Calculator.java

    package com.company

If Calculator.java was inside another package called 'utilities' then Main would need an import

Main.java

    package com.company;

    import com.company.utilities.Calculator

**Create instance fields and methods**

This is a different code example

* Create a package `model`
* Inside create the class `ClothingItem`
* Add private fields: `String type`, `String size`, `double price`, `int quantity`
* Then generate setters/getters
* In `Main` create an instance of the class
* Then set the values for an example
* Create a `totalPrice` and compute `price * quantity`

Using `String.format()`

    var formatter = NumberFormat.getCurrencyInstance();
    var output = String.format("Item: %s, Total Price: %s", item.getType(), formatter.format(totalPrice))

More about `NumberFormat` in the Oracle docs [here](https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html)

**Declare multiple constructor methods**

Following the previous example:

* Create multiple constructor methods but with different signatures
* Create a constructor with no arguments
* Create a constructor with all fields
* Call the constructor and remove the setters from Main

**Use static fields as constants**

* Declare constants with `public static final String CONSTANT_NAME = "a string";` since the usual upper case CONSTANT is not available in Java.
* Use the shortcut `psfs`
* Constants help avoid mistyping strings that are used often

**Declare and use Enum types**

Follows previous example:

* Create an enum for clothing sizes. Used to set a finite number of choices.
* In the `model` package create an enum `ClothingSize` with `S, M, L`
* Create a field in `ClothingItem` for `private ClothingSize size`
* In `ClothingSize` create a field string `description` and constructor with argument `String description`
* Change the constructor for the sizes such as `S("Small")`
* Then display the `description` such as `Small` and not the constant name `S`
  * Override the `toString()` method.
  * Use Generate, then `toString()`, then return `description`

# 8. Work with inheritance

**About inheritance**

* Java supports single inheritance
* A class can extend only one superclass
* Classes can implement many interfaces
* All classes are derived from `Object`

Polymorphism example where class `Hat` extends `ClothingItem` and it overrides returning the string `Hat`:

    ClothingItem item = new Hat();
    System.out.println("This is a " + item.getType());
    // Output
    // This is a Hat

**Extend classes and override methods**

* Create a class `Shirt` in package `model`
* Extend the class from `ClothingItem`
* Create a constructor where `super` uses `ClothingItem.SHIRT`
* The shirt constructor doesn't need type as an argument
* In `Main` change the constructor to `Shirt`

**Use objects as their super types**

* Extract a method to `displayItemDetails`
* Create another class `Hat`
* Create another item in `Main` and display details

# 9. Manage data collections

**Store values in simple arrays**

* In `Main` create a `String[]` of length `3` to hold colors
* Assign colors for each string
* Print the colors using a for loop
* Enclose the `shirt` and `hat` objects inside a `ClothingItem[]`
* Print the item objects using a for each

**Manage resizable arrays with Lists**
**Manage key-value pairs with Maps**
