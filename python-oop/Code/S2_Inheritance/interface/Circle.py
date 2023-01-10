from S2_Inheritance.interface.Jsonify import Jsonify
from S2_Inheritance.interface.Shape import Shape


class Circle(Shape, Jsonify):
    def __init__(self, radius):
        self.radius = radius

    def calculate_area(self):
        return 3.14 * (self.radius ** 2)

    def to_json(self):
        return f'{{ "Circle" : {self.calculate_area()} }}'
