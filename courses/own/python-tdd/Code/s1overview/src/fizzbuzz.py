from dataclasses import dataclass


@dataclass
class FizzBuzz:

    @property
    def number(self):
        return self._number

    @number.setter
    def number(self, number):
        self._number = number
