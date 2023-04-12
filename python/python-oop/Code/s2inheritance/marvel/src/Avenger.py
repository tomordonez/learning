from s2inheritance.marvel.src.Human import Human
from s2inheritance.marvel.src.Superhero import Superhero


class Avenger(Superhero, Human):
    def __init__(self, name):
        Human.__init__(self, name)
