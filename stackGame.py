#!/bin/python3

import os
import sys

def twoStacks(x, a, b):
    # Write your code here.
    a_len = len(a)
    b_len = len(b)
    
    a.reverse()
    b.reverse()
    # print(a)
    # print(b)
    
    summ = 0
    count = 0
    
    a_flag = True
    b_flag = True    
   
    while summ<x:
        if len(a) !=0 and len(b) !=0:
            a_data = a[-1]
            b_data = b[-1]
        
            req_sum = x-summ

            if a_data <= b_data and a_data <= req_sum:
                #print("a is used")
                count +=1
                summ += a_data
                a.pop()
            elif b_data < a_data and b_data <= req_sum:
                #print("b is used")
                count +=1
                summ += b_data
                b.pop()
            else:
                break
        else:
            req_sum = x-summ
            if len(a) ==0: #a has become empty
                count +=1
                summ += b_data
                b.pop()
            elif len(b) ==0: #b has become empty
                count +=1
                summ += a_data
                a.pop()
            
    #print(a)
    #print(b)
    return count


if __name__ == '__main__':
    g = int(input())

    for g_itr in range(g):
        nmx = input().split()

        n = int(nmx[0])

        m = int(nmx[1])

        x = int(nmx[2])

        a = list(map(int, input().rstrip().split()))

        b = list(map(int, input().rstrip().split()))

        result = twoStacks(x, a, b)

        print(result)
