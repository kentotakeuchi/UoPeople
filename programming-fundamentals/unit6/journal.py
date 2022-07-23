### Part1 ###################

def part1() -> None:
    # Create a string that is a long series of words separated by spaces. The string is your own creative choice. It can be names, favorite foods, animals, anything. Just make it up yourself. Do not copy the string from another source.
    legend_str = 'ronaldinho zidan messi ronald neymar pepe maradona'

    # Turn the string into a list of words using split.
    legend_list = legend_str.split()
    print(legend_list, 'after splitting')

    # Delete three words from the list, but delete each one using a different kind of Python operation.
    legend_list.pop()
    legend_list.remove('neymar')
    del legend_list[1:3]
    print(legend_list, 'after deleting')

    # Sort the list.
    legend_list.sort()
    print(legend_list, 'after sorting')

    # Add new words to the list (three or more) using three different kinds of Python operation.
    legend_list.append('kaka')
    new_legends = ['mbappe', 'iniesta']
    legend_list.extend(new_legends)
    legend_list += ['xavi']
    print(legend_list, 'after adding')

    # Turn the list of words back into a single string using join.
    new_legend_str = ' '.join(legend_list)
    print(new_legend_str, 'after joining')

    # Print the string.
    print(new_legend_str)


### Part2 ###################

# Provide your own examples of the following using Python lists. Create your own examples.
def part2() -> None:
    # Nested lists
    lst = [['abc', 'dfg', 'hij'], [10, 11, 8, 7, 9], [{'apple': 1}, {
        'banana': 3}, {'cherry': 10}], [True, False, True]]
    print(f'Nested lists -> {lst}')

    # The “*” operator
    lst[0] *= 2
    print(f'The “*” operator -> {lst}')

    # List slices
    new_lst = lst[:-1]
    print(f'List slices -> new_lst: {new_lst} | lst: {lst}')

    # The “+=” operator
    for i in range(len(new_lst[1])):
        new_lst[1][i] += 100
    print(f'The “+=” operator -> {new_lst}')

    # A list filter
    filtered_new_lst = list(filter(lambda nest: len(nest) > 3, new_lst))
    print(f'A list filter -> {filtered_new_lst}')

    # A list operation that is legal but does the "wrong" thing, not what the programmer expects
    filtered_new_lst[1] = filtered_new_lst[1].sort()
    print(
        f'A list operation that is legal but does the "wrong" thing, not what the programmer expects -> {filtered_new_lst}')

    # Provide the Python code and output for your program and all your examples.
    '''
    Nested lists -> [['abc', 'dfg', 'hij'], [10, 11, 8, 7, 9], [{'apple': 1}, {'banana': 3}, {'cherry': 10}], [True, False, True]]
    The “*” operator -> [['abc', 'dfg', 'hij', 'abc', 'dfg', 'hij'], [10, 11, 8, 7, 9], [{'apple': 1}, {'banana': 3}, {'cherry': 10}], [True, False, True]]
    List slices -> new_lst: [['abc', 'dfg', 'hij', 'abc', 'dfg', 'hij'], [10, 11, 8, 7, 9], [{'apple': 1}, {'banana': 3}, {'cherry': 10}]] | lst: [['abc', 'dfg', 'hij', 'abc', 'dfg', 'hij'], [10, 11, 8, 7, 9], [{'apple': 1}, {'banana': 3}, {'cherry': 10}], [True, False, True]]
    The “+=” operator -> [['abc', 'dfg', 'hij', 'abc', 'dfg', 'hij'], [110, 111, 108, 107, 109], [{'apple': 1}, {'banana': 3}, {'cherry': 10}]]
    A list filter -> [['abc', 'dfg', 'hij', 'abc', 'dfg', 'hij'], [110, 111, 108, 107, 109]]
    A list operation that is legal but does the "wrong" thing, not what the programmer expects -> [['abc', 'dfg', 'hij', 'abc', 'dfg', 'hij'], None]
    '''


### Part3 ###################

'''
Describe your experience so far with peer assessment of Programming Assignments.

How do you feel about the aspect assessments and feedback you have received from your peers?
All assessments and feedback from my peers are positive and I have never received any rude feedback so far.
Especially, some peers spent a lot of time on giving helpful feedback to me.
Although some others just tried to comment something like good job since we need to give feedback for our grade, it's fine with me.

How do you think your peers feel about the aspect assessments and feedback you provided them?
Now, since I have considered my peer's feeling while giving feedback, I hope no one hurts due to my feedback.
I learned something important regarding peer assessment at the beginning of this term.
As we have never seen each other and need to communicate each other without gestures and facial expression, how I comment my thought to them with only text is quite important.
'''


def main():
    part1()
    part2()


# call all functions in this file
main()
