if __name__ == '__main__':
    marksheet = []
    marks = []

    for _ in range(int(input())):
        name = input()
        score = float(input())
        marksheet.append([name, score])
        marks.append(score)    
        
    marks.sort()
    marksheet.sort()
    min = marks[0]
    min_count = marks.count(min)
    
    for _ in range(min_count):
        marks.remove(min)
        
    req = marks[0]

    for i in range(len(marksheet)):
        if marksheet[i][1] == req:
            print(marksheet[i][0])
    
    # print(marksheet)
    # print(marks)