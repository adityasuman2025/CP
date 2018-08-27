import numpy

n,m = input().split()
n = int(n)
m = int(m)

matrix = numpy.array([[1.0 if i == j else 0.0 for i in range(n)] for j in range(m)], float)

print(matrix)