print("OOP_Animal")

class Animal:
    def __init__(self,name):
        self.name = name
        print("Init "+ name)

    def makeNose(self):
        print("makeNose "+self.name)


a = Animal("Bello")
a.makeNose()


def makeNose(sound):
    print(sound)

makeNose("bark")

