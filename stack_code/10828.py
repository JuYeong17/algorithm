import sys
N=int(sys.stdin.readline())

stack=[]

def push(a):
    stack.append(a)

def pop():
    if stack:
        print(stack.pop())
    else:
        print(-1)

def size():
    print(len(stack))

def empty():
    if not stack:
        print(1)
    else:
        print(0)

def top():
    if stack:
        print(stack[-1])
    else:
        print(-1)

for i in range(N):
    arr=sys.stdin.readline().split()

    if arr[0]=='push':
        push(arr[1])
    elif arr[0] =='pop':
        pop()
    elif arr[0]=='size':
        size()
    elif arr[0]=='empty':
        empty()
    elif arr[0]=='top':
        top()



    


