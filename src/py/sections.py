import string
import sys

# input = open('1.txt', 'r') //расскомментировать решая задачу локально
input = sys.stdin
sections = []
n = int(input.readline())
rights = []
for i in range(1, n + 1):
    x, y = map(int, input.readline().split())
    sections.append([x, y])


def getKey(item):
    return item[1]


sections.sort(key=getKey)

for i in range(0, len(sections)):
    right = sections[i][0]
    for j in range(0, len(sections)):
        if i != j:
            if right in range(sections[j][0], sections[j][1]):
                rights.append(right)
                sections.pop(j)

print(rights.__sizeof__())

