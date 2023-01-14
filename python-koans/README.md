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

File: `koans/about_asserts.py`

These were basic tests to `self.assertTrue`, `self.assertEqual`, and `assert`

## AboutStrings

File: `koans/about_strings.py`

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
