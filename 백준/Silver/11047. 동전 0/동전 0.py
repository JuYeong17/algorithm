n, k = list(map(int, input().split()))
moneys=[]
for i in range(n):
    moneys.append(int(input()))
count =0

list =[]
while True:
    for money in moneys:
        if k // money != 0:
            list.append(money)
    list.sort(reverse=True)
    count += (k // list[0])
    k = k % list[0]

    list = []
    if k == 0:
        break

print(count)

