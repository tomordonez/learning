# Python Koans

**Setup**

* Git clone repo `git clone https://github.com/8thlight/python_koans`
* Install `sniffer`
  * `pip install sniffer`
  * `pip install pyinotify`
* Add to PATH (this is not persistent, unless you edit `~/.bashrc`)
  * `export PATH="/home/tom/.local/bin:$PATH"`
* Go to the source directory
  * `cd python3`
* Run `sniffer`
  * It depends on the file `python_koans/python3/scent.py`
* Modify the file(s) with errors. In the terminal, see the tests changing.

**Koan**

What is a Koan? According to Wikipedia "...a dialogue, question, or statement, used to provoke the great doubt and to practice or test a student's progress in Zen."

**My python-koans directory**

I only committed to my `python-koans` directory, the files I changed in `python3/koans/`. To see all the original repo code go to [https://github.com/8thlight/python_koans](https://github.com/8thlight/python_koans)

## AboutAsserts

These were basic tests to `self.assertTrue`, `self.assertEqual`, and `assert`

## AboutStrings

Names of test methods are very descriptive, including prepositions so it reads like formal language:

	def test_use_backslash_for_escaping_quotes_in_strings(self)

Assert that strings were instances of `str` like this: `isinstance(string_variable, str)`

When a string has a newline character like `\n` this is counted as 1 character.

	text = "First Line.\n\
		Second Line."

	len(text)	
	# Lenght of text is 24
	# Length of "First Line." is 11.
	# Length of "\n" is 1.
	# Length of "Second Line." is 12

All newlines are counted as characters. This `text` has three `\n`. One after the first triple quotes, and one after each sentence. The length of `text` is the total of visible and non-visible characters.

	text = """
		A line after 3 quotes
		A new line
	"""

Use triple quoted strings to avoid escaping characters

	text = """Don't use escape or "here"."""

## AboutNone

None is an object.

Syntax the `try/except` with the specific exception like in Java.

	try:
		something_happens()
	except Exception as ex:
		print(ex)

## AboutLists

A list slice returns a list

	avengers = ['antman', 'spiderman', 'thor']
	avengers[0:1] # ['antman']

A list slice with the same range numbers returns empty, because the upper range is not inclusive

	avengers[0:0] # []

Some nice Python poetry for best practices

	import this

Use `deque` to pop items from the left side for `O(1)`, since if you use `pop(0)` then it's `O(n)`

	from collections import deque

	avengers_deque = deque(avengers)
	avengers_deque.popleft() # 'antman'
	
	print(avengers) # ['spiderman', 'thor']

## AboutListAssignments

Parallel assignments

	first_name, last_name = ["Peter", "Parker"]

## AboutDictionaries

Assert a dictionary based on `k,v` pairs

	self.assertDictEqual({}, empty_dict)

Create a dictionary form keys

	{}.fromkeys((a tuple of keys), value)

## AboutStringManipulation

Split a string with a regex pattern

	import re

	text = "A , comma and ; semicolon"
	pattern = re.compile(';|,')
	
	# This doesn't work
	# TypeError: must be str or None, not re.Pattern
	text.split(pattern)

	# This works
	pattern.split(text)

A raw string does not interpret escape characters

	text = r'\n'
	text # '\\n'
	print(text) # \n

## AboutTuples

`assertRegex()` uses regular expression pattern matching

	self.assertRegex(msg, "a message here")

Tuples are immutable. You can't append to a tuple.

* Convert the tuple to list
* Append to the list
* Convert back to tuple

A tuple of `(1)` is not a tuple but an int, unless you do `(1,)`.

Using the tuple constructor on a string results in a tuple of its characters

	tuple("hello") # ('h', 'e', 'l', 'l', 'o')

## AboutMethods

A method with `*args` is a tuple

	def tuple_args(self, *args):
		return args

	tuple_args(1, 2) # (1, 2)

Old methods are hidden by redefinition

	def my_method(self):
		return 1

	old_method = my_method

	def my_method(self):
		return 2

	self.my_method # 2
	self.old_method # 1

Methods with one line body doesn't require indentation

	def my_method(self): return 2

A string placed at the beginning of a method is used for documentation

	def my_method(self):
		"my_method returns 2"
		return 2

	self.my_method.__doc__ # "my_method returns 2"

Prefixing with one underscore `_` means private scope, but not enforced. The idea is like Java's `private` keyword.

	def _my_method(self):
		return 2

	print(_my_method()) # 2

Prefixing with two underscores `__` seems to enforce private scope and it causes "name mangling", which prefixes that variable with the class name.

	from dataclasses import dataclass

	@dataclass
	class Email:
	    author: str = "Homer Simpson"
		__pwd: str = "private"

	email = Email()
	email.author # Homer Simpson
	email.__pwd # AttributeError: 'Email' object has no attribute '__pwd'

	email.__dict__ # {'name': 'Homer', '_Email__pwd': 'private'}

However, you can still access that "private" attribute

	email._Email__pwd # 'private'

Purpose of "name mangling":

* Name mangling exists to avoid name clash issues when subclassing.
* It is not for providing effective access protection

## AboutControlStatements

Assertions of `if/else`, `while` and `for` loops.

## AboutTrueAndFalse

Passing `None` or zero `0` or an empty collection or blank strings to a method are treated as `False`

	def is_false(self, condition):
		if condition:
		    return True
		else:
			return False

	is_false(None) # False
	is_false(0) # False
	is_false({}) # False

## AboutSets

Creating a new empty list and a new empty set returns a different syntax

	list() # []
	set() # set()

Create a set from a string

	set('123')
	# This returns {'1', '2', '3'}

	{'123'}
	# This returns {'123'}

Sorting a set converts it to a list

	sorted(set('12345'))
	['1', '2', '3', '4', '5']

Sets have arithmetic operations

	set1 - set2
	set1 | set2 # all in set1 and set2
	set1 & set2 # intersection
	set1 ^ set2 # all in set1 and set2 but not intersection

## AboutTriangleProject

* Create a set with the parameters.
* Type of triangle is based on the length of the set

## AboutExceptions

When inheriting from `RuntimeError` and calling the method resolution order, the number of methods are different than from the base class

	mro = RuntimeError.mro()
	mro
	# [<class 'RuntimeError'>, <class 'Exception'>, <class 'BaseException'>, <class 'object'>]

	class myException(RuntimeError):
		pass

	mro = myException.mro()
	mro
	# [<class '__main__.myException'>, <class 'RuntimeError'>, <class 'Exception'>, <class 'BaseException'>, <class 'object'>]

In inheritance, an object is an instance of the subclass and the superclass

	try:
		2 / 0
	except Exception as ex:
		ex2 = ex

	isinstance(ex2, ZeroDivisionError) # True, this is the subclass
	isinstance(ex2, Exception) # True, this is the superclass
	isinstance(ex2, AssertionError) # False, this is a different subclass

## AboutTriangleProject2

Raise exception if any argument (triangle side) is less than 0.

	if any(side <= 0 for side in sides_set):

Raise exception if the sum of two sides is less or equal than the other side. There must be a way to refactor this:

	if ((a + b) <= c or (b + c) <= a or (a + c) <= b):

## AboutIteration

Create an iterator. This creates five iterator objects. It raises `StopIteration` when the iterator is completed, for example in a for loop.

	it = iter(range(1, 6))

	next(it) # 1
	next(it) # 2. It doesn't return 1 again.
	...
	next(it) # 5.
	next(it) # StopIteration (exception)

That means that when you define an iterator and use it in a loop. There aren't more iterators when you try to use it again.

	it = iter(range(1,3))
	for number in it:
		it

	# <range_iterator object at...>
	# <range_iterator object at...>

	for number in it:
		it

	# Nothing is returned

Map is similar to Java. It maps elements of a list.

	class map(object)
		map(func, *iterables) --> map object

		Make an iterator that computes the function using arguments from each of the iterables. Stops when the shortest iterable is exhausted

The function is called without parameters

	import math

	sequence = [1, 2, 3]
	sqrt_mapping = map(math.sqrt, sequence)
	
	for number in sqrt_mapping:
		round(number, 2)

	# 1.0
	# 1.41
	# 1.73

Filter is similar to Java.

	for item in filter(is_even, seq)

Using `reduce`

	from functools import reduce

	help(reduce)
	# reduce(function, sequence[, initial]) -> value
	# Apply a function of two arguments cumulatively to the items of a sequence
	# from left to right, to reduce the sequence to a single value
	# If initial is present, it is placed before the items of the sequence in the calculation
	# and serves as a default when the sequence is empty

## AboutComprehension

The usual list comprehension

	# Create a list
	[number for number in list_of_numbers if number > 0]

	# Create a set
	{letter for letter in 'aaabbccc'}

	# create a dictionary
	{key : value for key, value in other_dictionary.items() if value > 0}

## AboutGenerators

More about Generators:

* [https://wiki.python.org/moin/Generators](https://wiki.python.org/moin/Generators)
* [What does yield keyword do](https://stackoverflow.com/a/231855)

Compared to iterables like `range` which creates a list and stores it in memory like:

	for i in range(1, 5):
		print(i)

	# This creates an iterable list, storing numbers from 1 to 5000 in memory
	# It prints numbers from 1 to 5

A generator has the syntax of a list comprehension but uses parentheses instead of curly braces

	mygenerator = (x for x in range(1,5))
	for i in mygenerator:
		print(i)

	# This generates the values on the fly and not a whole list of numbers in memory
	# It prints five iterable objects
	# Print the values with next (not in the for loop): print(next(mygenerator))

A generator function is only called in the first iteration and it retains local variables

	def my_generator(sequence):
		total = 0
		for i in sequence:
			total = i - total
			yield total

	result = my_generator(range(1, 3))
	list(result) # [1, 1]

Send a value to a generator. As seen here [https://stackoverflow.com/a/19302694](https://stackoverflow.com/a/19302694)

	def double_input():
		while True:
			x = yield
			yield x * 2

	gen = double_input() # creates the generator
	gen(next) # goes to the first yield
	gen.send(2) # Sets x to 2, returns 4

## AboutLambdas

An anonymous function like:

	x = lambda a: a + 1
	print(x(2)) # returns 3

## AboutScoringProject

This took me about 2-3 hours.

I wanted to create a generator from the dice list. Then count the number of times each item was repeated.

	dice_generator = (x for x in dice)
	count_of_dice_number = {1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0}
	loop_count = 0

    while loop_count < len(dice):
        next_dice = next(dice_generator)
        count_of_dice(count_of_dice_number, next_dice)
        loop_count += 1

The `count_of_dice` method counted the number of times the item was repeated

	def count_of_dice(count_of_dice_number, next_dice):
		if next_dice == 1:
			count_of_dice_number[next_dice] += 1
		elif next_dice == 2:
			count_of_dice_number[next_dice] += 1
		...

Then it calculates the points for each dice number

	points = 0

    if len(dice) == 0:
        return points
    else:
        points_one = calculate_points(1, count_of_dice_number)
        points_two = calculate_points(2, count_of_dice_number)

The `calculate_points` is long and has repetitive code. It could be refactored

	def calculate_points(number, count_of_dice_number):
		if number not in [1, 5]:
			if count_of_dice_number[number] == 3:
				return 100 * number
			else:
				return 0
		elif number == 1:
			if count_of_dice_number[number] == 0:
				points = 0
		...

## AboutClasses

Use `property` for a managed attribute that includes setter, getter, deletion, and docstring

	class Avenger:
		def __init__(self):
			self._name = None
		
		def get_name(self):
			return self._name

		def set_name(self, value):
			self._name = value

		name = property(get_name, set_name)

	avenger = Avenger()
	avenger.name # None (Invokes the getter)
	avenger.name = "Thor" (Invokes the setter)
	avenger.name # Thor

Use the `@property` decorator to set a accesor functions for the decorated method

	class Discount:
		def __init__(self):
			self.discount = None

		@property
		def calculate_discount(self): # Turns this method into a getter
			return self.discount

		@calculate_discount.setter
		def calculate_discount(self, value): # Turns this into a setter
			self.discount = value

	discount = Discount()
	discount.calculate_discount # Access as an attribute, not a method
	discount.calculate_discount = 5 # Access the setter
	discount.calculate_discount # Returns: 5

## AboutWithStatements

I used `with` before but never heard of the sandwich analogy. Top bread (open file), meat (do something), bottom bread (close file).

	with open('filename.txt') as file:
		for line in file.readlines():
			# do something

## AboutMonkeyPatching

Never heard of this before. You can attach a method to an existing class, without that class having that method. This can be used for unit testing external resources, like simulating opening a file, or a call to an external data source.

	from dataclasses import dataclass

	@dataclass
	class Avenger:
		name: str

		def get_name(self):
			return self.name

		def set_name(self, value):
			self.name = value

	def blip_avenger():
		return "You got blipped"

	avenger = Avenger("Spiderman")
	avenger.blip_avenger = blip_avenger
	avenger.blip_avenger() # You got blipped

Most built-in classes can't be monkey patched. This won't work. It says you can't set attributes on `int`:

	int.is_even = lambda self: (self % 2) == 0

Subclasses of built-in classes can be monkey patched.

	class MyInt(int):
		pass

	MyInt.is_even = lambda number: (number % 2) == 0
	MyInt(2).is_even() # True

## AboutDiceProject

This was a simple list append a range of random numbers.

The tests:

* Descriptive test method names
* Test that the object is an instance of a list
* Test that the object has specific length

Test the dice returns a number from 1 to 6

	for value in dice.values:
		self.assertTrue(value => 1 and value <= 6, f"Value {value} must be between 1 and 6")

Test that the values change between rolls. (test that the list of numbers are random). Altough it's possible that two consecutive or non-consecutive lists are equal.

## AboutMethodBindings

As seen in [https://stackoverflow.com/a/46001336](https://stackoverflow.com/a/46001336), a `hello()` calls the function, while `hello` is a name bound to the function.

Unbound function `function`

	def function():
    	return "pineapple"

Bound method `method`

	class Class:
		def method(self):
			return "parrot"

You can't set an attribute to a bound method directly, but you can set it through the inner function

	obj = Class()

	# This won't work
	obj.method.cherries = 3

	# This works
	obj.method.__func__.cherries = 3

## AboutDecoratingWithFunctions

More about decorators for functions and methods [https://peps.python.org/pep-0318/](https://peps.python.org/pep-0318/).

From this:

	def nut(self):
		# do something

	def do(self):
		# do something
	
	donut = do(nut)

To this:

	@do
	def nut(self):
		# do something

I remember it like this. Call `do` with `nut`. Or `do(nut)`

## AboutDecoratingWithClasses

**REVISIT LATER**

More about `functools` at [https://docs.python.org/3/library/functools.html](https://docs.python.org/3/library/functools.html). Functions that act on or return other functions.

A `partial` in `functools.partial(func, /, *args, **keywords)`, returns a partial object, when called it behaves like `func` with the arguments `args` and `keywords`. The `partial()` freezes portion of a function's arguments, resulting in a new object.

Use the `__call__` built-in method to let the instance behave like a function.

	class TwoNumberSum:
		def __init__(self):
			pass

		def __call__(self, a, b):
			return a + b

	sum = TwoNumberSum()
	sum(1, 2) # Returns 3

Use the `__get__` built-in method to access the instance `obj` and its owner `class`

This topic is pretty confusing, revisit later. I still don't understand how this code runs:

	@documenter("DOH!")
	@doubleit
	@doubleit
	def homer(self):
		return "D'oh"

    def test_we_can_chain_decorators(self):
        self.assertEqual("D'oh, D'oh, D'oh, D'oh", self.homer())
        self.assertEqual("DOH!", self.homer.__doc__)