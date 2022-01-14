class Solution:
    def toGoatLatin(self, sentence: str) -> str:
        map_ = "aeiou"
        lis = sentence.split(" ")
        ans = ""
        count = 1
        for i in lis:
            s = ""
            if i[0].lower() in map_:
                s += i
            else:
                s += i[1:]
                s += i[0]
            s += "ma"
            s += "a"*count
            ans += s + " "
            count += 1     
        return ans[:-1]
