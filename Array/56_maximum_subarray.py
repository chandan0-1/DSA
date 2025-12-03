class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        ans = nums[0]
        cur_sum = nums[0]

        for i in range(1, len(nums)):
            cur_sum = max(nums[i], cur_sum + nums[i])
            ans = max(cur_sum, ans)
        
        return ans


    def maxSubArray2(self, nums: List[int]) -> int:
        ans = float(-inf)
        cur_sum = 0

        for num in nums:
            if cur_sum < 0:
                cur_sum = 0
            
            cur_sum += num
            ans = max(ans, cur_sum)
        
        return ans
        
