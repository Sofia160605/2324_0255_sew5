class BritishWeight:

    _pounds: int

    def __init__(self, pounds=1, stones=0):
        p = stones * 14 + pounds
        self._pounds = p

    @property
    def pounds(self):
        return self._pounds

    def __str__(self):
        stones = self._pounds//14
        return str(self.pounds) + " lb = " + str(stones) + " st " + str(self.pounds%14) + " lb"

    def __add__(self, other):
        if isinstance(other, BritishWeight):
            return BritishWeight(self.pounds+other.pounds)


