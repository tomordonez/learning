from S2_Inheritance.publication.src.Periodical import Periodical


class Newspaper(Periodical):
    def __init__(self, title, price, period, publisher):
        super().__init__(title, price, period, publisher)
