# Creating a Class Diagram from Requirements

**UML Class Diagram Basics**

The terminology is different between design and (implementation)

* attributes (instance variables), operations (instance methods)
* Generalization (inheritance)

For each class use a rectangle divided in 3 sections in this order: ClassName, attributes, operations

* Classes
	* UpperCamelCase
* Attributes
	* lowerCamelCase
	* Prefix names with private `-`, unless they must be public `+`, or protected `#`
		* This is independent of implementation, given that Java has a `private` keyword, Python doesn't have this.
	* Define the type and optional initial value
* Operations
	* lowerCamelCase
	* Prefix names with public `+`, unless they are private or protected
	* Define the parameters and types, and type of return value (or None)
	* Exclude getters and setters

*Associations*

* Don't: cross over lines, put labels on lines
* General Association
	* If two classes need to communicate to each other
	* A line connecting both classes without triangle or diamond on either end
* `Generalization`
	* `is a` as in `a cat is an animal`
	* A line from the child class with arrow (unfilled triangle) pointing at parent class
	* Multiple child classes can be joined to one arrow pointing at parent.
* `Aggregation`
	* `has a` or `contains`
	* A line with an unfilled diamond on the left of `has a`
	* The lifetime of one object is independent of the other's
		* A car has an engine. The lifetime of the car is independent of the engine's
		* A course has students.
* `Composition`
	* `has a` or `contains`
	* A line with a filled diamond on one end.
	* The lifetime of one object is dependent on the other's
		* A person has a heart
		* A dog has a tail
		* A house has rooms
* `Association Class`
	* A class attribute or association could become a class depending on the association between two classes
		* Company and Employee (salary)
			* A company has employees (aggregation)
			* An employee can work for 1 or more companies, therefore having different salaries
			* The `salary` attribute can be assigned to a class `Job`
	* The class `Job` is described with a dash line in the middle of the two original classes

*Multiplicity/Cardinality*

* Place cardinalities on both ends of the line as in: `1-1`, `1-*`, `1-1..*`, etc.
	* `*`: zero or more
	* `1..*`: one or more
* It defines how many instances are associated between classes at a particular moment

*How to start*

As seen in `Applying UML and Patterns, Chapter 9`. Use a category list as seen in my book notes [here](../../../reading/uml-patterns/README.md)

**Requirements**

These requirements come from one of the lectures. I completed the analysis before watching the lectures, then optimized my result after watching them.

1. Each patron has one unique library card for as long as they are in the system
2. The library needs to know at least the name, address, phone number, and library card number for each patron
3. At any point in time, the library may need to know or calculate the items a patron has checked out, when they are due, and outstanding overdue fines
4. Children (age 12 and under) have a special restriction. They can only check out five items at a time
5. A patron can check out books or audio/video materials
6. Books are checked out for three weeks, unless they are current bestsellers, in which case the limit is two weeks
7. A/V materials may be checked out for two weeks
8. The overdue fine is ten cents per item per day, but cannot be higher than the value of the overdue item
9. The library also has reference books and magazines, which can't be checked out
10. A patron can request a book or A/V item that is not currently in
11. A patron can renew an item once (and only once), unless there is an outstanding request for the item, in which case the patron must return it

**Linguistic Analysis**
* Extract nouns (classes), adjectives or nouns (attributes), verbs (operations), stative verbs (associations)

* `Patron`
	* Attributes: name, address, phoneNumber, birthDate, /age, libraryCardNumber
		* /age is calculated from birthDate
			* Implementation:
				* Children age 12 and under, can check out 5 items at a time
	* Associations:
		* `* - *` (Title)
	* Operations:
		* checkoutItem
		* returnItem
		* requestItem (book or A/V)
		* renewItemOnce
			* Implementation:
				* If Item hasOutstandingRequest (True) then returnItem
* `Title`
	* Attributes: value, name
		* As seen in "Applying UML and Patterns, Chapter 9", about modeling a `description`, for example items sold in a store with an `Item` class with `description` attribute. If all `Item` instances were sold out, it's like if they were deleted from the system. You wouldn't be able to find the description of an item that doesn't exist anymore. Instead, abstract the attribute to a class `ItemDescription` with attributes `description` and `price`. Then `Item` would be a serialized instance perhaps with attribute `serialNumber`
	* Association:
		* `1 - 1..*` (Item)

* `Item`
	* Attributes: hasOutstandingRequest, canBeCheckedOut, checkoutLimitWeeks
	* Association:
		* `1..* - 0..2` (CheckedOutItem)
			* An instance of an item can be checked out from 0 to 2 at a specific time (checked out once, then renewed one more time)
			* I think it wouldn't be `1..* - *` since an instance of an item cannot be checked out more than once during a specific time by more than 1 patron. Meaning that two patrons cannot check out the same item at the same time. Also, an item can only be renewed once (up to two checkouts).
* `CheckedOutItem`
	* Attributes: dueDate, dailyOverdueFine
		* Implementation:
			* Overdue fines: 10c per item per day, total not higher than value
* `Register`
	* Operations:
		* getItemsCheckedOutByPatron
		* calculateOverdueFines
		* displayDueItems
* `Book`
	* Attribute: isBestSeller, isReferenceBook
	* Associations: Is an Item
* `A/V Material`
	* Attribute: checkoutLimitWeeks (2 weeks)
	* Associations: Is an Item
* `Magazine`
	* Attribute: checkoutLimitWeeks (0. Can't be checked out)
	* Associations: Is an Item.

**UML Class Diagram**

![Library UML Class Diagram](../resources/library-uml-class-diagram.png)