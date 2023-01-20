from s2inheritance.shape.src.Circle import Circle
from s2inheritance.shape.src.Square import Square


def run():
    circle = Circle(4)
    print(circle.calculate_area())

    square = Square(4)
    print(square.calculate_area())
