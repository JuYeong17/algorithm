N=input()
stack=[]
result=0

for i in range(len(N)):
    if N[i]=='(':
        stack.append(N[i])
    else:
        if N[i-1]=='(':
            stack.pop()
            result += len(stack)
        else:
            stack.pop()
            result += 1
print(result)

