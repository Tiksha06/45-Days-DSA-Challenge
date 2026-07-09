# Children Sum Property in a Binary Tree

## 📝 Problem Statement
Given a Binary Tree, check if it holds the **Children Sum Property**. 
A binary tree satisfies this property if, for every node, the data value of that node is equal to the sum of data values of its left and right children (if they exist). For leaf nodes, the property is trivially true.

---

## 💡 Approach
* Perform a recursive traversal (Postorder style) of the binary tree.
* For each internal node, calculate the sum of its left and right children's values.
* If `node.data == left_child.data + right_child.data` and both subtrees also satisfy the property, return true/1.
* Otherwise, return false/0.

---

## 📈 Complexity
* **Time Complexity:** $O(N)$ since we visit every node exactly once.
* **Space Complexity:** $O(H)$ for the stack space during recursive calls.