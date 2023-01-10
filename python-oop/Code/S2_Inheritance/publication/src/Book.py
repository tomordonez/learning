from S2_Inheritance.publication.src.Publication import Publication


class Book(Publication):
    def __init__(self, title, price, author, pages):
        super().__init__(title, price)
        self.author = author
        self.pages = pages

