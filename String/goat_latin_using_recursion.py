class Solution:
    def helper(self, l, c, d):
        if len(l) == 0:
            return ""
        s = ''
        i = l.pop()
        if i[0].lower() in d:
            s += i
        else:
            s += i[1:]
            s += i[0]
        s += "ma"
        s += "a"*c
        return self.helper(l,c-1,d) + s + " "
    
    def toGoatLatin(self, sentence: str) -> str:
        map_ = "aeiou"
        lis = sentence.split(" ")
        return self.helper(lis, len(lis), map_)[:-1]

