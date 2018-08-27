#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the solve function below.
def solve(s):
    list = s.strip().split();
    
    list2= []
    for i in list:
        temp = i[0]
        if temp.islower():
            temp = temp.upper()
        
        temp = temp + i[1:]
        s = s.replace(i, temp, 1)
        
    return s


if __name__ == '__main__':
	#fptr = open(os.environ['OUTPUT_PATH'], 'w')

	s = input()

	result = solve(s)
	print(result)

	#fptr.write(result + '\n')

	#fptr.close()
