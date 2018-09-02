import math
import os
import random
import re
import sys

# Complete the isBalanced function below.
def isBalanced(s):
    mid = int(len(s)/2)
    length = int(len(s))
    
    open_brac = "[{("
    close_brac = "]})"
    
    stack = []
    str = "YES"
    for i in range(length):         
        brac_val = s[i]
        
        if brac_val in open_brac:
            stack.append(brac_val)
        elif brac_val in close_brac:
            if len(stack) != 0:                
                data = stack.pop()
                #print(data)
                if data == "[":
                    data = "]"
                elif data == "{":
                    data = "}"
                elif data == "(":
                    data = ")"
                #print(data)
                if brac_val !=data:
                    str = "NO"
                    break
            else:
                str = "NO"
                break
    
    if len(stack) != 0:                
        str = "NO"
    return str


if __name__ == '__main__':    
    t = int(input())

    for t_itr in range(t):
        s = input()
        result = isBalanced(s)
        print(result)
