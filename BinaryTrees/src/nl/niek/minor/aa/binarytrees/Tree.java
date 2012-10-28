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

		if (nodeForNewKey.hasBothKeysSet())
		{
			NodeSplitKeySorter splitSorter = new NodeSplitKeySorter(
					nodeForNewKey.getBigKey(), nodeForNewKey.getSmallKey(),
					newKey);

			nodeForNewKey.setBigKey(0);
			nodeForNewKey.setSmallKey(0);

			Node parent = nodeForNewKey.getParent();

			if (parent == null)
			{
				nodeForNewKey.setSmallKey(splitSorter.getMiddleKey());

				Node leftChild = new Node();
				leftChild.setSmallKey(splitSorter.getSmallKey());
				leftChild.setParent(nodeForNewKey);
				Node rightChild = new Node();
				rightChild.setSmallKey(splitSorter.getBigKey());
				rightChild.setParent(nodeForNewKey);

				nodeForNewKey.setLeftChild(leftChild);
				nodeForNewKey.setRightChild(rightChild);

				rootNode = nodeForNewKey;
			}
			else
			{
				// create new node
				// set same parent as this
				// parent.set child on new node
				
			}
		}
		else
		{
			nodeForNewKey.addKey(newKey);
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

		if (!node.hasBothKeysSet())
		{
			return node;
		}

		while (true)
		{
			if (key < node.getSmallKey())
			{
				Node leftChild = node.getLeftChild();

				if (leftChild == null)
				{
					leftChild = new Node();
					leftChild.setParent(node);
					node.setLeftChild(leftChild);

					return leftChild;
				}

				node = leftChild;
			}
			else if (key > node.getSmallKey() && key < node.getBigKey())
			{
				Node middleChild = node.getMiddleChild();

				if (middleChild == null)
				{
					middleChild = new Node();
					middleChild.setParent(node);
					node.setMiddleChild(middleChild);

					return middleChild;
				}

				node = middleChild;
			}
			else if (key > node.getBigKey())
			{
				Node rightChild = node.getRightChild();

				if (rightChild == null)
				{
					rightChild = new Node();
					rightChild.setParent(node);
					node.setRightChild(rightChild);

					return rightChild;
				}

				node = rightChild;
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
