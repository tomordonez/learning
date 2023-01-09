from S1_OOP.book.src.Newspaper import Newspaper
from S1_OOP.book.src.Book import Book


def run():
    # Instance methods
    book1 = Book("Learning Python", "Mark Lutz", 1160, 45, "Ebook")
    print(book1.title)
    print(f"List Price: ${book1.price}")

    discount_percent = 15
    book1.set_discount(discount_percent)
    print(f"Discount: {discount_percent}%")
    print(f"Discounted Price: ${book1.get_price()}")

    # Instance types
    newspaper = Newspaper("El Tiempo")
    print(isinstance(newspaper, Newspaper))
    print(type(newspaper))
    print(f'Is book an instance of newspaper? {type(book1) == type(newspaper)}')

    # Class methods
    book2 = Book("Learning Java", "Bruce Eckel", 1000, 50, "Hardcover")
    print(f'{book2.title} is in {book2.book_type}')

    # Example to validate book type
    # another_book = Book("Learning Java", "Bruce Eckel", 1000, 50, "Printed")
    # print(f'{another_book.title} is in {another_book.book_type}')

    book_types = Book.get_book_types()
    print(book_types)

    book1.add_book_to_list()
    book2.add_book_to_list()

    book_list = Book.get_book_list()
    print(book_list)
    
    
    
