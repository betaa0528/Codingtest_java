a = []
for test_case in range(5):
    a.append(int(input()))

for i in range(4):
    for j in range(5):
        if a[j]>a[i+1]:
            temp = a[i+1]
            a[i+1] = a[j]
            a[j] = temp

print(sum(a)//5)
print(a[2])