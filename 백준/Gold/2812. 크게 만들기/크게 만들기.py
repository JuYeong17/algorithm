n, k=map(int, input().split())
number=list(input())

count=k
answer=[]

for num in number:
    while answer and answer[-1] < num and count>0:
        del answer[-1]
        count -= 1
    answer.append(num)

print(''.join(answer[:n-k]))
    