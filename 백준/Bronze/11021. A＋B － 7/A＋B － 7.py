
def addNumber():
    A, B = map(int,input().split())
    return A + B

T = int(input())

for i in range(T):
    print("Case #%d:" %(i+1) , addNumber())
