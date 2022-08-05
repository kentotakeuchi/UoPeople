import os


# test the exception if the file does not exist in the current working directory
def catch_exceptions_IOError() -> None:
    try:
        # get the path of the current working directory
        cwd = os.getcwd()
        print(cwd)
        # return a list of files and directories in the current working directory
        dir_list = os.listdir(cwd)
        print(dir_list)

        fin = open('no_exist.txt')
        fin.close()
    except IOError:
        print('💥 Please check the file exists in the current working directory.')


'''
Output:
/Users/kento/Documents/github/UoPeople/programming-fundamentals/unit8
['journal.py', 'discussion.py']
💥 Please check the file exists in the current working directory.
'''


# test the exception if the directory tries to be opened
def catch_exceptions_IsADirectoryError() -> None:
    try:
        # get the path of the current working directory
        cwd = os.getcwd()
        print(cwd)
        # return a list of files and directories in the current working directory
        dir_list = os.listdir(cwd)
        print(dir_list)

        fin = open('unit8')
    except IsADirectoryError:
        print('💥💥 Please make sure you open a file NOT directory.')
    fin.close()


'''
Output:
/Users/kento/Documents/github/UoPeople/programming-fundamentals
['unit2', 'unit5', 'unit4', 'unit3', 'unit6', 'unit8', 'unit7', '.git']
💥💥 Please make sure you open a file NOT directory.
'''


# test the exception if trying to write the file which is not writable
def catch_exceptions_Exception() -> None:
    try:
        # get the path of the current working directory
        cwd = os.getcwd()
        print(cwd)
        # return a list of files and directories in the current working directory
        dir_list = os.listdir(cwd)
        print(dir_list)

        fin = open('test.txt')
        fin.write('Lorem ipsum dolor sit amet, consectetur adipiscing elit.')
        fin.close()
    except Exception as err:
        print(f'💥💥💥 Error: {err}')


'''
Output:
/Users/kento/Documents/github/UoPeople/programming-fundamentals/unit8
['journal.py', 'test.txt', 'discussion.py']
💥💥💥 Error: not writable
'''


def main():
    catch_exceptions_IOError()
    catch_exceptions_IsADirectoryError()
    catch_exceptions_Exception()


# call all function in this file
main()


'''
In a large project, I would handle each error with try and except statement.
The try block will run first, and if something is wrong in the try block, the try block stops and the exception block starts running.
In addition, I also use "Exception as err" in the exception header.
This is useful because I can check what kind of an error I get while debugging.
'''


'''
References
Downey, A. (2015).Think Python: How to think like a computer scientist. Needham,Massachusetts: Green Tree Press.
'''
