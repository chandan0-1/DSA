class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return 0

        ansCount = 0
        n = len(nums)
        nums.sort()

        for i in range(2, n):
            j = 0
            k = i - 1

            while j < k:
                if nums[j] + nums[k] > nums[i]:
                    ansCount +=  k - j
                    k -= 1
                else:
                    j += 1
        return ansCount
