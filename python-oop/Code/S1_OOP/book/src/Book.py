class Book:
    BOOK_TYPE = ("Hardcover", "Paperback", "Ebook")
    __book_list = None

    def __init__(self, title, author, number_of_pages, price, book_type):
        self._discount_percent = None
        self.title = title
        self.author = author
        self.number_of_pages = number_of_pages
        self.price = price
        self.__secret = "A private attribute that should not override in a subclass"

        if book_type in Book.BOOK_TYPE:
            self.book_type = book_type
        else:
            raise ValueError(f'Invalid book type {book_type}. Allowed: {Book.BOOK_TYPE}')

    def __repr__(self):
        return f'({self.title}, {self.author}, {self.number_of_pages}, {self.price})'

    @classmethod
    def get_book_types(cls):
        return cls.BOOK_TYPE

    def add_book_to_list(self):
        book_list_created = Book.get_book_list()
        book_list_created.append(self)

    @staticmethod
    def get_book_list():
        if Book.__book_list is None:
            Book.__book_list = []
        return Book.__book_list

    def get_price(self):
        if hasattr(self, "_discount_percent"):
            return self.price * (1 - (self._discount_percent / 100))
        else:
            return self.price

    def set_discount(self, discount_percent):
        self._discount_percent = discount_percent
