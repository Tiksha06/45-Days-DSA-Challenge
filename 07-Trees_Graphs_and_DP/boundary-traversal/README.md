# Boundary Traversal of Binary Tree

## 📝 Problem Statement
Given a Binary Tree, find its Boundary Traversal. The boundary traversal includes:
1. **Left Boundary:** From root to the left-most node (excluding leaf nodes), in top-down order.
2. **Leaf Nodes:** All the leaf nodes from left to right.
3. **Right Boundary:** From bottom-up, from the right-most node back to the root (excluding leaf nodes).

---

## 💡 Approach
* **Left Boundary:** Traverse left child recursively. If left doesn't exist, go right. Avoid adding leaf nodes.
* **Leaf Nodes:** Do a simple Inorder/Preorder traversal and check if `node.left == null && node.right == null`.
* **Right Boundary:** Traverse right child recursively (go left if right doesn't exist). Push to a stack or list, then reverse to get bottom-up order. Avoid leaf nodes.

---

## 📈 Complexity
* **Time Complexity:** $O(N)$ where $N$ is the number of nodes in the Binary Tree.
* **Space Complexity:** $O(H)$ for the recursive stack space where $H$ is the height of the tree.