package hard;

public class GenomeSequencing {
	// Solved Python:

	/*-
	import sys
	import math
	from sets import Set
	def getSet(f , i):
	    t = set()
	    for idx, val in enumerate(f): 
	        if val == i: t.add(idx)
	    cur = 0
	    while(len(t) > cur):
	        cur = len(t)
	        s = set()
	        for idx, val in enumerate(f):
	            if val in t: s.add(idx)
	        t = t | s
	    return t
	        
	def dfs(v, i, f):
	    if i == N: return 0
	    maxMiss = 0
	    t = getSet(f, i)
	    for k in xrange(N):
	        if k not in t:
	            f[i] = k
	            maxMiss = max(maxMiss, v[i][k] + dfs(v, i + 1, f))
	    return maxMiss
	    

	N = int(raw_input())
	S = []
	totLen = 0
	for i in xrange(N):
	    S.append(raw_input())
	    totLen += len(S[i])
	    
	V = []
	for i in xrange(N):
	    V.append([]);
	    for j in xrange(N):
	        V[i].append(0)
	        if i != j:
	            for a in xrange(len(S[j])):
	                cnt = 0
	                valid = True
	                for b in xrange(len(S[i])):
	                    if a+b < len(S[j]) and S[j][a+b] == S[i][b]:
	                        cnt+=1
	                    else:
	                        valid = a+b == len(S[j])
	                        break
	                if valid : V[i][j] = max(V[i][j], cnt)
	                
	miss = [max(v) for v in V]
	sumMiss = sum(miss)
	difMiss = [sumMiss - x for x in miss]
	maxMiss = dfs(V, 0, [-1 for i in xrange(N)])

	# print miss, sumMiss
	# print maxMiss
	# print V
	print totLen - maxMiss
	 */
}
