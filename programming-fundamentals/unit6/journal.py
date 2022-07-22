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


### Part3 ###################


def main():
    part1()


# call all functions in this file
main()
