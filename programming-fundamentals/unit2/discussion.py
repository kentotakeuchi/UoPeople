# Example 1: Define a function that takes an argument. Call the function. Identify what code is the argument and what code is the parameter.
def my_func(my_parameter):
    print(my_parameter)


my_func('This is an argument')
'''
Explanation
Argument is a value provided to a function when the function is called (Downey, 2015, P.26). In the above example, 'This is an argument' is an argument.
Parameter is a name used inside a function to refer to the value passed as an argument (Downey, 2015, P.26).
'''

# Example 2: Call your function from Example 1 three times with different kinds of arguments: a value, a variable, and an expression. Identify which kind of argument is which.
my_variable = 'This is a value'
my_func(10)
my_func(my_variable)
my_func(10 * 10)
'''
Explanation
The argument of the first called function is a value.
The argument of the second called function is a variable.
The argument of the third called function is an expression.
'''

# Example 3: Create a function with a local variable. Show what happens when you try to use that variable outside the function. Explain the results.


def my_func2():
    local_variable = 100


# print(local_variable)
'''
Output
print(local_variable)
NameError: name 'local_variable' is not defined
Explanation
'local_variable' is a local value in 'my_func2' function. The value can only be used inside the function. That is why the error message shows "name 'local_variable' is not defined" because I used the local variable outside the function.
'''

# Example 4: Create a function that takes an argument. Give the function parameter a unique name. Show what happens when you try to use that parameter name outside the function. Explain the results.


def my_func3(my_parameter3):
    pass


# print(my_parameter3)
'''
Output
print(my_parameter3)
NameError: name 'my_parameter3' is not defined
Explanation
'my_parameter3' is a parameter in 'my_func3' function. A parameter can only be used inside the function. That is why the error message shows "name 'my_parameter3' is not defined" because I used the parameter outside the function.
'''

# Example 5: Show what happens when a variable defined outside a function has the same name as a local variable inside a function. Explain what happens to the value of each variable as the program runs.
my_variable2 = 'Defined OUTSIDE a function'


def my_func4():
    my_variable2 = 'Defined INSIDE a function'
    print(my_variable2)


my_func4()
print(my_variable2)
'''
Output
Defined INSIDE a function
Defined OUTSIDE a function
Explanation
Firstly, 'my_variable2' is defined in global scope. 'my_func4' is called and 'my_variable2' is defined in local scope. It means that 'my_variable2' is defined as a local variable even if there is the same name of a variable in global scope. That is why the output shows "Defined INSIDE a function" in 'my_func4'. However, if I use 'my_variable2' in global scope again, the output shows "Defined OUTSIDE a function" because 'my_variable2' is used in global scope and the definition in local scope does not affect the definition of global scope.
'''

'''
References

Downey, A. (2015). Think Python: How to think like a computer scientist. Green Tea Press. This book is licensed under Creative Commons Attribution-NonCommercial 3.0 Unported (CC BY-NC 3.0).
https://my.uopeople.edu/pluginfile.php/1587167/mod_book/chapter/347195/TEXT%20-%20Think%20Python%202e.pdf
'''
