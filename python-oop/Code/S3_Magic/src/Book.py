class Book:
    def __init__(self, title, author, price, discount) -> None:
        self.title = title
        self.author = author
        self.price = price
        self.discount = discount

    def __repr__(self) -> str:
        return f"[title={self.title}, author={self.author}, price={self.price}, {self.discount}]"

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

    def get_20_percent_discount(self):
        if self.discount.discount_percent == 20:
            return self.discount.calculate_discount(self.price)
        else:
            raise ValueError(
                f"Discount must be 20%. Entered discount was {self.discount.discount_percent}%")
