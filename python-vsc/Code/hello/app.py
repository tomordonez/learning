from src.Hello import Hello


def run():
    input_name = input("Enter your name: ")
    hello = Hello(input_name)

    print(f"Hello {hello.name}")
