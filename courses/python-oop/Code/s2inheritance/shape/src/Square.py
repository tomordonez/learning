from s2inheritance.shape.src.Shape import Shape


class Square(Shape):
    def __init__(self, side):
        self.side = side

    def calculate_area(self):
        return self.side ** 2
