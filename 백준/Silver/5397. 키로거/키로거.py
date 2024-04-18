N=int(input())

for _ in range(N):
    K=input()
    l_stack=[]
    r_stack=[]
    for i in K:
        if i =='-':
            if r_stack:
                r_stack.pop()
        elif i=='<':
            if r_stack:
                l_stack.append(r_stack.pop())
        elif i =='>':
            if l_stack:
                r_stack.append(l_stack.pop())
        else:
            r_stack.append(i)
    r_stack.extend(reversed(l_stack))

    print(''.join(r_stack))

