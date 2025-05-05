def addNumber():
    A, B = map(int,input().split())
    print(A + B)

while True:
    try:
        addNumber()
    except:
        break