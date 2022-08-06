# original dictionary
students_info = {
    'mika': ['10\'s', 'soccer', 'california'],
    'steven': ['20\'s', 'reading', 'california'],
    'xiao': ['10\'s', 'soccer', 'arizona']
}


# build an inverted dictionary like "key: value" -> "value -> key"
def invert_dict(d: dict) -> dict:
    inverse = dict()
    for key in d:
        vals = d[key]
        for v in vals:
            if v not in inverse:
                inverse[v] = [key]
            else:
                inverse[v].append(key)
    return inverse


'''
the output:
original dictionary: {'mika': ["10's", 'soccer', 'california'], 'steven': ["20's", 'reading', 'california'], 'xiao': ["10's", 'soccer', 'arizona']}
inverted dictionary: {"10's": ['mika', 'xiao'], 'soccer': ['mika', 'xiao'], 'california': ['mika', 'steven'], "20's": ['steven'], 'reading': ['steven'], 'arizona': ['xiao']}

the explanation:
My dictionary "students_info" is efficient when you want to search a student data by using the student name.
Because it does not need to loop over the entire dictionary.
However, for example, if you want to know who likes soccer, the lookup is much slower than the above since "soccer" is not a key but a value.
That is why an inverted dictionary is useful because "soccer" is a key now, so it is much efficient to search for the students who like soccer.
'''


def main():
    inverted_students_info = invert_dict(students_info)
    print(f'original dictionary: {students_info}')
    print(f'inverted dictionary: {inverted_students_info}')


# call the functions the instructor asked
main()
