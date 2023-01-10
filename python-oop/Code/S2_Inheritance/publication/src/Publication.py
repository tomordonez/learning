class Publication:
    def __init__(self, title, price):
        self.title = title
        self.price = price

    def __repr__(self):
        return f'({self.title}, {self.price})'
