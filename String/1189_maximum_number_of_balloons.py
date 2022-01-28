class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        d = {}
        for i in text:
            d[i] =  d.get(i,0)+1
            
        s = "balon"
        ans = sys.maxsize
        for i in s:
            count = d.get(i)
            if not count:
                return 0
            if i == "l" or i == "o":
                count = count // 2
            ans = min(ans, count)
        return ans
        
