class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        ans = []
        merged_interval = intervals[0]

        for num in intervals:
            if num[0] <= merged_interval[1]:
                if merged_interval[1] < num[1]:
                    merged_interval[1] = num[1]
                continue
            
            ans.append(merged_interval)
            merged_interval = num

        ans.append(merged_interval)
        return ans
