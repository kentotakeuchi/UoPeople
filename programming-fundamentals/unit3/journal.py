'''
Copy the countdown function from Section 5.8 of your textbook.
'''


def countdown(n):
    if n <= 0:
        print('Blastoff!')
    else:
        print(n)
        countdown(n-1)


'''
Write a new recursive function countup that expects a negative argument and counts “up” from that number.
'''


def countup(n):
    if n >= 0:
        print('Blastoff!')
    else:
        print(n)
        countup(n+1)


# countdown(3)
# countup(-3)


'''
Write a Python program that gets a number using keyboard input.
If the number is positive, the program should call countdown. If the number is negative, the program should call countup.
Choose for yourself which function to call (countdown or countup) for input of zero.
'''

my_input = int(input('Enter any number: '))
if my_input < 0:
    countup(my_input)
else:
    countdown(my_input)

'''
OUTPUT:

(a positive number)
Enter any number: 10
10
9
8
7
6
5
4
3
2
1
Blastoff!

(a negative number)
Enter any number: -10
-10
-9
-8
-7
-6
-5
-4
-3
-2
-1
Blastoff!

(zero)
Enter any number: 0
Blastoff!

EXPLANATION:
If my_input is 0, countdown function is called because my_input(0, in this case) is not negative number.
Therefore, the first conditional statement(if my_input < 0) is not applied and countdown function in else statement is called.
'''


'''
Write your own unique Python program that has a runtime error.
'''

my_input2 = int(input('Enter any number: '))
my_input3 = input('Enter any number: ')


def add_num(num1, num2):
    print(num1 + num2)


add_num(my_input2, my_input3)


'''
OUTPUT:
Enter any number: 10
Enter any number: 10
Traceback (most recent call last):
  File "/Users/kento/Documents/github/UoPeople/programming-fundamentals/unit3/journal.py", line 96, in <module>
    add_num(my_input2, my_input3)
  File "/Users/kento/Documents/github/UoPeople/programming-fundamentals/unit3/journal.py", line 93, in add_num
    print(num1 + num2)
TypeError: unsupported operand type(s) for +: 'int' and 'str'

EXPLANATION OF THE ERROR MESSAGE:
TypeError often occurs when different types are calculated in an expression.
In this case, the type of the first input is int, but the type of the second input is str.
That is why TypeError occurred.

EXPLANATION OF HOW TO FIX THE ERROR:
The second input(my_input3) should be type int.
input() returns type str.
Therefore, we need to change type str into int by int() like the below.
my_input3 = int(input('Enter any number: '))
'''
