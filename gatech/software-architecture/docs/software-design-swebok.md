# Software Design Summary From SWEBOK

Based on Chapter 2 of `Guide to Software Engineering Body of Knowledge v3.0` aka `SWEBOK` and the `Unified Modeling Language Specification`.

## Software Design Fundamentals

**High level design**

Architectural design that describes how software is organized into components. This Youtube video [here](https://www.youtube.com/watch?v=H703ErIrby8) describes the process as:

* Gathering all requirements
  * Functional
  * Non-functional
* Costing limitations
* CAPS tradeoffs (similar to the CAP theorem but (P) is Partition Tolerance)
  * Consistency
  * Availability
  * Performance
  * Scalability
* Design decisions
  * Pick the components
  * Select data stores
  * Type of architecture
  * Number of users, requests, transactions
  * Scale
  * Caching
  * CAP
* Improvements for future versions

**Low level design**

Detailed design describing the desired behavior of components.

* UML diagrams
  * Use case, class diagram
  * Behavior diagrams
    * Activity diagram
    * Interaction diagrams
      * Sequence diagram
      * Collaboration diagram
  * Implementation diagrams
    * Component diagram
    * Deployment diagram
* Data Models
  * ERD (entity relationship diagram)
* Implementation
  * Testing strategy
  * Applying OOP
  * How to implement

**Software design principles**

* `Abstraction`
  * Parameterization: Abstracting details by representing the data as named parameters
  * Specification: Three kinds of abstractions
    * Procedural abstraction
    * Data abstraction
    * Control/iteration abstraction
* `Coupling and cohesion`
  * Coupling: interdependence among modules in a program (ideal: low coupling)
  * Cohesion: strength of association of elements in a module (ideal: high cohesion)
* `Decomposition and modularization`
  * Large software is divided into smaller components with well-defined interfaces
  * Single responsibility for each component
* `Encapsulation`
  * Packaging internal details of an abstraction and inaccessible to external entities
* `Separation of interface and implementation`
  * Define components with public interfaces, separated from implementation details
* `Sufficiency, completeness, and primitiveness`
  * Capture all details of an abstraction with patterns easy to implement
* `Separation of concerns`
  * Use different views for different stakeholders

## Issues in Software Design

* `Concurrency`
  * Decompose software into processes, tasks, threads
  * Efficiency, atomicity, synchronization, scheduling
* `Control/handling events`
  * Organize data and control flow
  * Implicit invocation and call-backs
* `Data persistence`
  * Handle long-lived data
* `Distribution of components`
  * Distribute software across hardware
  * How components communicate
  * How to use middleware
* `Error/exception handling`
  * How to prevent/tolerate errors
* `Interaction/presentation`
  * Structure user interactions
  * MVC
* `Security`
  * Access control, security attacks

## Software Structure and Architecture

**High Level Design**

* High-level views
  * A partial aspect of an architecture
    * Logical view (functional requirements)
    * Process view (concurrency)
    * Physical view (distribution)
    * Development view (implementation)
* Architectural styles
  * General structures
  * Distributed systems
  * Interactive (MVC) systems
  * Adaptable systems

**Low Level Design**

* Design patterns
  * Creational patterns
  * Structural patterns
  * Behavioral patterns

## User Interface Design

**Design Principles**

* Easy to learn
* Familiar terms and concepts
* Recover from errors and feedback when they happen
* Consistent operations and behavior

**Modes of interaction**

* Question/answer
* Direct manipulation with objects on the screen
* Select a command from a menu
* Fill forms
* Natural language

**Design of information presentation**

* MVC
* Response time and feedback (restating user input or error feedback)
* Abstract visualizations when large amounts of information is presented
* Limit number of colors

**Design process**

1. User analysis
2. Software prototyping
3. Interface evaluation

## Software Design Quality Analysis and Evaluation

**Evaluate software design quality**

* Software design reviews
  * architecture reviews, requirement tracing, documentation review
* Static analysis
  * Fault-tree analysis, automated cross-checking, vulnerability analysis, math models
* Simulation and prototyping

**Measure quality**

* Functional decomposition
  * Using a structure/hierarchy diagram
* OO design
  * Class diagram review

## Software Design Notations

**Structural descriptions (static view)**

* Architecture description language (text)
* Class diagrams
* Component diagrams
* Deployment diagrams
* Entity-relationship diagrams ERD
* Interface description language (text)
* Structure charts (calling structure of programs)

**Behavior descriptions (dynamic view)**

* Activity diagrams (control flow among activities)
* Communication diagrams (interaction among objects)
* Data flow diagrams DFD
* Sequence diagrams (interaction among objects and time ordering of messages)
* Flowcharts, state transition, state charts

## Software Design Strategy and Methods

* General strategies
  * Divide and conquer, top-down, bottom-up, heuristics, using patterns, using iterations
* Function-Oriented
  * Top-down decomposition of software functions
    * Data flow diagrams
* Object-Oriented
  * Responsibility-driven, inheritance, polymorphism
* Data Structure-Centered
  * Describe input/output with data structures
* Component-Based
  * Independent units with well-defined interface and dependencies
* Service-Oriented
  * Distributed software with web services
