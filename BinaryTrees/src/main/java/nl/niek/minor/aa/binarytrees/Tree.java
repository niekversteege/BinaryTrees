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
		rootNode = new Node();
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

		BinaryTreesUtil.println("Root node: " + rootNode.toString());
		if (rootNode.hasChildren())
		{
			for (Node n : rootNode.getChildren())
			{
				BinaryTreesUtil.print("Child: " + n.toString() + " ");
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
		boolean atLeafLevel = false;

		Node node = rootNode;

		/* If the root is full, search the children. */
		if (node.isFull())
		{
			while (!atLeafLevel)
			{
				if (node.hasKey(key))
				{
					throw new IllegalStateException(
							"Key already exists in tree.");
				}
				else
				{
					if (node.hasChildren())
					{
						node = node.getChild(key);
					}
					else
					{
						atLeafLevel = true;
						break;
					}
				}
			}
		}

		return node;
	}
}
