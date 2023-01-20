from s1overview.src.fizzbuzz import FizzBuzz
import unittest


class TestFizzBuzz(unittest.TestCase):

    def setUp(self) -> None:
        self.fizzbuzz = FizzBuzz()

    def test_can_create_fizzbuzz_instance(self):
        self.assertTrue(isinstance(self.fizzbuzz, FizzBuzz))

    def test_get_number_when_set_number(self):
        self.fizzbuzz.number = 1
        self.assertEqual(1, self.fizzbuzz.number)

    def test_get_string_one_when_passing_int_one(self):
        self.fizzbuzz.number = 1
        fizzbuzz_result = self.fizzbuzz.calculate_fizzbuzz()
        self.assertEqual("1", fizzbuzz_result)

    def test_get_string_two_when_passing_int_two(self):
        self.fizzbuzz.number = 2
        fizzbuzz_result = self.fizzbuzz.calculate_fizzbuzz()
        self.assertEqual("2", fizzbuzz_result)

    def test_get_fizz_when_passing_three(self):
        self.fizzbuzz.number = 3
        fizzbuzz_result = self.fizzbuzz.calculate_fizzbuzz()
        self.assertEqual("Fizz", fizzbuzz_result)

    def test_get_buzz_when_passing_five(self):
        self.fizzbuzz.number = 5
        fizzbuzz_result = self.fizzbuzz.calculate_fizzbuzz()
        self.assertEqual("Buzz", fizzbuzz_result)

    def test_get_fizz_when_passing_multiple_of_three(self):
        self.fizzbuzz.number = 6
        fizzbuzz_result = self.fizzbuzz.calculate_fizzbuzz()
        self.assertEqual("Fizz", fizzbuzz_result)

    def test_get_buzz_when_passing_multiple_of_five(self):
        self.fizzbuzz.number = 10
        fizzbuzz_result = self.fizzbuzz.calculate_fizzbuzz()
        self.assertEqual("Buzz", fizzbuzz_result)


if __name__ == "__main__":
    unittest.main()
