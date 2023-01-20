from dataclasses import dataclass


@dataclass
class FizzBuzz:

    @property
    def number(self):
        return self._number

    @number.setter
    def number(self, number):
        self._number = number

    def calculate_fizzbuzz(self):
        if (self._number % 15) == 0:
            return "FizzBuzz"
        elif (self._number % 3) == 0:
            return "Fizz"
        elif (self._number % 5) == 0:
            return "Buzz"
        else:
            return str(self._number)
