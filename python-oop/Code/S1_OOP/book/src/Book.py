class Book:
    def __init__(self, title, author, number_of_pages, price):
        self._discount_percent = None
        self.title = title
        self.author = author
        self.number_of_pages = number_of_pages
        self.price = price
        self.__secret = "A private attribute that should not override in a subclass"
        
    def get_price(self):
        if hasattr(self, "_discount_percent"):
            return self.price * (1 - (self._discount_percent / 100))
        else:
            return self.price
    
    def set_discount(self, discount_percent):
        self._discount_percent = discount_percent
