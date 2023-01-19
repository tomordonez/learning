def multiply(num, x=1):
    result = 1
    for i in range(x):
        result *= num
    return result


print(multiply(2, 4))
print(multiply(2))

