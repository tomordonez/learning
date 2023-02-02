from s2inheritance.publication.src.Publication import Publication


class Periodical(Publication):
    def __init__(self, title, price, period, publisher):
        super().__init__(title, price)
        self.period = period
        self.publisher = publisher
