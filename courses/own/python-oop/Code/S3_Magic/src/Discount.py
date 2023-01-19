class Discount:
    def __init__(self, discount_percent, discount_date) -> None:
        self.discount_percent = discount_percent
        self.discount_date = discount_date

    def __repr__(self) -> str:
        return f"discount_percent={self.discount_percent}, discount_date={self.discount_date}"

    def calculate_discount(self, book_price):
        return book_price * (1 - (self.discount_percent / 100))
