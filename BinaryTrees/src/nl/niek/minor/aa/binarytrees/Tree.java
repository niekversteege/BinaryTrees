package nl.niek.minor.aa.binarytrees;

import nl.niek.minor.aa.binarytrees.nodes.Node;

/**
 * Tree class which contains the list of nodes.
 * 
 * @author Niek
 * 
 */
public class Tree
{
	private Node	rootNode;

	public Tree()
	{

	}

	public void addKey(int newKey)
	{
		Node nodeForNewKey = search(newKey);

		nodeForNewKey.addKey(newKey);

		refreshRootNode();
	}

	private void refreshRootNode()
	{
		if (rootNode.getParent() != null)
		{
			while (rootNode.getParent() != null)
			{
				rootNode = rootNode.getParent();
			}
		}
	}

	/**
	 * Look for the node which contains this key. If it is not found then it
	 * returns a node where it should be added.
	 * 
	 * @param key
	 * @return
	 */
	public Node search(final int key)
	{
		Node node = getRootNode();

		while (true)
		{
			if (key < node.getSmallKey())
			{

			}
			else if (key > node.getSmallKey() && key < node.getBigKey())
			{

			}
			else if (key > node.getBigKey())
			{

			}
		}
	}

	private Node getRootNode()
	{
		if (rootNode == null)
		{
			rootNode = new Node();
		}

		return rootNode;
	}

	public void printNodeTree()
	{
		printNodeTree(rootNode, 0);
	}

	private void printNodeTree(Node node, int depth)
	{
		printLine(node.toString() + " at depth " + depth);

		if (node.getLeftChild() != null)
		{
			printNodeTree(node.getLeftChild(), depth + 1);
		}
		if (node.getMiddleChild() != null)
		{
			printNodeTree(node.getMiddleChild(), depth + 1);
		}
		if (node.getRightChild() != null)
		{
			printNodeTree(node.getRightChild(), depth + 1);
		}
	}

	public void printRootNodeAndDirectChildren()
	{
		if (rootNode != null)
		{
			printLine("         Root node: " + rootNode.toString());
			printLine("Left : " + rootNode.getLeftChild() + ". Mid: "
					+ rootNode.getMiddleChild() + ". Right: "
					+ rootNode.getRightChild() + ".");
		}
	}

	private void printLine(String string)
	{
		System.out.println(string);
	}

}
