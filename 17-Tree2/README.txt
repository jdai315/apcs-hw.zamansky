BST part 3
    - delete(int x) method

1) get a pointer to the parent of the node we want to delete
   (piggy back or recursion)

2) 3 Cases
   a) To delete a leaf
      - set parent's left or right pointer to null
   b) To delete a Node with one child
      - set parent's left or right pointer to child's non-null pointer
   c) To delete a Node with two children
      - find largest value on left subtree as far right as posible
      	(or find smallest on right subtree)
      - make a copy of that value
      - pretend you have a tree with the node to delete as the root and delete the largest node in the left subtree(it can only have 0 or 1 child)
      - replace the node to delete with the copied value

special case: deleting the root
- use if statements
OR
- use a dummy node: dummy's value should be less than any possible tree value
      
