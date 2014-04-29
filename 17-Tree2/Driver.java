public class Driver
{
    public static void main(String[] args)
    {
	Node root = new Node(100);
	BST tree = new BST(root);
	tree.insert(new Node(150));
	tree.insert(new Node(200));
	tree.insert(new Node(125));
	tree.insert(new Node(120));
	tree.delete(root, 150);
	System.out.println(root.getRight().getLeft().getData());
	tree.insert(new Node(75));
	tree.insert(new Node(53));
	tree.insert(new Node(85));
	tree.delete(root, 75);
	System.out.println(root.getLeft().getLeft().getData());
    }

}
