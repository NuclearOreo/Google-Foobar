
from __future__ import division
def answer(minions):
    num_minons = len(minions)
    assert 2 <= len(minions) <= 50
    sortkey = [t/(n/d) for t, n, d in minions]
    return sorted(range(num_minons), key = sortkey.__getitem__)
