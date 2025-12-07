import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []

        for num in nums:
            heapq.heappush(heap, -num)

        while True:
            data = -heapq.heappop(heap)
            k -= 1
            if k == 0:
                return data

    # Optimized 
    def findKthLargest2(self, nums: List[int], k: int) -> int:
        heap = []

        for num in nums:
            if len(heap) < k:
                heapq.heappush(heap, num)

            elif heap[0] < num:
                heapq.heappushpop(heap, num)

        return heap[0]
