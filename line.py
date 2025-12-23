def lexi(T, cases):
    results = []
    
    for case in cases:
        N, a = case
        max_index = 0
        
        for i in range(1, N):
            if a[i] > a[max_index]:
                max_index = i
        
        
        if max_index > 0:
            a = a[:max_index] + a[max_index+1:] 
            a.insert(0, a[max_index]) 

    
        results.append(" ".join(map(str, a)))
    
    return results



T = int(input().strip())
cases = []

for _ in range(T):
    N = int(input().strip())
    a = list(map(int, input().split()))
    cases.append((N, a))

for result in lexi(T, cases):
    print(result)