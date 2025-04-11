class Node:
    def __init__(self, item, left_link=None, right_link=None):
        self.item = item
        self.left_link = left_link
        self.right_link = right_link

class MyTree:
    def __init__(self):
        self.root = None
        self.last_node = None

    def add_node(self, item, left_link_item, right_link_item):
        if self.root is None:
            self.root = Node(item, Node(left_link_item), Node(right_link_item))
            return
        
        temp_node = self.search_node(self.root, item)
        if temp_node is None:
            return
        
        temp_node.left_link = Node(left_link_item)
        temp_node.right_link = Node(right_link_item)

    def search_node(self, root, item):
        if root is None:
            return None
        
        if root.item == item:
            return root
        
        return_node = self.search_node(root.left_link, item)
        if return_node is not None:
            return return_node
        
        return_node = self.search_node(root.right_link, item)
        if return_node is not None:
            return return_node
        
        return None

    def pre_order(self, root):
        if root.item is None:
            return
        print(root.item, end='')
        self.pre_order(root.left_link)
        self.pre_order(root.right_link)

    def in_order(self, root):
        if root.item is None:
            return
        self.in_order(root.left_link)
        print(root.item, end='')
        self.in_order(root.right_link)

    def post_order(self, root):
        if root.item is None:
            return
        self.post_order(root.left_link)
        self.post_order(root.right_link)
        print(root.item, end='')

    def get_root(self):
        return self.root

tree = MyTree()
loop_num = int(input())
    
for _ in range(loop_num):
    input_root, input_left, input_right = input().split()
        
    if input_left == '.':
        input_left = None
    if input_right == '.':
        input_right = None
            
    tree.add_node(input_root, input_left, input_right)

tree.pre_order(tree.get_root())
print()
tree.in_order(tree.get_root())
print()
tree.post_order(tree.get_root())
print()
