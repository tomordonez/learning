from s2inheritance.publication.src.Periodical import Periodical


class Magazine(Periodical):
    def __init__(self, title, price, period, publisher):
        super().__init__(title, price, period, publisher)
