mixedList = [1,"hallllllo","mixed",2]

search = "l"

cnt = 0

for e in mixedList:
    txt = str(e)
    for c in range(0, len(txt)):
        print(txt[c])
        if(txt[c] == search):
            cnt += 1

print("> %s" % cnt)


mixedList.append("a")

for x in mixedList:
    if(x=="a"):
        print("Found %s" % x)
        break