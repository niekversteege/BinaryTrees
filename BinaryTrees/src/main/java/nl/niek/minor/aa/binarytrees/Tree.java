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
		
		Node parent = nodeForNewKey.getParent();
		
		if (parent == null)
		{
			// create a new node as parent.
			// set middle value in parent
			// set parent as parent
			// set this as left child in parent

			// create a sibling node
			// set right value to sibling node
			// set sibling node as child of new parent
			// set sibling node as right child in parent
		}
		else
		{
			// create new sibling node
			// set new sibling node as parents child according to parent's
			// keys
			// set parent on new sibling node
			// TODO: what to do when parent has too many children?
			// TODO: make keys and children a list! Keep track of keys with
			// a number or size().
			// TODO: redistribute children after splitting, according to
			// keys of other nodes.
		}

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
}
