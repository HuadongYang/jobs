def perimeter(a,  b,  c):
    return a + b + c
def osum():
    sum = 0
    for i in range(0, 100, 2):
        sum = sum + i
    return sum;
def factorial(num):
    result = 1
    for i in range(1, num+1):
        result = result*i
    return result;
def score(score):
    if score >= 90:
        return 'A'
    if score >=70 and score <= 89:
        return 'B'
    if score >= 60 and score <= 69:
        return 'c'
    if score <60:
        return 'd'
def even():
    arr = [22,33,44,55,67,88,99,65,97,77]
    count = 0
    for i in arr :
        if i%2 == 0:
            count = count + 1
    return count;
if __name__ == '__main__':
    print(perimeter(1,2,3))
    print(osum())
    print(factorial(4))
    print (score(23))
    print (even())
