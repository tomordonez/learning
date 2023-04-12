from unittest import TestCase

from tdd_pycharm.src.calculator import Calculator


class TestCalculator(TestCase):
    def test_add_two_numbers(self):
        calculator = Calculator()
        self.assertEqual(5, calculator.add_two_numbers(2, 3))
