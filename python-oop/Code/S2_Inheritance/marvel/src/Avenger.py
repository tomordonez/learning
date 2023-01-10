from S2_Inheritance.marvel.src.Human import Human
from S2_Inheritance.marvel.src.Superhero import Superhero


class Avenger(Superhero, Human):
    def __init__(self, name):
        Human.__init__(self, name)
