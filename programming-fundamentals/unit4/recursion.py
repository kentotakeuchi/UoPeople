# check if x is divisible by y or not
def is_divisible(x, y):
    return x % y == 0


# check if int1 is power of int2
# arguments must be positive integers
def is_power(int1, int2):
    # if int1 cannot be divided by int2, int1 is not power of int2
    if not is_divisible(int1, int2):
        return False
    # base case 1
    elif int1 == int2:
        return True
    # base case 2
    elif int2 == 1:
        return False
    else:
        # print(f'is_power({int(int1/int2)}, {int2})')
        return is_power(int(int1/int2), int2)


# test case
print("is_power(10, 2) returns: ", is_power(10, 2))
print("is_power(27, 3) returns: ", is_power(27, 3))
print("is_power(1, 1) returns: ", is_power(1, 1))
print("is_power(10, 1) returns: ", is_power(10, 1))
print("is_power(3, 3) returns: ", is_power(3, 3))
