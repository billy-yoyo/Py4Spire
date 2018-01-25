
from com.billyoyo.cardcrawl.py.interfaces import PyRelic

class ExampleRelic(PyRelic):
    def __init__(self):
        pass
        
    def getId(self):
        return "Example Relic"

    def getImage(self):
        return "anchor.png"

    def getRelicTier(self):
        return "RARE"

    def getLandingSound(self):
        return "CLINK"

    def getDescription(self):
        return "An example relic"

    def getName(self):
        return "Example Relic"

    def getFlavorText(self):
        return "An Example"

    def getUsedUpText(self):
        return "Not sure what this is"

    def getRelicColor(self):
        return "NONE"