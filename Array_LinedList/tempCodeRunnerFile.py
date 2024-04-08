N,K=map(int, input().split())
a =[i for i in range(1,N+1)]

result=[]
count=0

for i in range(N):
    count +=K-1
    if count >= len(a):
        count=count%len(a)

    result.append(str(a.pop(count)))
print("<",", ".join(result),">", sep= '')