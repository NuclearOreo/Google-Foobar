count = 0
def answer(t, n):
    if t == 1 and n == 2:
        return 1

    if t == 0:
        return 0

    bf(t,n,0,0)
    return count % 123454321

def bf(t, n, pos, thr):
    global count
    if thr == t and pos == n:
        count += 1
        return

    if thr == t or thr > t:
        return

    if pos > n or pos < 0:
        return

    if pos - n > thr:
        return

    bf(t,n,pos+1,thr+1)
    bf(t,n,pos-1,thr+1)
    bf(t,n,pos,thr+1)

def answer(t, n):
    acc = [0] * (n + 1)

    acc[1] = 1

    for k in range(t):

        tmp = [0] * (n + 1)
        tmp[n] = acc[n]

        for pos in range(max(1, n - t + k), n):

            for move in (-1, 0, 1):
                tmp[pos + move] += acc[pos]

        acc = tmp
    return acc[n]

print(answer(30,10))
