from S1_OOP.book.src.Book import Book


def run():
    book = Book("Learning Python", "Mark Lutz", 1160, 45)

    print(book.title)
    print(f"List Price: ${book.price}")

    discount_percent = 15
    book.set_discount(discount_percent)
    print(f"Discount: {discount_percent}%")
    print(f"Discounted Price: ${book.get_price()}")
    
    
    
