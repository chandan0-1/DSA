# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.maxDiameter = 0

    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        # _h, diameter = self.diameterOfBinaryTreeHelper(root)
        # return diameter

        # 2nd Method
        self.diameterOfBinaryTreeHelper1(root)
        return self.maxDiameter

    # Second Method
    def diameterOfBinaryTreeHelper1(self, root) -> int:
        if not root:
            return 0

        leftHeight = self.diameterOfBinaryTreeHelper1(root.left)
        rightHeight = self.diameterOfBinaryTreeHelper1(root.right)   

        currentNodeDiameter = leftHeight + rightHeight
        self.maxDiameter = max(self.maxDiameter, currentNodeDiameter)

        return 1 + max(leftHeight, rightHeight)

    # First Method
    def diameterOfBinaryTreeHelper(self, root) -> int :
        if not root:
            return 0, 0

        leftHeight, leftDiameter = self.diameterOfBinaryTreeHelper(root.left)
        rightHeight, rightDiameter = self.diameterOfBinaryTreeHelper(root.right)

        # Current node dia including left + right height
        currentNodeDiameter = leftHeight + rightHeight
        maxDiameter = max(currentNodeDiameter, leftDiameter, rightDiameter)

        height = 1 + max(leftHeight, rightHeight)
        return height, maxDiameter
