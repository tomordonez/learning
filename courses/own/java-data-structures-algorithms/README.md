# 1. Introduction to Algorithms

**Euclid's algorithm**

Find the GCD (greater common divisor) of two positive integers.

* Two positive numbers `m`, `n`, such that `m > n`
* Step1: Divide `m` by `n`, let the remainder be `r`
* Step2: If `r = 0`, the algorithm ends, `n` is the GCD
* Step3: If `r != 0`, set `m = n`, `n = r`, go back to Step1, and continue until `r = 0`

This is a recursive algorithm, because it calls itself until it finds the `r = 0`

**Bubble sort algorithm**

(Bubble because the largest numbers bubbles out to the right)

Given a set of numbered balls like `[10, 2, 8, 6, 7, 3]` each in a bucket, plus an additional empty bucket.

* You can only pick one ball at a time
* Before picking up another ball, you have to drop the existing picked ball in the empty basket
* You have to start from left and arrange towards the right
* Keep track of the sorted path

1st run Sorting

* Compare the first two numbers `10, 2`
  * `2 < 10`. Move `2` out. Move `10` to the right. Move `2` to the position where `10` was
  * Result:`[2, 10, 8, 6, 7, 3]`
* Compare the next two numbers `10, 8`
  * `8 < 10`. Move `8` out. Move `10` to the right. Move `8` to where `10` was
  * Result: `[2, 8, 10, 6, 7, 3]`
* Compare `10, 6`
  * `6 < 10`. Move the numbers
  * Result: `[2, 8, 6, 10, 7, 3]`
* Compare `10, 7`
  * `7 < 10`. Move the numbers
  * Result: `[2, 8, 6, 7, 10, 3]`
* Compare `10, 3`
  * `3 < 10`. Move the numbers
  * Result: `[2, 8, 6, 7, 3, 10]`
* Largest number `10` is on the most right position

2nd run sorting

* Pointer is on `10`
* Sort the remaining unsorted numbers `[2, 8, 6, 7, 3,`
* Compare `2, 8`. They are sorted
* Compare `8, 6`. Move the numbers
  * Result: `[2, 6, 8, 7, 3`
* Compare `8, 7`. Move the numbers
  * Result: `[2, 6, 7, 8, 3`
* Compare `8, 3`. Move the numbers
  * Result: `[2, 6, 7, 3, 8, 10]`
* The pointer is now on `8` the second-largest number

**Correctness of an algorithm**

* Step1: Statement to be proven
* Step2: List all assumptions
* Step3: Chain of reasoning from assumptions to the statement

Incorrectness:

* Step1: Give a set of data for which the algorithm doesn't work
* Step2: Usually consider small datasets
* Step3: Consider edge cases

# 2. Analysis of Algorithms
# 3. Basic Sorting and Search Algorithms
# 4. Linked Lists
# 5. Stacks and Queues
# 6. Recursion
# 7. Binary Search Trees
# 8. More Sorting Algorithms
# 9. Heaps
# 10. Hashtables