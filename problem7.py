cache = {}
def ri(n):
    if n not in cache.keys():
        cache[n] = _r(n)
    return cache[n]

def _r(n):
    if n == 0 or n == 1:
        return 1
    if n == 2:
        return 2

    num = n / 2
    num = int(num)
    if n % 2 == 1:
        return ri(num-1) + ri(num) + 1
    return ri(num) + ri(num+1) + num

def searchOdd(r):
    p1 = 0
    p2 = int(r / 2 + 1)
    while (p1 <= p2):
        mid = int((p1+p2)/2)
        Rmid = ri(2*mid+1)
        if Rmid == r:
            return str(int(2*mid+1))
        elif Rmid < r:
            p1 = mid+1
        else:
            p2 = mid-1
    return "None"

def searchEven(r):
    p1 = 0
    p2 = int(r / 2 + 1)
    while (p1 <= p2):
        mid = int((p1+p2)/2)
        Rmid = ri(2*mid)
        if Rmid == r:
            return str(int(2*mid))
        elif Rmid < r:
            p1 = mid+1
        else:
            p2 = mid-1
    return "None"

def answer(str_S):
    r = int(str_S)
    retOdd = searchOdd(r)
    if retOdd != "None":
        return retOdd
    else:
        return searchEven(r)

print(answer(1000000000000000000))
