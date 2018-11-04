import unittest

from src.main.python.org.aguinore.crackInterview import crack_interview


class TestCrackInterveiw(unittest.TestCase):

    def test_number_of_pairs(self):
        arr = [10, 20, 20, 10, 10, 30, 50, 10, 20]
        result = 3
        actual = crack_interview.number_of_pairs(arr)
        self.assertEqual(actual, result, "expected: " + str(result) + " actual: " + str(actual))

    def test_number_of_pairs2(self):
        arr = [1, 2, 1, 2, 1, 3, 2]
        result = 2
        self.assertEqual(crack_interview.number_of_pairs(arr), result)