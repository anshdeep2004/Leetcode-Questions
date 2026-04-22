class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        n = len(queries[0])
        ans = []

        for q in queries:
            for d in dictionary:
                un_match = 0
                for i in range(0, n):
                    if q[i] != d[i]:
                        un_match += 1
                    
                if (un_match <= 2):
                    ans.append(q)
                    break
        
        return ans
