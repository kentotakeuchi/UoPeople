'''
Section 6.9 of your textbook ("Debugging") lists three possibilities to consider if a function is not working.

1. Describe each possibility in your own words.


2. Define "precondition" and "postcondition" as part of your description.
Precondition is a requirement before a function is called. For example, given add_two_number(n1, n2), the arguments must have two and the types should be int.

3. Create your own example of each possibility in Python code. List the code for each example, along with sample output from trying to run it.
'''


# 1. Describe each possibility in your own words.
'''
According to Allen Downey(2015), there are three possibilities to detect bugs: precondition, postcondition, and return value.
For the precondition, given arguments might be incorrect. For the postcondition, there's a problem after a function starts. Lastly, a return value could be incorrect.
'''

# 2. Define "precondition" and "postcondition" as part of your description.
'''
Precondition is a requirement to run a function as you intend before it starts.
For example,
'''


# add 2 integers with a precondition
def add_two_number_pre(n1, n2):
    if not isinstance(n1, int) or not isinstance(n2, int):
        print('The type of arguments must be int.')
        return None
    return n1 + n2


'''
The function must have two arguments and the types should be int.
'''
'''
Postcondition is a requirement to run a function as you intend after it starts and before it ends.
For example,
'''


# add 2 integers with a postcondition
def add_two_number_post(n1, n2):
    total = n1 + n2
    if not isinstance(total, int):
        print('The type of arguments much be int.')
        return None
    return total


'''
If the sum of two parameters is NOT type int, return None. "total" variable must be type int.
'''


# invoke the above functions
# print(add_two_number_pre(1, 1.0))
# print(add_two_number_post(1, 1.0))


# 3. Create your own example of each possibility in Python code. List the code for each example, along with sample output from trying to run it.


# add 2 integers with a precondition
def add_two_number_pre(n1, n2):
    if not isinstance(n1, int) or not isinstance(n2, int):
        print('The type of arguments must be int.')
        return None
    return n1 + n2


# invoke the function
print('precondition--------------------')
print(add_two_number_pre(1, 1))
print(add_two_number_pre(1, 1.0))
print(add_two_number_pre(1, '1'))


# add 2 integers with a postcondition
def add_two_number_post(n1, n2):
    total = n1 + n2
    if not isinstance(total, int):
        print('The type of arguments much be int.')
        return None
    return total


# invoke the function
print('postcondition--------------------')
print(add_two_number_pre(1, 1))
print(add_two_number_pre(1, 1.0))
print(add_two_number_pre(1, '1'))


# add 2 integers
def add_two_number(n1, n2):
    total = n1 + n2
    return total


# invoke the function and check the type of the return value of add_two_number
print('return value--------------------')
print(isinstance(add_two_number(1, 1), int))
print(isinstance(add_two_number(1, 1.0), int))
print(isinstance(add_two_number(1, '1'), int))


'''
Output:
precondition--------------------
2
The type of arguments must be int.
None
The type of arguments must be int.
None
postcondition--------------------
2
The type of arguments must be int.
None
The type of arguments must be int.
None
return value--------------------
True
False
Traceback (most recent call last):
  File "/Users/kento/Documents/github/UoPeople/programming-fundamentals/unit4/discussion.py", line 107, in <module>
    print(isinstance(add_two_number(1, '1'), int))
  File "/Users/kento/Documents/github/UoPeople/programming-fundamentals/unit4/discussion.py", line 99, in add_two_number
    total = n1 + n2
TypeError: unsupported operand type(s) for +: 'int' and 'str'
'''


'''
References
Downey, A. (2015).Think Python: How to think like a computer scientist. Needham,Massachusetts: Green Tree Press.
'''
