from s1overview.src.fizzbuzz import FizzBuzz
import unittest


class TestFizzBuzz(unittest.TestCase):
    def test_FizzBuzz_class_exists(self):
        fizzbuzz = FizzBuzz()
        self.assertTrue(isinstance(fizzbuzz, FizzBuzz))

if __name__ == "__main__":
    unittest.main()