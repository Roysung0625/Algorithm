
numOfInput = int(input())
inputSerial = []
for i in range(numOfInput):
    inputSerial.append(input())
# print(inputSerial)

inputSerial.sort(key=lambda x : len(x))
arrangeByLength = dict()
for i in inputSerial:
    arrangeByLength.setdefault(len(i), []).append(i)

# print(arrangeByLength)

result = []
for k in arrangeByLength.keys():
    # print(arrangeByLength[k])
    arrangeByLength[k].sort()
    arrangeByLength[k].sort(key=lambda x: sum([int(y) for y in x if not ('A' <= y <= 'Z')]))
    for i in arrangeByLength[k]:
        result.append(i)

print(*result)