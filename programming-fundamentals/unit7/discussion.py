# tuples
'''
A tuple, which is a built-in type in Python, is a sequence of values.
While tuples are similar to lists, there is the big difference between them.
Lists are mutable, but tuples are immutable.
It means that values of tuples cannot be changed.
'''


# the zip function
'''
The zip function is a built-in function in Python.
The function takes multiple iterable objects such as list, dictionary, or string.
The function returns a zip object which is an sequences of tuples.
Here is the example.
'''


# the function takes 2 iterable arguments
# the first argument is an integer iterable.
# the second argument is a string iterable.
# the function returns the updated user's database.
def create_users(ids, names) -> dict:
    my_dict = dict()
    for user_info in zip(ids, names):
        if user_info not in my_dict:
            my_dict[user_info] = 'active'
    return my_dict


'''
the output:
{(1, 'john'): 'active', (2, 'mike'): 'active', (3, 'alex'): 'active'}

comment:
Unlike lists, tuples can be "key" of dictionary because tuples are immutable.
'''


# the enumerate function
'''
The enumerate function is a built-in function in Python.
The function takes an iterable object as the first argument and integer which indicates starting point of index as the second argument(optional). If the second argument is omitted, zero is taken.
The function is useful when you need the value of each element in an iterable and the indices at the same time.
The indices start from zero.
Here is the example.
'''


# the function takes 1 iterable argument
# the argument is the player's name and the order must be from the highest rank.
# the function returns a dictionary in which the key is rank and the value is name.
def rank_players(players) -> dict:
    my_dict = {}
    for i, player in enumerate(players, 1):
        my_dict[i] = player
    return my_dict


'''
the output:
{1: 'john', 2: 'mike', 3: 'alex', 4: 'bob', 5: 'max'}
'''


# the items method
'''
The items method is a method of dictionaries in Python.
The method does not take any arguments.
The method returns a sequence of tuples.
Here is the example.
'''


# the function takes a dictionary as an argument
# the function returns a sequence of tuples
def describe_dict_items(my_dict: dict):
    my_list = my_dict.items()
    for key, val in my_list:
        my_dict[key] = f'new {val}'
    return my_list


'''
the output:
dict_items([(1, 'new john'), (2, 'new mike'), (3, 'new alex'), (4, 'new bob'), (5, 'new max')])

comment:
As the above example shows, items() does not return a new object.
Therefore, if the value of my_dict(original) is changed, my_list reflects on the update.
'''


def main():
    print(create_users([1, 2, 3], ['john', 'mike', 'alex']))
    print(rank_players(('john', 'mike', 'alex', 'bob', 'max')))
    print(describe_dict_items(
        {1: 'john', 2: 'mike', 3: 'alex', 4: 'bob', 5: 'max'}))


# call all function in this file
main()


'''
References
Downey, A. (2015).Think Python: How to think like a computer scientist. Needham,Massachusetts: Green Tree Press.
'''
