numOfNode, numOfEdge = map(int, input().split(" "))
edge = [[] for i in range(numOfNode + 1)]
for i in range(numOfEdge):
    eFrom, eTo = map(int, input().split(" "))
    edge[eFrom].append(eTo)

relation = [0 for i in range(numOfNode + 1)]
queue = []

mark = 0
# print(":------------------")
for i in range(1, numOfNode + 1):
    if relation[i] != 0:
        continue
    mark += 1
    queue.append(i)
    relation[i] = mark

    while queue:
        now = queue.pop()
        for to in edge[now]:
            if relation[to] == 0 and now in edge[to]:
                relation[to] = mark
                queue.append(to)

# print(edge)
# print(relation)

print(len(set(relation)) - 1)


