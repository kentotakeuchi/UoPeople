# Programming Assign. Unit 7
# All the functions remain usable for any text outside the variables given even after running the program.
import time
alphabet = "abcdefghijklmnopqrstuvwxyz"
test_dups = ["zzz", "dog", "bookkeeper",
             "subdermatoglyphic", "subdermatoglyphics"]
test_miss = ["zzz", "subdermatoglyphic",
             "the quick brown fox jumps over the lazy dog"]


def histogram(s):  # The code of this function is the same as it is in the book
    d = dict()
    for c in s:
        if c not in d:
            d[c] = 1
        else:
            d[c] += 1
    return d
# Part 1


def has_duplicates(s):  # for this function, I reused the code from the discussion Unit 5 4th example, it returns True or False
    h = histogram(s)
    flag = False
    for i in h:
        flag = flag or h[i] > 1
    return flag


print("Part 1")
print('')
time.sleep(2)
for x in test_dups:  # This is the loop that prints the results of the evaluation of duplicates in test_dups
    if has_duplicates(x) == True:
        print(x, "has duplicates")
    else:
        print(x, "has no duplicates")
# Part 2


def missing_letters(q):  # For this function, I used the built-in method find to compare one string against each element of the string alphabet
    m = ''
    for i in alphabet:
        if q.find(i) == -1:
            m = m + i
    if m == '':
        print(q, "uses all letters")
    else:
        print(q, "is missing letters", m)
    del(m)


print('')
time.sleep(2)
print("Part 2")
print('')
time.sleep(2)
for k in test_miss:  # This is the loop that prints the results of the evaluation of missing letters in test_miss
    missing_letters(k)
