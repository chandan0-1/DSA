def KDistance(root,k):
    '''
    :param root: root of given tree.
    :param k: distance k from root
    :return: Print all nodes that are at distance k from root, no need to print next line.
    '''
    # code here
    if root is None:
        return []
    ans = []    
    if k == 0:
        ans.append(root.data)
        # print(root.data, end=" ")
    l = KDistance(root.left, k-1)
    for i in l:
        ans.append(i)
    r = KDistance(root.right, k-1)
    for j in r:
        ans.append(j)
    return ans
