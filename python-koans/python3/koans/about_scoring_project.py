#!/usr/bin/env python
# -*- coding: utf-8 -*-

from runner.koan import *

# Greed is a dice game where you roll up to five dice to accumulate
# points.  The following "score" function will be used calculate the
# score of a single roll of the dice.
#
# A greed roll is scored as follows:
#
# * A set of three ones is 1000 points
#
# * A set of three numbers (other than ones) is worth 100 times the
#   number. (e.g. three fives is 500 points).
#
# * A one (that is not part of a set of three) is worth 100 points.
#
# * A five (that is not part of a set of three) is worth 50 points.
#
# * Everything else is worth 0 points.
#
#
# Examples:
#
# score([1,1,1,5,1]) => 1150 points
# score([2,3,4,6,2]) => 0 points
# score([3,4,5,3,3]) => 350 points
# score([1,5,1,2,4]) => 250 points
#
# More scoring examples are given in the tests below:
#
# Your goal is to write the score method.


def score(dice):
    # Count the numbers of each element
    dice_generator = (x for x in dice)
    count_of_dice_number = {1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0}
    loop_count = 0

    while loop_count < len(dice):
        next_dice = next(dice_generator)
        count_of_dice(count_of_dice_number, next_dice)
        loop_count += 1

    points = 0

    if len(dice) == 0:
        return points
    else:
        points_one = calculate_points(1, count_of_dice_number)
        points_two = calculate_points(2, count_of_dice_number)
        points_three = calculate_points(3, count_of_dice_number)
        points_four = calculate_points(4, count_of_dice_number)
        points_five = calculate_points(5, count_of_dice_number)
        points_six = calculate_points(6, count_of_dice_number)

        points += points_one + points_two + points_three + \
            points_four + points_five + points_six

        return points


def count_of_dice(count_of_dice_number, next_dice):
    if next_dice == 1:
        count_of_dice_number[next_dice] += 1
    elif next_dice == 2:
        count_of_dice_number[next_dice] += 1
    elif next_dice == 3:
        count_of_dice_number[next_dice] += 1
    elif next_dice == 4:
        count_of_dice_number[next_dice] += 1
    elif next_dice == 5:
        count_of_dice_number[next_dice] += 1
    else:
        count_of_dice_number[next_dice] += 1


def calculate_points(number, count_of_dice_number):
    if number not in [1, 5]:
        if count_of_dice_number[number] == 3:
            return 100 * number
        else:
            return 0
    elif number == 1:
        if count_of_dice_number[number] == 0:
            points = 0
        elif count_of_dice_number[number] >= 3:
            points = 100 * (count_of_dice_number[number] - 3) + 1000
        else:
            points = 100 * count_of_dice_number[number]
    elif number == 5:
        if count_of_dice_number[number] == 0:
            points = 0
        elif count_of_dice_number[number] >= 3:
            points = 50 * (count_of_dice_number[number] - 3) + 500
        else:
            points = 50 * count_of_dice_number[number]

    return points


class AboutScoringProject(Koan):
    def test_score_of_an_empty_list_is_zero(self):
        self.assertEqual(0, score([]))

    def test_score_of_a_single_roll_of_5_is_50(self):
        self.assertEqual(50, score([5]))

    def test_score_of_a_single_roll_of_1_is_100(self):
        self.assertEqual(100, score([1]))

    def test_score_of_multiple_1s_and_5s_is_the_sum_of_individual_scores(self):
        self.assertEqual(300, score([1, 5, 5, 1]))

    def test_score_of_single_2s_3s_4s_and_6s_are_zero(self):
        self.assertEqual(0, score([2, 3, 4, 6]))

    def test_score_of_a_triple_1_is_1000(self):
        self.assertEqual(1000, score([1, 1, 1]))

    def test_score_of_other_triples_is_100x(self):
        self.assertEqual(200, score([2, 2, 2]))
        self.assertEqual(300, score([3, 3, 3]))
        self.assertEqual(400, score([4, 4, 4]))
        self.assertEqual(500, score([5, 5, 5]))
        self.assertEqual(600, score([6, 6, 6]))

    def test_score_of_mixed_is_sum(self):
        self.assertEqual(250, score([2, 5, 2, 2, 3]))
        self.assertEqual(550, score([5, 5, 5, 5]))
        self.assertEqual(1150, score([1, 1, 1, 5, 1]))

    def test_ones_not_left_out(self):
        self.assertEqual(300, score([1, 2, 2, 2]))
        self.assertEqual(350, score([1, 5, 2, 2, 2]))
