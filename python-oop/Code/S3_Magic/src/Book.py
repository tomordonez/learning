class Book:
    def __init__(self, title, author, price, discount) -> None:
        self.title = title
        self.author = author
        self.price = price
        self.discount = discount

    def __repr__(self) -> str:
        return f"title={self.title}, author={self.author}, price={self.price}, {self.discount}"

    def get_20_percent_discount(self):
        if self.discount.discount_percent == 20:
            return self.discount.calculate_discount(self.price)
        else:
            raise ValueError(
                f"Discount must be 20%. Entered discount was {self.discount.discount_percent}%")
