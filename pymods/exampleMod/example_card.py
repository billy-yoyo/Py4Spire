from com.billyoyo.cardcrawl.py.interfaces import PyCard

class ExampleCard(PyCard):
    def __init__(self):
        pass

    def getId(self):
        return "Example Card"

    def getName(self):
        return "Example Name"

    def getCost(self):
        return 1

    def getDescription(self):
        return "An example card"

    def getCardType(self):
        return "ATTACK"

    def getColor(self):
        return "RED"

    def getTarget(self):
        return "ENEMY"

    def getRarity(self):
        return "BASIC"

    def getImage(self):
        return "/images/wumpus.png"

    def registered(self):
        if self.impl.isLocked:
            self.impl.unlock()

    def upgrade(self):
        pass

    def use(self, player, monster):
        player.gainEnergy(2)