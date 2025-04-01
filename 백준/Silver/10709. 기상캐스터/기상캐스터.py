def caster(a,b,graph):
    count = 0
    for i in range(H):
        cloud_seen = False
        for j in range(W):
            if graph[i][j] == "c":
                cloud_seen = True
                graph[i][j] = 0
                count = 0
            else:
                if cloud_seen == True:
                    count += 1
                    graph[i][j] = count
                else:
                    count = -1
                    graph[i][j] = count
    return graph

H, W = map(int, input().split())

graph = []
for i in range(H):
    graph.append(list(input()))

result = caster(H,W,graph)

for row in result:
    print(' '.join(map(str, row)))