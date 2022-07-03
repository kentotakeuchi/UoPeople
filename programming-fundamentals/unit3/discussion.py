'''
Describe the difference between a chained conditional and a nested conditional. Give your own example of each.

Deeply nested conditionals can become difficult to read. Describe a strategy for avoiding nested conditionals. Give your own example of a nested conditional that can be modified to become a single conditional, and show the equivalent single conditional.
'''

# Describe the difference between a chained conditional and a nested conditional.
# The difference between a chained conditional and a nested conditional is a level of indentation. A chained conditional has conditional statements on the same level of indentation. On the other hand, A nested conditional has conditional statements inside a conditional statements. Therefore, the level of indentation is different.

# Give your own example of each.


# A chained conditional
def can_drink_beer1(age):
    if age < 0:
        print('Please enter a right age.')
    elif 0 <= age and age < 21:
        print('No, you cannot.')
    else:
        print('Yes, you can.')


# A nested conditional
def can_drink_beer2(age):
    if age < 0:
        print('Please enter a right age.')
    elif 0 <= age and age < 21:
        print('No, you cannot.')
    else:
        if 130 < age:
            print('Please enter a right age.')
        else:
            print('Yes, you can.')


# call the functions
can_drink_beer1(-10)
can_drink_beer1(18)
can_drink_beer1(65)
can_drink_beer2(-10)
can_drink_beer2(18)
can_drink_beer2(89)
can_drink_beer2(150)


# Describe a strategy for avoiding nested conditionals.
# Using logical operators(and, or, not) could be one of the strategies to avoid nested conditionals.

# Give your own example of a nested conditional that can be modified to become a single conditional, and show the equivalent single conditional.


# A nested conditional
def is_introvert1(love_party, hobby):
    if love_party:
        if hobby == 'reading':
            print('True')
            return True
        elif hobby == 'sleeping':
            print('True')
            return True
        else:
            print('False')
            return False
    else:
        if hobby == 'talking':
            print('False')
            return False
        else:
            print('True')
            return True


# The equivalent single conditional
def is_introvert2(love_party, hobby):
    if love_party and hobby == 'reading' or hobby == 'sleeping':
        print('True')
        return True
    elif not love_party and hobby == 'talking':
        print('False')
        return False
    elif love_party:
        print('False')
        return False
    else:
        print('True')
        return True


# Call the functions
is_introvert1(True, 'reading')
is_introvert1(True, 'sleeping')
is_introvert1(False, 'talking')
is_introvert1(True, 'walking')
is_introvert1(False, 'eating')
is_introvert2(True, 'reading')
is_introvert2(True, 'sleeping')
is_introvert2(False, 'talking')
is_introvert2(True, 'walking')
is_introvert2(False, 'eating')
