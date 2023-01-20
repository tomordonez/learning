from dataclasses import dataclass


@dataclass
class FizzBuzz:

    @property
    def number(self):
        return str(self._number)

    @number.setter
    def number(self, number):
        self._number = number
