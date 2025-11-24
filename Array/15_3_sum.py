class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        
        output = []
        n = len(nums)
        
        for i, num in enumerate(nums):
            # Skip for duplicates of i
            if i > 0 and nums[i - 1] == num:
                continue

            j = i + 1
            k = n - 1

            while j < k:
                total = num + nums[j] + nums[k]

                if total < 0:
                    j += 1
                elif total > 0:
                    k -= 1
                else:
                    output.append([num, nums[j], nums[k]])
                    k -= 1

                    # Skip for duplicates of k
                    while k > j and nums[k] == nums[k + 1]:
                        k -= 1

                    # Skip for duplicates of j (optional)
                    while j < k and nums[j] == nums[j + 1]:
                        j += 1
            
        return output
        
