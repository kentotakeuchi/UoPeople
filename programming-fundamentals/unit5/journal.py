# concatenate strings and print it out
def exercise_1() -> None:
    prefixes = 'JKLMNOPQ'
    suffix = 'ack'
    for letter in prefixes:
        if letter == 'O' or letter == 'Q':
            print(f'{letter}u{suffix}')
        else:
            print(letter + suffix)


# capitalize the first letter of s
def capitalize_first_letter(s: str) -> str:
    # edge case
    if len(s) == 0:
        return 'Empty string does not make sense.'
    first_letter = s[0].upper()
    non_first_letters = s[1:]
    return f'{first_letter}{non_first_letters}'


'''
Explanation:
The function capitalizes the first letter of the argument s.
If the argument is empty string, it complains.
Ex. string[start:end:step]
For string slice, if there is only starting index, it means that the string is sliced including starting index to the end of the string.
In the above case s[1:], it includes the index 1 to the end.
'''


# reverse word
def reverse_word(word: str) -> str:
    return word[::-1]


'''
Explanation:
The function reverses the argument word.
String slice in python can omit start and end index.
In the above case word[::-1], the variable word becomes in reverse order because step index is -1.
This is a bit tricky for me.
'''


# print out stairs with s
def generate_stairs(s: str) -> None:
    if len(s) < 2:
        print('Enter greater than equal 2 length of string at least to enjoy stairs.')
        return
    for i in range(1, len(s)+1):
        # print out letters incrementally
        print(s[:i])


'''
Explanation:
The function generates stairs with the argument s.
If there is only ending index like s[:i], it means that it starts with 0 index to the ending index excluding the ending index.
'''


def main():
    print('--- exercise_1 --------------------------')
    exercise_1()

    print('--- capitalize_first_letter --------------------------')
    print(capitalize_first_letter('apple'))
    print(capitalize_first_letter('a'))
    print(capitalize_first_letter(''))

    print('--- reverse_word --------------------------')
    print(reverse_word('apple'))
    print(reverse_word('a'))
    print(reverse_word(''))

    print('--- generate_stairs --------------------------')
    generate_stairs('apple')
    generate_stairs('pineapple')
    generate_stairs('a')
    generate_stairs('')


# run code
main()


'''
output:
--- exercise_1 --------------------------
Jack
Kack
Lack
Mack
Nack
Ouack
Pack
Quack
--- capitalize_first_letter --------------------------
Apple
A
Empty string does not make sense.
--- reverse_word --------------------------
elppa
a

--- generate_stairs --------------------------
a
ap
app
appl
apple
p
pi
pin
pine
pinea
pineap
pineapp
pineappl
pineapple
Enter greater than equal 2 length of string at least to enjoy stairs.
Enter greater than equal 2 length of string at least to enjoy stairs.
'''
