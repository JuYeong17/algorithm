n = int(input())

lines = list(map(int,input().split()))

lines.sort()

first = 0
result = 0
b =[]

for line in lines:
    first += line
    b.append(first)

for bs in b:
    result += bs

print(result)