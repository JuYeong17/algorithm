N =list(map(str, input()))

count = 0
while len(N):
    print(N[count], end ="")
    count += 1
    if count % 10 == 0:
        print()
    if count == len(N):
        break