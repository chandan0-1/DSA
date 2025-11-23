class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0

        for i in range(len(nums)):
            count += self.subarraySumHelper(nums, k, i, 0)
        return count

    def subarraySumHelper(self, nums, k, si, count):
        if si == len(nums) - 1 and nums[si] == k:
            return count + 1

        if si >= len(nums):
            return count

        if nums[si] == k:
            count += 1
        return self.subarraySumHelper(nums, k - nums[si], si + 1, count)
        
 
