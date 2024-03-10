# Heterogenous keys and values
mixedDict = {"a":1, "b":"2"}

findKey="2"

for e in mixedDict.values():
    print(e)

mixedDict["z"] = 100

if ("a" in mixedDict):
    print("Found 'a' in mixedDict")


if ("z" not in mixedDict):
    print("Found 'z' in mixedDict")
    print("> %s" % mixedDict["z"])

d = {1:"1",2:"2",3:"300"}
for k,v in d.items():
        print(k,'', v)