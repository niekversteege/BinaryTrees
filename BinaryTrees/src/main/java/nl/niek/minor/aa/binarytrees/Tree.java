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
		this(new Node());
	}

	public Tree(Node rootNode)
	{
		this.rootNode = rootNode;
	}

	/**
	 * Add a key to the tree. Refreshes the root node if rootNode created a
	 * parent.
	 * 
	 * @param success
	 *            : key is not in the node where it is supposed to be.
	 * @param newKey
	 */
	public boolean addKey(int newKey)
	{
		Node nodeForNewKey = search(newKey);

		if (nodeForNewKey.hasKey(newKey))
		{
			return false;
		}
		else
		{
			nodeForNewKey.addKey(newKey);

			refreshRootNode();
			return true;
		}
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
	 * Look for the node which contains this key. Key should not be in the tree
	 * so if it is found it throws an exception. Otherwise it will return the
	 * Node that should add the key.
	 * 
	 * @param key
	 * @return
	 */
	public Node search(final int key)
	{
		boolean atLeafLevel = false;

		Node node = rootNode;

		while (!atLeafLevel)
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

		return node;
	}

	/**
	 * Get the node without a parent node. This node might be changed during the
	 * course of adding a series of keys due to splitting.
	 * 
	 * @return
	 */
	public Node getRootNode()
	{
		refreshRootNode();
		return rootNode;
	}
}
