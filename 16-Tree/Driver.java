public class Driver
{
    public static void main(String[] args)
    {
	Node root = new Node(100);
	BST tree = new BST(root);
	root.setRight(new Node(150));
	root.getRight().setRight(new Node(200));
	root.getRight().setLeft(new Node(125));
	System.out.println(root.getData());
	tree.insert(new Node(120));
	System.out.println(tree.search(120).getData());
	System.out.println(tree.search2(root, 120).getData());
    }

}
