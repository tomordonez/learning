from typing import Any


class Book:
    def __init__(self, title, author, price, discount) -> None:
        self.title = title
        self.author = author
        self.price = price
        self.discount = discount

    def __str__(self) -> str:
        return f"{self.title} by {self.author}. Discount Price: ${self.price}"

    def __repr__(self) -> str:
        return f"[title={self.title}, author={self.author}, price={self.price}, {self.discount}]"

    def __call__(self, *args: Any, **kwds: Any) -> Any:
        self.title = args[0]
        self.author = args[1]
        self.price = args[2]
        self.discount = args[3]

    def __eq__(self, __o: object) -> bool:
        if isinstance(__o, Book):
            return (self.title == __o.title and self.author == __o.author)
        else:
            raise TypeError(f"{__o} is not an instance of Book")

    def __ge__(self, __o: object) -> bool:
        if isinstance(__o, Book):
            return (self.price >= __o.price)
        else:
            raise TypeError(f"{__o} is not an instance of Book")

    def __getattribute__(self, __name: str) -> Any:
        if __name == "price":
            price = super().__getattribute__("price")
            discount = super().__getattribute__("discount")
            return discount.calculate_discount(price)
        else:
            return super().__getattribute__(__name)

    def __setattr__(self, __name: str, __value: Any) -> None:
        if __name == "price":
            # assert type(__value) == float, "Price should be float"
            return super().__setattr__("price", float(__value))
        else:
            return super().__setattr__(__name, __value)

    def __getattr__(self, __name: str) -> None:
        try:
            self.__dict__[__name] is not None
        except:
            print(f"'{__name}' is not a Book attribute")

    def get_20_percent_discount(self):
        if self.discount.discount_percent == 20:
            return self.discount.calculate_discount(self.price)
        else:
            raise ValueError(
                f"Discount must be 20%. Entered discount was {self.discount.discount_percent}%")
