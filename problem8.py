from fractions import gcd

def answer(vertices):
    a,b,c = vertices[0], vertices[1], vertices[2]
    area = .5*abs((a[0]-c[0])*(b[1]-a[1])-(a[0]-b[0])*(c[1]-a[1]))
    bp = gcd(abs(a[0]-b[0]),abs(a[1]-b[1]))+gcd(abs(b[0]-c[0]),abs(b[1]-c[1]))+gcd(abs(c[0]-a[0]),abs(c[1]-a[1]))
    i = area - bp/2 + 1
    return int(i)

print(answer([[91207,89566],[-88690,-83026],[67100,47194]]))
print(answer([[2, 3], [6, 9], [10, 160]]))
