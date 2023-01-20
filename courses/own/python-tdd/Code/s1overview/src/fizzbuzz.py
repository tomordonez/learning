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
