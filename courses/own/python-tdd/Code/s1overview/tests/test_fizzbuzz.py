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


if __name__ == "__main__":
    unittest.main()
