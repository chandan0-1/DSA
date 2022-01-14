class Solution:
    # def helper(self, s):
    #     if len(s) == 0:
    #         return ""
    #     if s[0].isalnum():
    #         return self.helper(s[1:]) + s[0].lower()
    #     else:
    #         return self.helper(s[1:])
    def isPalindrome(self, s: str) -> bool:
        s = list(s)
        i = 0
        j = len(s)-1
        while i <= j:
            if not s[i].isalnum():
                i += 1
                continue
            if not s[j].isalnum():
                j -= 1
                continue
            if s[i].lower() != s[j].lower():
                return False
            i += 1
            j -= 1
        return True
