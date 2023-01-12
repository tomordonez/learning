from src.Book import Book
from src.Discount import Discount
from datetime import date


def run():
    book_discount_january = Discount(20, date.fromisoformat('2023-01-12'))

    book_python = Book("Learning Python", "Mark Lutz",
                       45, book_discount_january)

    book_python_discount = book_python.get_20_percent_discount()
    print(f"{book_python.title} by {book_python.author}. Price: ${book_python.price}. Discount Price: ${book_python_discount}")
