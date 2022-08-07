# variables
alphabet = "abcdefghijklmnopqrstuvwxyz"
test_dups = ["zzz", "dog", "bookkeeper",
             "subdermatoglyphic", "subdermatoglyphics"]
test_miss = ["zzz", "subdermatoglyphic",
             "the quick brown fox jumps over the lazy dog"]


# count each letters and build a hashmap
def histogram(s: str) -> dict:
    d = dict()
    for c in s:
        if c not in d:
            d[c] = 1
        else:
            d[c] += 1
    return d


# Part1 ###############################################


# check if there's any duplicate in the string parameter
def has_duplicate(s: str) -> bool:
    counts = histogram(s)
    for key in counts:
        if counts[key] > 1:
            return True
    return False


# use has_duplicate with string values of the list test_dups
def has_duplicate_in_test_dups() -> None:
    for s in test_dups:
        if has_duplicate(s):
            print(f'{s} has duplicates')
        else:
            print(f'{s} has no duplicates')


'''
output:
zzz has duplicates
dog has no duplicates
bookkeeper has duplicates
subdermatoglyphic has no duplicates
subdermatoglyphics has duplicates
'''


# Part2 ###############################################

# return global variable "alphabet" excluding the letters which are in the string parameter "s"
def missing_letters(s: str) -> str:
    global alphabet
    counts = histogram(s)
    missing_list = list()
    for char in alphabet:
        if char not in counts:
            missing_list.append(char)
    alphabet = ''.join(missing_list)
    return ''.join(missing_list)


# use missing_letters with string values of the list test_miss
def missing_letters_in_test_miss() -> None:
    for s in test_miss:
        missing_str = missing_letters(s)
        if len(missing_str) > 0:
            print(f'{s} is missing letters {alphabet}')
        else:
            print(f'{s} uses all the letters')


'''
output:
zzz is missing letters abcdefghijklmnopqrstuvwxy
subdermatoglyphic is missing letters fjknqvwx
the quick brown fox jumps over the lazy dog uses all the letters
'''


# Main ###############################################


def main():
    has_duplicate_in_test_dups()
    missing_letters_in_test_miss()


# call the functions the instructor asked
main()
