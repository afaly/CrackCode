package hard;

public class BenderAlgorithmicComplexity {

	// Solved Pyhton.

	/*-
	import sys
	import math

	def scale(l):
	    v_len, v_min, v_max = len(l), min(l), max(l) - min(l)
	    return map(lambda x: v_len*(x-v_min)/v_max if v_max != 0 else 0, l)


	def remove(r, l):
	    return map(lambda x: x[0] - x[1], zip(r, l))
	    
	    
	def analyze(l):
	    v_avg = sum(l)/len(l)
	    return math.sqrt(sum(map(lambda x: (x - v_avg)**2, l))/(len(l) - 1))

	N = int(raw_input())
	size, time = [], []
	for i in xrange(N):
	    s, t = (int(x) for x in raw_input().split())
	    size.append(s)
	    time.append(t)

	ss          = scale(time)
	v1          = analyze(remove(ss, scale(map(lambda x: x, [1 for i in xrange(N)]))))
	vn          = analyze(remove(ss, scale(map(lambda x: x, size))))
	vlogn       = analyze(remove(ss, scale(map(lambda x: math.log(x), size))))
	vnlogn      = analyze(remove(ss, scale(map(lambda x: x*math.log(x), size))))
	vn2         = analyze(remove(ss, scale(map(lambda x: x**2, size))))
	vn2logn     = analyze(remove(ss, scale(map(lambda x: x*x*math.log(x), size))))
	vn3         = analyze(remove(ss, scale(map(lambda x: x**3, size))))
	ve          = analyze(remove(ss, scale(map(lambda x: 2**x, size))))


	ops = [v1, vlogn, vn, vnlogn, vn2, vn2logn, vn3, ve]
	cod = ["O(1)", "O(log n)", "O(n)", "O(n log n)", "O(n^2)", "O(n^2 log n)", "O(n^3)", "O(2^n)"]

	V_MIN, V_IDX = float("INF"), -1
	for i, v in enumerate(ops):
	    if v < V_MIN:
	        V_MIN, V_IDX = v, i

	print cod[V_IDX]
	
	 */
}
