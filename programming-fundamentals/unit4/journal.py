# Part1 #########################################
import math


# stage1
def hypotenuse_1(x, y):
    print(f'x is {x}')
    print(f'y is {y}')
    return 0.0


# explanation
'''
In stage1, I just test if or not the two parameters are what I put as arguments.
Also, the return value is 0.0 because the function is supposed to return type float.
'''

# test input
print('stage1------------------------')
hypotenuse_1(3, 4)
hypotenuse_1(5, 6)
hypotenuse_1(7, 8)

# test output
'''
stage1------------------------
x is 3
y is 4
x is 5
y is 6
x is 7
y is 8
'''


# stage2
def hypotenuse_2(x, y):
    sum_of_squares = x**2 + y**2
    print(f'the sum of squares is {sum_of_squares}')
    return 0.0


# explanation
'''
In stage2, the function prints the sum of x squared and y squared.
Still, the return value is dummy.
'''

# test input
print('stage2------------------------')
hypotenuse_2(3, 4)
hypotenuse_2(5, 6)
hypotenuse_2(7, 8)

# test output
'''
stage2------------------------
the sum of squares is 25
the sum of squares is 61
the sum of squares is 113
'''


# stage3
def hypotenuse(x, y):
    sum_of_squares = x**2 + y**2
    result = math.sqrt(sum_of_squares)
    return result


# explanation
'''
Lastly, in stage3, the function return the actual result.
I used built-in function math.sqrt() to get the final result.
'''

# test input
print('stage3------------------------')
print(hypotenuse(3, 4))
print(hypotenuse(5, 6))
print(hypotenuse(7, 8))

# test output
'''
5.0
7.810249675906654
10.63014581273465
'''


# Part2 #########################################
# stage1
def calc_average_score_1(scores):
    print(f'your scores are {scores}')
    return 0


# explanation
'''
Firstly, check if the function receives the argument properly.
the return value is dummy and 0 since the function is supposed to return type int.
'''

# test input
print('stage1------------------------')
print(calc_average_score_1([100, 90, 80]))
print(calc_average_score_1([70, 60, 50]))
print(calc_average_score_1([40, 30, 20]))

# test output
'''
stage1------------------------
your scores are [100, 90, 80]
0
your scores are [70, 60, 50]
0
your scores are [40, 30, 20]
0
'''


# stage2
def calc_average_score_2(scores):
    sum = 0
    n = len(scores)
    print(f'you have {n} scores')
    for score in scores:
        print(f'looping.. the current score is {score}')
    return 0


# explanation
'''
In stage2, at first, check the length of the parameter and print out.
In addition, check if the parameter is looped over correctly or not.
The return value is still dummy.
'''

# test input
print('stage2------------------------')
print(calc_average_score_2([100, 90, 80]))
print(calc_average_score_2([70, 60, 50]))
print(calc_average_score_2([40, 30, 20]))

# test output
'''
stage2------------------------
you have 3 scores
looping.. the current score is 100
looping.. the current score is 90
looping.. the current score is 80
0
you have 3 scores
looping.. the current score is 70
looping.. the current score is 60
looping.. the current score is 50
0
you have 3 scores
looping.. the current score is 40
looping.. the current score is 30
looping.. the current score is 20
0
'''


# stage3
def calc_average_score_3(scores):
    sum = 0
    n = len(scores)
    for score in scores:
        sum += score
    print(f'the sum of your scores is {sum}')
    return 0


# explanation
'''
In stage3, test the sum of the parameter and print out.
The return value is still dummy.
'''

# test input
print('stage3------------------------')
print(calc_average_score_3([100, 90, 80]))
print(calc_average_score_3([70, 60, 50]))
print(calc_average_score_3([40, 30, 20]))

# test output
'''
stage3------------------------
the sum of your scores is 270
0
the sum of your scores is 180
0
the sum of your scores is 90
0
'''


# stage4
def calc_average_score(scores):
    sum = 0
    n = len(scores)
    for score in scores:
        sum += score
    result = int(sum / n)
    return result


# explanation
'''
Finally, calculate the average of the scores, and return the value.
'''

# test input
print('stage4------------------------')
print(calc_average_score([100, 90, 80]))
print(calc_average_score([70, 60, 50]))
print(calc_average_score([40, 30, 20]))

# test output
'''
stage4------------------------
90
60
30
'''


# Part3 #########################################
'''
# How do you feel about the feedback and ratings you have received from your peers?
Fist of all, can I check the ratings? I couldn't find where they are.
I think all my classmates are so polite so far. Speaking of the feedback, although most of my peers tried to cheer me up, some peers gave me useful tips or advices in detail in addition to cheering me up. Those would be very helpful for me.

# How do you think your peers feel about the feedback you provided them? And the ratings you gave them?
A student reached out to me privately after I gave feedback to them. They asked me if I was ok with their feedback since they also gave me feedback. However, I felt they tried to convey their feeling. It is hard to explain, but the thing is they pointed out my assignment and I also pointed out their assignment. Therefore, they might have felt my feedback is a bit retaliation. Anyway, we communicated and fix the misunderstanding. That is my experience so far. I think the peers I gave the feedback are satisfied with my ratings since I haven't received any response from them.
'''


'''
Reference:  
Downey, A. (2015). Think Python: How to think like a computer scientist. Needham, Massachusetts: Green Tree Press. 
'''
