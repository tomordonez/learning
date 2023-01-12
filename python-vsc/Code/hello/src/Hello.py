class Hello:
    def __init__(self, name) -> None:
        self.name = name

    def get_name_concatenated_twice(self):
        return (self.name + self.name)
