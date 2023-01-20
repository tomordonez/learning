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
        if self._number == 1:
            return "1"
        elif self._number == 2:
            return "2"
        elif (self._number % 3 == 0):
            return "Fizz"
        elif (self._number % 5 == 0):
            return "Buzz"
