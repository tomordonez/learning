from dataclasses import dataclass, field
import random


@dataclass
class Book:
    title: str
    author: str
    pages: int

    def __post_init__(self):
        self.price = self.get_book_price()

    def get_book_price(self):
        if 'price' not in self.__dict__:
            random.seed(5)
            return random.randrange(0, 50)
