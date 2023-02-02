from s2inheritance.shape.src.Shape import Shape


class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius

    def calculate_area(self):
        return 3.14 * (self.radius ** 2)
