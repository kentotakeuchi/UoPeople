# print 9 lines with dot
def nine_lines():
    print('Printing nine lines')  # placeholder
    three_lines()
    three_lines()
    three_lines()


# print 25 lines with dot
def clear_screen():
    print('Calling clearScreen()')  # placeholder
    nine_lines()
    nine_lines()
    three_lines()
    three_lines()
    new_line()


# print 1 line with dot
def new_line():
    print('.')


# print 3 lines with dot
def three_lines():
    new_line()
    new_line()
    new_line()


# call functions
nine_lines()
clear_screen()


'''
OUTPUT:
Printing nine lines
.
.
.
.
.
.
.
.
.
Calling clearScreen()
Printing nine lines
.
.
.
.
.
.
.
.
.
Printing nine lines
.
.
.
.
.
.
.
.
.
.
.
.
.
.
.
.
'''
