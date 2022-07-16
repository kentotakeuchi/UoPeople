'''
Part 1
Encapsulate the following Python code from Section 7.5 in a function named my_sqrt that takes a as a parameter, chooses a starting value for x, and returns an estimate of the square root of a.
'''
import math


# return an estimate of the square root of a
def my_sqrt(a: int) -> float:
    # avoid ZeroDivisionError
    if a == 0:
        return 0.0
    x = 10
    while True:
        y = (x + a/x) / 2.0
        if y == x:
            break
        x = y
    return y


# test cases
print('--- my_sqrt --------------------')
print(my_sqrt(4))
print(my_sqrt(10))
print(my_sqrt(0))


'''
Part 2
Write a function named test_sqrt that prints a table like the following using a while loop, where "diff" is the absolute value of the difference between my_sqrt(a) and math.sqrt(a). 
'''


#  print the value of my_sqrt(a), the value of math.sqrt(a), and the difference between my_sqrt(a) and math.sqrt(a)
def test_sqrt() -> None:
    a = 1
    while a <= 25:
        mysqrt = my_sqrt(a)
        mathsqrt = math.sqrt(a)
        diff = abs(mysqrt - mathsqrt)
        print(
            f'a = {a} | my_sqrt(a) = {mysqrt} | math.sqrt(a) = {mathsqrt} | diff = {diff}')
        a += 1


# test
print('--- test_sqrt --------------------')
test_sqrt()
