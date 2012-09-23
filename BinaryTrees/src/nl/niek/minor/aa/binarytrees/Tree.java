package nl.niek.minor.aa.binarytrees;

import java.util.ArrayList;
import java.util.List;

import nl.niek.minor.aa.binarytrees.nodes.KeyList;
import nl.niek.minor.aa.binarytrees.nodes.Node;
import nl.niek.minor.aa.binarytrees.nodes.ThreeNode;

/**
 * Tree class which contains the list of nodes.
 * 
 * @author Niek
 * 
 */
public class Tree
{
	private List<Node>	nodes;

	public Tree()
	{
		nodes = new ArrayList<Node>();
	}

	public void addKey(Integer newKey)
	{
		// if !isFull
		// add element in correct key
		// else
		// split node: move middle value to upper node. new nodes for other
		// values

		Node nodeForNewKey = search(newKey);

		if (nodeForNewKey.isFull())
		{
			// -make a list of the three keys that are used here: the two keys
			// of nodeForNewKey and the new key
			// -make new Node and put the largest key of the nodeForNewKey in it
			// -leave the smallest key in nodeForNewKey
			// -add the middle of the three keys to the parent of nodeForNewKey
			KeyList tempKeys = new KeyList(3);
			tempKeys.addKeys(nodeForNewKey.getKeys());
			tempKeys.addKey(newKey);
		} else
		{
			if (!nodeForNewKey.hasKey(newKey))
			{
				nodeForNewKey.addKey(newKey);
			}
		}
	}

	/**
	 * Look for the node which contains this key. If it is not found then it
	 * returns a pointer to a node with node children, where the key can be
	 * added.
	 * 
	 * @param key
	 * @return
	 */
	public Node search(final Integer key)
	{
		boolean found = false;
		Node returnNode = getRootNode();

		// if element is in root node:
		// return rootnode
		// else
		// ask for child tree which should contain the node for the element
		// keep asking until we find a child with no children
		// return the child with no children: this is where we can add the given
		// element

		while (!found)
		{
			if (!returnNode.hasKey(key))
			{
				if (returnNode.hasChildren())
				{
					returnNode = returnNode.getChild(key);
				} else
				{
					break;
				}
			} else
			{
				break;
			}
		}

		return returnNode;
	}

	private Node getRootNode()
	{
		Node rootNode = null;
		// start at first node or lowest node
		// ask for parent node until null
		// return node which has null parent
		if (nodes.isEmpty())
		{
			rootNode = new ThreeNode(0);
			nodes.add(rootNode);
		}
		else
		{
			rootNode = nodes.get(0);
			
			while(rootNode.hasParentNode())
			{
				rootNode = rootNode.getParentNode();
			}
		}
		return rootNode;
	}

	public void printNodeTree()
	{
		// get root node
		// ask for children
		// make new layer for all children of all nodes in this layer
	}
}
