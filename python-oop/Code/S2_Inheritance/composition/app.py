from S2_Inheritance.composition.src.Author import Author
from S2_Inheritance.composition.src.Book import Book
from S2_Inheritance.composition.src.Chapter import Chapter


def run():
    author = Author("Mark", "Lutz")
    book = Book("Learning Python", 50, author)
    print(f'{book.author !r}')

    book.add_chapter(Chapter("Chapter 1", 45))
    book.add_chapter(Chapter("Chapter 2", 30))

    print(book.get_book_page_count())
