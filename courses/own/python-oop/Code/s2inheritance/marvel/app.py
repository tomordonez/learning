from s2inheritance.marvel.src.Avenger import Avenger


def run():
    avenger = Avenger("Spiderman")
    print(Avenger.__mro__)
    print("Publisher from second inherited class")
    print(avenger.publisher)
