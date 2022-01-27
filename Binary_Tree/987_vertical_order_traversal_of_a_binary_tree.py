class Solution:
    def helper(self, root, d, dist, lv): # dist-horizontal, lv = vertical level
        if not root:
            return
        
        if dist in d:
            d[dist].append([lv, root.val])
        else:
            d[dist] = [[lv, root.val]]
            
        self.helper(root.left, d, dist-1, lv+1)
        self.helper(root.right, d, dist+1, lv+1)
        
        
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        
        map_ = {}
        self.helper(root, map_, 0, 0)
        ans = []
        for i in sorted(map_.keys()):
            temp = []
            for j in sorted(map_[i]):
                temp.append(j[1])
            ans.append(temp)
        return ans
