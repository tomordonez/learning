class Calculator:
    def __init__(self):
        self.second_number = None
        self.first_number = None

    def add_two_numbers(self, first_number, second_number):
        self.first_number = first_number
        self.second_number = second_number
        addition = self.first_number + self.second_number
        return addition

