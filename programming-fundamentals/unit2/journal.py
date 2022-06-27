'''
PART1
'''


# print volume of sphere
def print_volume(r):
    pi = 3.141592653589793
    print(4 / 3 * pi * r ** 3)


# call functions
print_volume(10)
print_volume(37)
print_volume(100)


'''
OUTPUT:
4188.790204786391
212174.79024304505
4188790.2047863905
'''

'''
PART2
'''


'''
calculate and print total cost including sales tax

parameters
----------
amount: int
    cost before tax
tax_rate: float
    tax rate (unit is %)
returns: None
----------
'''


def calc_sales_tax(amount, tax_rate):
    # amount of tax
    tax_amount = amount * tax_rate / 100
    print('Total: ', amount + tax_amount)


# call functions
calc_sales_tax(100, 7.25)
calc_sales_tax(100, 10.0)
calc_sales_tax(100, 25.0)


'''
OUTPUT:
Total:  107.25
Total:  110.0
Total:  125.0
'''

print()
