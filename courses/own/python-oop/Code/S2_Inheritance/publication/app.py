from S2_Inheritance.publication.src.Book import Book
from S2_Inheritance.publication.src.Newspaper import Newspaper
from S2_Inheritance.publication.src.Magazine import Magazine


def run():
    book = Book("Learning Python", 50, "Mark Lutz", 1000)
    newspaper = Newspaper("El Tiempo", 5, "Daily", "Bogota")
    magazine = Magazine("Harvard Review", 15, "Weekly", "Harvard")

    print(f'{book !r}')
    print(f'{newspaper !r}')
    print(f'{magazine !r}')
