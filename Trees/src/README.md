# Binary Search Tree

A binary search tree (BST) is a formidable data structure for storing information and searching through it. The fundamental unit in a BST is called a node. Tree nodes contain three items: some content, and two "children". The children are nodes connected to their parent node. A BST node can have up to two children: we call them left and right, respectively.

Class `BST` provides a basic tree node object with some String content.

Data are inserted in a BST in the following manner. First, we initialize the tree by designating the first data item to be stored as the `root` node. The basic constructor in class `BST` creates an object with the passed string value, and two children that are, at this time, `null`.

Now that we have a first node in the structure, we can begin adding more data using the following rule: a data item (in this case a string value) that is less than the string in the current node, goes to the left; if greater, to the right. If the designated location is occupied, i.e., if there is a node there already, we repeat the comparison with that node's contents until we find an empty spot.