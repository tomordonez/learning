# Applying UML and Patterns (Craig Larman)

## 9. Domain Models

**What is a domain model**

* Most important and classic model in OO analysis aka `domain layer`
* Source of inspiration to design software objects
* A visual representation of conceptual classes or real situation objects in a domain
  * Conceptual class (an idea, thing, or object)
    * It has a `symbol` (words/images representing it)
    * An `intention` (definition)
    * An `extension` (a set of examples)
  * Example
    * A purchase transaction
      * Symbol: Sale
      * Intention: A sale represents the event of a purchase transaction. It has a date and time
      * Extension: sale-1, sale-2, etc.
* In UML it uses a class diagram without operations
  * The top compartment has the symbol/concept name (not a class name)
  * The bottom has attribute names
* Also used as a visual dictionary of the abstractions and domain vocabulary
* Not an implementation
  * It doesn't visualize software objects (databases or software components)
* Not a data model
  * Although don't exclude a class if it doesn't indicate storing persistent data
  * Also, conceptual class may not have attributes and be purely behavioral

**How to find conceptual classes**

1. Reuse/modify existing models. There are published models for many domains (see "Analysis Patterns" by M. Fowler)
2. Use a category list
3. Identify noun phrases

Other practices:

* If it's a number or text, it's an attribute, not a class
  * A `Sale` initially designed with a `store` attribute
    * A `store` is not considered a number or a text
    * A `store` occupies space, then it should be a class
    * `Sale` (has attributes), `Store` (has attributes)
  * A `Flight` initially designed with a `destination` attribute
    * The `destination` is an `Airport`
    * `Flight` (has attributes), `Airport` (has attributes)
* Modeling a `Description`
  * If an `Item` (description, price) is sold out in `Store`
    * You wouldn't be able to find an item description or price because all item instances were sold.
    * Model as `Item` (serial number) and `ItemDescription` (description, price)
  * How to find Description classes
    * Deleting instances of things result in loss of information
      * A `Flight` (date, number, time) and `Airport` (name)
      * If all flights are completed, then flight number might be deleted
      * `Flight` (date, time), `FlightDescription` (number), `Airport` (name)

*2. Category List in Order of Importance: Example Inventory System*

1. Business transactions (critical as the involve money)
   1. `Sale`, `Payment`
2. Transaction line items
   1. `SalesLineItem`
3. Product/service related to transaction
   1. `Item`
4. Where is the transaction recorded?
   1. `Register`
5. Actors related to the transaction
   1. `Cashier`, `Customer`
6. Place of transaction
   1. `Store`
7. Events with time or place
   1. `Sale`, `Payment`
8. Descriptions of things
   1. `ProductDescription`
9. Catalogs (descriptions are in a catalog)
   1.  `ProductCatalog`
10. Containers of things (physical or information)
    1.  `Store`, `Bin`
11. Other collaborating systems
    1.  `CreditAuthorization`
12. Records of finance/contract/legal
    1.  `Receipt`, `Ledger`
        1.  This might be excluded since showing a report in a domain model is not useful as it is derived from other sources.
13. Financial instruments
    1.  `Cash`, `Check`, `LineOfCredit`

*3. Identify noun phrases (linguistic analysis)*

* Combine with category list, since mechanical noun-to-class mapping is not possible
* Some nouns can identify the same conceptual class, other nouns could be attributes.

**Associations**

* A relationship between instances of classes that needs to be preserved for some duration
* Reconstruct instances based on relationships
  * A `SalesLineItem` instance is associated with `Sale`
* Between what objects do we need memory of a relationship?

**Attributes**

* A logical data value of an object
* Most attribute types should be primitive data types
* Don't add a foreign key as an attribute, instead use an association
* Derived attributes
  * Use the symbol `/` before the attribute name
  * A `total` attribute in `Sale` can be calculated from `SalesLineItem`

* Syntax: `visibility name: type multiplicity = default {property-string}`
  * Definitions
    * `Visibility`: `-` (private), `+` (public), `#` (protected)
    * `Name`: Name of the attribute in this `camelCase`
    * A colon `:`
    * `Type`: Data type, primitive and/or collection (and type)
    * `Multiplicity`: Optional to describe the number of instances
    * `= default`: Optional a default value
    * `{property-string}`: A UML-defined keyword like `{ordered, List}`, `{readOnly}`
  
  * Examples
    * `Sale`
      * `- dateTime: Date`
        * Visibility `-`
        * Name `dateTime`
        * Type `Date`
    * `Math`
      * `+ pi: Real = 3.14 {readOnly}`
    * `Person`
      * `- middleName: [0..1]`

## 16. UML Class Diagrams

**Design Class Diagram**

* In Ch9. the conceptual class is used to visualize a domain model
* The (DCD) Design Class Diagram is used to visualize a software design

**Collection Attribute Example**

* `Sale`
  * Attributes:
    * time: DateTime
    * lineItems: SalesLineItem [1..*]{ordered, List}
  * Association
    * (Sale) 1 -- 1..* (SalesLineItem)
* `SalesLineItem`

Implementation:

    public class Sale {
        private DateTime time;
        private List<SalesLineItem> lineItems = new List<>();
    }

**Operations**

* An operation is not an implementation method
* Assumed public `+` if no visibility shown
* Syntax: `visibility name (parameter-list): return-type {property-string}`
  * `+ calculateTotal(Double price, Integer quantity): Double`
* Exclude getters and setters

**Composition Over Aggregation**

* In both, an object contains another
* Aggregation
  * One object does not control the lifetime of the other
  * A car contains an engine
  * A course has students
  * UML: Unfilled diamond on the "container" side of the association
* Composition
  * One object controls the lifetime of the other
  * A hand has fingers
  * A house has rooms
  * UML: Filled diamond on the "container" side of the association

The book recommends:

* Don't use aggregation in UML
* Use composition when appropriate