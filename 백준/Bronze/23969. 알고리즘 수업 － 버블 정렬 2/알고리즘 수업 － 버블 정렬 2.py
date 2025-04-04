import sys

inputSize, inputCount = map(int, sys.stdin.readline().split(" "))
inputList = list(map(int, sys.stdin.readline().split()))

count = 0
for i in range(0, inputSize):
    for j in range(0, inputSize - i - 1):
        if inputList[j] > inputList[j+1]:
            inputList[j], inputList[j+1] = inputList[j+1], inputList[j]
            count += 1
            if count == inputCount:
                print(*inputList)
                break
    if count == inputCount:
        break

if count < inputCount:
    print(-1)