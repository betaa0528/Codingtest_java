class Queue:
    def __init__(self, mx=100001):
        self.dat = [0] * mx
        self.head = 0
        self.tail = 0

    def push(self, num):
        self.dat[self.tail] = num
        self.tail += 1

    def pop(self):
        if self.head == self.tail: return -1
        self.head += 1
        return self.dat[self.head - 1]

    def isEmpty(self):
        return self.tail - self.head == 0

    def size(self):
        return self.tail - self.head

    def front(self):
        if self.head == self.tail: return -1
        return self.dat[self.head]

    def rear(self):
        if self.head == self.tail: return -1
        return self.dat[self.tail - 1]


N = int(input())
queue = Queue()
for i in range(N):
    cmd = input().strip()
    if 'push' in cmd:
        num = int(list(map(str, cmd.split(' ')))[1])
        queue.push(num)
    elif cmd in 'front':
        print(queue.front())
    elif cmd in 'back':
        print(queue.rear())
    elif cmd in 'size':
        print(queue.size())
    elif cmd in 'pop':
        print(queue.pop())
    else:
        print(1 if queue.isEmpty() else 0)