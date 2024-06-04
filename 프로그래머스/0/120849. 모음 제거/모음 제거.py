def solution(my_string):
    alphabet = ['a','e','i','o','u']
    for i in alphabet:
        my_string = my_string.replace(i, '')
    return my_string