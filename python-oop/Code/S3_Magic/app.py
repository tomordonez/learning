from src.Book import Book
from src.Discount import Discount
from datetime import date


def run():
    book_discount_january = Discount(20, date.fromisoformat('2023-01-12'))

    book_python = Book("Learning Python", "Mark Lutz",
                       45, book_discount_january)

    book_python_ebook = Book("Learning Python", "Mark Lutz",
                             45, book_discount_january)

    book_java = Book("Thinking in Java", "Bruce Eckel",
                     35, book_discount_january)

    book_tdd = Book("Clean Code", "Robert Martin", 55, book_discount_january)

    book_python_discount = book_python.get_20_percent_discount()
    print(f"{book_python.title} by {book_python.author}. Discount Price: ${book_python.price}")

    # True, compares if title and author are equal
    print(book_python == book_python_ebook)

    # True, compares if obj1 price >= obj2 price
    print(book_python >= book_java)

    # Sort method uses __lt__
    book_list = [book_python.title, book_java.title, book_tdd.title]
    print(book_list)

    book_list.sort()
    print([book for book in book_list])

    # Override __getattribute__ to return discounted price
    print(book_python)

    # Raise invalid attribute in Book
    print(book_python.publisher)

    # Call the object like a function
    print(book_python)
    book_python("Python Book", "Lutz", 55, book_discount_january)
    print(book_python)
