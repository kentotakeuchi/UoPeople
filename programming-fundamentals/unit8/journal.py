'''
Modify your program from Learning Journal Unit 7 to read dictionary items from a file and write the inverted dictionary to a file. You will need to decide on the following:
How to format each dictionary item as a text string in the input file.
How to covert each input string into a dictionary item.
How to format each item of your inverted dictionary as a text string in the output file.
Create an input file with your original three-or-more items and add at least three new items, for a total of at least six items.
Include the following in your Learning Journal submission: 
The input file for your original dictionary (with at least six items).
The Python program to read from a file, invert the dictionary, and write to a different file.
The output file for your inverted dictionary.
A description of how you chose to encode the original dictionary and the inverted dictionary in text files.
'''


import os
# import json
import re
# import ast


# invert the dictionary
def invert_dict(d: dict) -> dict:
    print('inverting dict..')
    inverse = dict()
    for key in d:
        vals = d[key]
        for v in vals:
            if v not in inverse:
                inverse[v] = [key]
            else:
                inverse[v].append(key)
    return inverse


# read from a file
def read_file(filename: str) -> dict:
    print('reading file..')
    # dict_str = ''
    d = {}
    cwd = os.getcwd()
    print(cwd, filename)
    fin = open(f'{cwd}/programming-fundamentals/unit8/{filename}')
    for line in fin:
        # dict_str += line.strip()
        if line.strip() == '{' or line.strip() == '}':
            continue
        key, val = line.strip().split(':')
        if val[-1] == ',':
            val = val[:-1]
        val = re.sub(r"[\[\]]", "", val).strip().replace("'", "").split(', ')
        d[key] = val

    ''' not actually dict but str..'''
    # avoid json.decoder.JSONDecodeError
    # dict_str = '"' + dict_str + '"'
    # covert string into dictionary
    # d = json.loads(dict_str)

    ''' hard to format to create a dict.. '''
    # dict_list = re.split(r"[:,\s]\s*", dict_str)
    # for i, s in enumerate(dict_list):
    #     print(i, s)

    fin.close()
    return d


# write to a different file
def write_file(d: dict) -> None:
    print('writing on the file..')
    cwd = os.getcwd()
    print(cwd)
    fout = open(f'{cwd}/programming-fundamentals/unit8/output.txt', 'w')
    fout.write('{\n')
    for k, v in d.items():
        v = [item.replace("'", "") for item in v]
        line = "  '%s': %s," % (k, v)
        fout.write(f'{line}\n')
    fout.write('}')
    fout.close()


def main():
    # read data from a file and store it as dictionary
    input_dict = read_file('input.txt')
    # print(input_dict)

    # "key: value" -> "value -> key"
    inverted_input_dict = invert_dict(input_dict)
    # print(inverted_input_dict)

    # write the inverted dictionary to a different file
    write_file(inverted_input_dict)


# call all functions in this file
main()


'''
description:
Although I tried to convert string-like-dictionary to actual dictionary with several ways, most of them did not work.
I thought json.loads() or ast.literal_eval() is easier to convert it, but the return value is still a string, not a dictionary.
Therefore, I decided to build the dictionary manually by exploiting keys and values from the string-like-dictionary.
Once I succeeded to convert it, the rest of process was straightforward.
'''
