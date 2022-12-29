# Background

Quick overview of this Linkedin Learning course from a Google engineer.

# 1. Getting Started

* The course uses VSC

# 2. Python basics

Capture input with `input("Enter something: ")`

    name = input("Enter your name: ")
    print(f"Hello {name}")

Convert numbers to string to join them

    print("The number " + str(3))

Default value in function argument

    def power(num, x=1):
        result = 1
        for i in range(x):
            result *= num
        return result

    print(power(2))

Function with variable number of arguments

    def many_arguments(*args):
        result = 0
        for x in args:
            result += x

    def many_arguments_again(arg1, *args):
        ...

Match case syntax

    value = "one"
    match value:
        case "one"
            result = 1
        case "two" | "three"
            result = 2
        case _:
            result = "Default/Any other condition"

Break/continue syntax

    for x in range(5):
        if x == 7:
            continue
        else:
            breaks

Get an index value

    marvel = ["Namor", "Thor", "Black Panther"]
    for i, chararacter in enumerate(marvel):
        print(i, character)

    // output
    0 Namor
    1 Thor
    2 Black Panther

Class syntax

    class MusicInstrument():
        def __init__(self, instrument_type):
            self.vehicle_type = instrument_type

    class Bass(MusicInstrument):
        def __init__(self, bass_type):
            super().__init__("Bass")
            self.bass_type = bass_type
            self.number_strings = 4

Exception syntax

    try:
        x = 10 / 0
    except ZeroDivisionError as e:
        print("Divided by zero")
    except ValueError as e:
        print("Enter a different number")

Create a small input that repeats until exit

    run = True
    while (run):
        user_input = input("Enter input or 'exit': ")
        if user_input == "exit":
            run = False
            break

        user_input = user_input.lower()
        // do something else

# 3. Working with files

Open file syntax, use `r` or `w` or `a`

    with open("file.txt", "r") as file:
        contents = file.read()
        print(contents)

        read_lines = file.readlines()
        for line in read_lines:
            print(line)

Skipped most of it.

# 4. Using dates and times

Skipped

# 5. Internet data formats

Get data using request

    import urllib.request

    weburl = urllib.request.urlopen("http://www.google.com")

Connect to JSON feed

    import json

    urlData = "http:...some link"
    // verify code 200
    weburl = urllib.request.urlopen(urlData)
    if (weburl.getcode() == 200):
        print("Correct response")
        data = weburl.read()
        print(data)
    else:
        print("Server error")

    theJSON = json.loads(data)