N=[list(map(int, input().split())) for _ in range(5)]
max=0
for i in range(5):
    sum=0
    for j in range(4):
        sum+=N[i][j]
    if(max<sum):
        max=sum
        win=i+1
    


print(win,max)        