'''
Describe the difference between objects and values using the terms “equivalent” and “identical”. Illustrate the difference using your own examples with Python lists and the “is” operator.  

Describe the relationship between objects, references, and aliasing. Again, create your own examples with Python lists.

Finally, create your own example of a function that modifies a list passed in as an argument. Describe what your function does in terms of arguments, parameters, objects, and references. 
'''


# 1. Describe the difference between objects and values using the terms “equivalent” and “identical”. Illustrate the difference using your own examples with Python lists and the “is” operator.
# example
# check if 2 equivalent string and list objects are identical or not, and print out the result.
from typing import List


def diff_between_objects_and_values() -> None:
    # string
    str1 = 'soccer'
    str2 = 'soccer'
    print(f'checking {str1} and {str2}..')
    if str1 is str2:
        print('The two string objects are "equivalent" and "identical"')
    else:
        print('The two string objects are "equivalent" but NOT "identical"')

    # list
    list1 = ['a', 'b', 'c']
    list2 = ['a', 'b', 'c']
    print(f'checking {list1} and {list2}..')
    if list1 is list2:
        print('The two list objects are "equivalent" and "identical"')
    else:
        print('The two list objects are "equivalent" but NOT "identical"')


# output
'''
checking soccer and soccer...
The two string objects are "equivalent" and "identical"
checking ['a', 'b', 'c'] and ['a', 'b', 'c']...
The two list objects are "equivalent" but NOT "identical"
'''


# explanation
'''
As you can see the above example, if two string objects have the same value, the values are equivalent and the objects are identical since "Python only created one string object" (Downey, 2015).
However, when it comes to list, even if two lists have the same values, the values are equivalent but the objects are not identical, which means that the two lists are not the same object.
'''


# 2. Describe the relationship between objects, references, and aliasing. Again, create your own examples with Python lists.
# example
# show the example of references and aliasing.
def relationship_between_objects_references_aliasing() -> None:
    list1 = ['a', 'b', 'c']
    list2 = list1
    print(f'checking {list1} and {list2}..')
    if list1 is list2:
        print('The two variables point at the same object.')
    else:
        print('The two variables do not point at the same object')


# output
'''
checking ['a', 'b', 'c'] and ['a', 'b', 'c']..
The two variables point at the same object.
'''


# explanation
'''
A reference is a connection between a variable and an object. In the above example, the variable list1 and list2 are references of ['a', 'b', 'c'].
Aliased is called when the same object has more than one reference. Therefore, the value ['a', 'b', 'c'] is aliased since there are two references.
'''


# 3. Finally, create your own example of a function that modifies a list passed in as an argument. Describe what your function does in terms of arguments, parameters, objects, and references.
# example
# loop over the list 'words' to remove unnecessary characters.
def clean_words(words: List[str]) -> List[str]:
    for i in range(len(words)):
        words[i] = filter_z(words[i])
    return words


# remove 'z'
def filter_z(word: str) -> bool:
    new_word = ''
    for i in range(len(word)):
        if word[i] != 'z':
            new_word += word[i]
    return new_word


# output
'''
['apple', 'banana', 'orange']
'''


# explanation
'''
The argument fruits and the parameter words are pointing the same objects.
That is, the two variables are references of the same object ['azpplez', 'bzananza', 'oraznge']
'''


def main():
    diff_between_objects_and_values()
    relationship_between_objects_references_aliasing()

    fruits = ['azpplez', 'bzananza', 'oraznge']
    print(clean_words(fruits))


# call all function in this file
main()


'''
References
Downey, A. (2015).Think Python: How to think like a computer scientist. Needham,Massachusetts: Green Tree Press.
'''
