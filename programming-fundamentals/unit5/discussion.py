'''
This assignment is based on Exercise 8.4 from your textbook. Each of the following Python functions is supposed to check whether its argument has any lowercase letters.
For each function, describe what it actually does when called with a string argument. If it does not correctly check for lowercase letters, give an example argument that produces incorrect results, and describe why the result is incorrect.
'''


# 1
# check if there is any lowercase letter in string.
def any_lowercase1(s):
    for c in s:
        print(c)
        if c.islower():
            return True
        else:
            return False


# test cases
print('-------- test case1 ----------------------------------')
print(any_lowercase1('abc'))
print(any_lowercase1('aBC'))
print(any_lowercase1('Abc'))
print(any_lowercase1('ABC'))
print(any_lowercase1(''))


# output
'''
-------- test case1 ----------------------------------
a
True
a
True
A
False
A
False
None
'''


# explanation
'''
The function is supposed to check all letters in s in order to check lowercase letters, but it only checked the first letter.
Although the third test case should be True, the output is False because the function ONLY checks the first letter.
'''


# 2
# check if there is any lowercase letter in string.
def any_lowercase2(s):
    for c in s:
        print(c)
        if 'c'.islower():
            return 'True'
        else:
            return 'False'


# test cases
print('-------- test case2 ----------------------------------')
print(any_lowercase2('abc'))
print(any_lowercase2('aBC'))
print(any_lowercase2('Abc'))
print(any_lowercase2('ABC'))
print(any_lowercase2(''))


# output
'''
-------- test case2 ----------------------------------
a
True
a
True
A
True
A
True
None
'''


# explanation
'''
The function doesn't check the argument s at all because only 'c' letter is checked and, of course, it's always True.
That's why whatever arguments is put, the function always returns True value.
'''


# 3
# check if there is any lowercase letter in string.
def any_lowercase3(s):
    for c in s:
        print(c)
        flag = c.islower()
    return flag


# test cases
print('-------- test case3 ----------------------------------')
print(any_lowercase3('abc'))
print(any_lowercase3('aBC'))
print(any_lowercase3('Abc'))
print(any_lowercase3('ABC'))
# print(any_lowercase3(''))


# output
'''
-------- test case3 ----------------------------------
a
b
c
True
a
B
C
False
A
b
c
True
A
B
C
False
Traceback (most recent call last):
  File "/Users/kento/Documents/github/UoPeople/programming-fundamentals/unit5/discussion.py", line 104, in <module>
    print(any_lowercase3(''))
  File "/Users/kento/Documents/github/UoPeople/programming-fundamentals/unit5/discussion.py", line 95, in any_lowercase3
    return flag
UnboundLocalError: local variable 'flag' referenced before assignment
'''


# explanation
'''
Although the function finally loop over all letters, the return value of test case2 is incorrect.
Because variable name flag is reassigned each loop, so the boolean variable flag only shows if the last letter is lowercase or not.
That is why test case2 is incorrect.
Also, the function can't deal with the edge case which the argument is empty string.
'''


# 4
# check if there is any lowercase letter in string.
def any_lowercase4(s):
    flag = False
    for c in s:
        print('1', flag)
        flag = flag or c.islower()
        print('2', flag)
    return flag


# test cases
print('-------- test case4 ----------------------------------')
print(any_lowercase4('abc'))
print(any_lowercase4('aBC'))
print(any_lowercase4('Abc'))
print(any_lowercase4('ABC'))
print(any_lowercase4(''))


# output
'''
-------- test case4 ----------------------------------
1 False
2 True
1 True
2 True
1 True
2 True
True
1 False
2 True
1 True
2 True
1 True
2 True
True
1 False
2 False
1 False
2 True
1 True
2 True
True
1 False
2 False
1 False
2 False
1 False
2 False
False
False
'''


# explanation
'''
The function returns correct value in all test cases.
However, it's better to return True or False immediately when boolean variable flag becomes True because if the function finds a letter at least, the return value is True.
'''


# 5
# check if there is any lowercase letter in string.
def any_lowercase5(s):
    for c in s:
        print(c)
        if not c.islower():
            return False
    return True


# test cases
print('-------- test case5 ----------------------------------')
print(any_lowercase5('abc'))
print(any_lowercase5('aBC'))
print(any_lowercase5('Abc'))
print(any_lowercase5('ABC'))
print(any_lowercase5(''))


# output
'''
a
b
c
True
a
B
False
A
False
A
False
True
'''


# explanation
'''
The function returns False as soon as it found any uppercase letter.
It means that even if there are lowercase letter after the uppercase letter, it returns False.
That's why test case3 is incorrect.
Also, the function doesn't check the edge case correctly which the argument is empty string.
'''
