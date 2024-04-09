import sys
N=int(sys.stdin.readline())

stack=[]

def push(a):
    stack.append(a)

def pop():
    print(stack.pop)
    if not stack:
        print(-1)

def size():
    print(len(stack))

def empty():
    if not stack:
        print(1)
    if stack:
        print(0)

def top():
    print(stack[-1])

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


