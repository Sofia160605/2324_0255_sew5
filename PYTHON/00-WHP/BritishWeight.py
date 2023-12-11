class BritishWeight:

    """
    >>> b1 = BritishWeight(16, 2)
    >>> print(b1)
    44 lb = 3 st 2 lb
    >>> b2 = BritishWeight(12, 6)
    >>> print(b1 + b2)
    140 lb = 10 st 0 lb
    >>> print(b1 + BritishWeight(20))
    64 lb = 4 st 8 lb
    """

    _pounds: int

    def __init__(self, pounds=1, stones=0):
        '''
        creates new BritishWeight object
        :param pounds: pounds
        :param stones: stones (= 14 lb)
        '''
        p = stones * 14 + pounds
        self._pounds = p

    @property
    def pounds(self):
        return self._pounds

    def __str__(self):
        '''
        toString methode
        :return: formatted output
        '''
        stones = self._pounds//14
        return str(self.pounds) + " lb = " + str(stones) + " st " + str(self.pounds%14) + " lb"

    def __add__(self, other):
        '''
        adds two BritishWeight objects
        :param other: BritishWeight that gets added to self
        :return: sum of self and other
        '''
        if isinstance(other, BritishWeight):
            return BritishWeight(self.pounds+other.pounds)