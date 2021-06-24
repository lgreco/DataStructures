# Binary Search Tree

A binary search tree (BST) is a formidable data structure for storing information and searching through it. The fundamental unit in a BST is called a node. Tree nodes contain three items: some content, and two "children". The children are nodes connected to their parent node. A BST node can have up to two children: we call them left and right, respectively.

Class `BST` provides a basic tree node object with some String content.

Data are inserted in a BST in the following manner. First, we initialize the tree by designating the first data item to be stored as the `root` node. The basic constructor in class `BST` creates an object with the passed string value, and two children that are, at this time, `null`.

## Assignment due 19 October 2020

For this assignment, review the `successor` method in BST. The successor of a node is the node with the next highest value in the tree. The successor of the node with the largest value in a tree, is null. The algorithm to find the successor of a node is straight forward: if the node has a right subtree, the successor is the smallest node in that subtree (for that we use method `minNode`). Otherwise, we traverse the tree from the root and towards the node whose successor we are seeking. Each node at which we continue to traverse left, we mark as the successor. The last such node is the actual successor. 

### `TreeNode` with parent node

Modify `BST` so that each `TreeNode` has a pointer to its parent node. (The only node without a parent is the root node). Ensure that every time you add a node to a tree, that all points (`left`, `right`, and `parent`) are updated as needed.

### Successor search using the parent node

Write a new method, with signature <br>
`TreeNode successorP(node ofThisNode)`<br>
that finds the successor of a node without traversing the tree from the root, but by using the knowledge captured in the `parent` field. 

There are many variants of this technique online. Many of them are incomplete or may contain bugs. Make sure that your code works perfectly well with each node in the test tree `sycamore`. Also make sure that your code is *well* documented with meaningful comments.

### Delete a node
Write a method with signature<br>
`boolean deleteNode(TreeNode deleteMe)`<br>
that implements the deletion algorithm as discussed in class. The deletion algorithm is as follows:

* If node-to-delete has zero children, just dereference it from its parent.
* If node-to-delete has one child only, its child is "adopted" by its parent.
* If the node-to-delete has two children, swap it with its successor, reducing the case to one of the previous two.

For this problem use the `parent` field in class `TreeNode`.