# concatenate
def exercise_1() -> None:
    prefixes = 'JKLMNOPQ'
    suffix = 'ack'
    for letter in prefixes:
        if letter == 'O' or letter == 'Q':
            print(f'{letter}u{suffix}')
        else:
            print(letter + suffix)


def main():
    print('--- exercise_1 --------------------------')
    exercise_1()


# run code
main()
