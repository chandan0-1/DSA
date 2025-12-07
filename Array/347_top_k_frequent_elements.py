class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        _map = {}
        ans = []
        heap = []

        for num in nums:
            _map[num] = _map.get(num, 0) + 1

        for key, val in _map.items():
            if len(heap) < k:
                heapq.heappush(heap, (val, key))

            else:
                # heapq.heappushpop(heap, (val, key)) 
                        #   OR 
                count, _num = heap[0]
                if val > count:
                    heapq.heappushpop(heap, (val, key))

        _map.clear()

        return [num for _count, num in heap]
        
            
        
