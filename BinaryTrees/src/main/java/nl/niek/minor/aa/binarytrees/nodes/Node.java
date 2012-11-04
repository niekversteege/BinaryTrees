package nl.niek.minor.aa.binarytrees.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nl.niek.minor.aa.binarytrees.BinaryTreesUtil;

public class Node
{
	private static final int	MAX_KEYS	= 2;
	private List<Integer>		keys;
	private Node				parent;
	private List<Node>			children;

	/**
	 * Create a new Node and set no keys.
	 */
	public Node()
	{
		keys = new ArrayList<Integer>();
		children = new ArrayList<Node>();

	}

	/**
	 * Create a new Node with the given key.
	 * 
	 * @param key
	 */
	public Node(Integer key)
	{
		this();
		keys.add(key);
	}

	/**
	 * Add a key to this Node. The keys are automatically sorted after adding.
	 * If the Node is already full then the Node splits itself.
	 * 
	 * @param newKey
	 */
	public void addKey(Integer newKey)
	{
		if (newKey == 0)
		{
			throw new IllegalArgumentException("Key can't be 0.");
		}
		if (hasKey(newKey))
		{
			throw new IllegalArgumentException("Key already exists!");
		}
		if (isFull())
		{
			BinaryTreesUtil.println("Splitting " + this.toString()
					+ " because " + newKey + " was added.");
			split(newKey);
		}
		else
		{
			keys.add(newKey);
			sortKeys(keys);
		}
	}

	/**
	 * Does this node contain the given key.
	 * 
	 * @param newKey
	 * @return
	 */
	public boolean hasKey(Integer newKey)
	{
		return keys.contains(newKey);
	}

	private void split(Integer newKey)
	{
		Node parent = getParent();

		List<Integer> threeKeys = new ArrayList<Integer>();
		threeKeys.add(getSmallKey());
		threeKeys.add(getBigKey());
		threeKeys.add(newKey);

		this.keys.clear();

		sortKeys(threeKeys);

		int smallKey = threeKeys.get(0);
		int middleKey = threeKeys.get(1);
		int bigKey = threeKeys.get(2);

		if (parent == null)
		{
			// create a new node as parent.
			parent = new Node();
			// set this as left child in parent
			parent.addChild(this);
		}
		// set small value in this
		this.addKey(smallKey);

		// create a sibling node
		Node sibling = new Node(bigKey);
		// set sibling node as child of new parent
		parent.addChild(sibling);
		// give sibling children that are larger than the middle key
		if (hasChildren())
		{
			List<Node> childrenForSibling = getChildrenForSibling(middleKey);
			if (childrenForSibling.size() > 0)
			{
				for (Node n : childrenForSibling)
				{
					sibling.addChild(n);
				}
			}
		}

		// set middle value in parent last: because the parent might also split
		// and screw up stuff.
		parent.addKey(middleKey);
	}

	/**
	 * Get all children larger than the given key. Also remove these children
	 * from this node as they are placed as the siblings children.
	 * 
	 * @param key
	 * @return
	 */
	protected List<Node> getChildrenForSibling(int key)
	{
		List<Node> childrenToMove = new ArrayList<Node>();

		for (Node n : children)
		{
			if (n.getSmallKey() > key)
			{
				childrenToMove.add(n);
			}
		}

		children.removeAll(childrenToMove);

		return childrenToMove;
	}

	/**
	 * Get the child that this key where this key can be placed. This method
	 * looks at the key(s) in this Node to see which child it needs.
	 * 
	 * @param key
	 * @return
	 */
	public final Node getChild(int key)
	{
		Node child = null;

		if (hasChildren())
		{
			if (keys.size() == 1)
			{
				/* This is a two-node */
				child = getChildForTwoNode(key);
			}
			else
			{
				/* This is a three-node */
				child = getChildForThreeNode(key);
			}
		}

		return child;
	}

	private Node getChildForThreeNode(int key)
	{
		Node child = null;

		if (key < getSmallKey())
		{
			for (Node n : children)
			{
				if (n.getLargestKey() < getSmallKey())
				{
					child = n;
				}
			}
		}
		else if (key > getSmallKey() && key < getBigKey())
		{
			for (Node n : children)
			{
				if (n.getSmallKey() > getSmallKey()
						&& n.getLargestKey() < getBigKey())
				{
					child = n;
				}
			}
		}
		else
		{
			for (Node n : children)
			{
				if (n.getSmallKey() > getBigKey())
				{
					child = n;
				}
			}
		}

		return child;
	}

	private Node getChildForTwoNode(int key)
	{
		Node child = null;
		if (key < getSmallKey())
		{
			for (Node n : children)
			{
				if (n.getLargestKey() < getSmallKey())
				{
					child = n;
				}
			}
		}
		else
		{
			for (Node n : children)
			{
				if (n.getSmallKey() > getSmallKey())
				{
					child = n;
				}
			}
		}
		return child;
	}

	/**
	 * Get the largest key of this node. the getBigKey() method cannot always be
	 * called because the node might only have one key. Use this instead when
	 * not sure of how many keys a node has.
	 * 
	 * @return
	 */
	public Integer getLargestKey()
	{
		Integer retVal = keys.get(0);

		if (isFull())
		{
			retVal = keys.get(1);
		}

		return retVal;
	}

	private void sortKeys(List<Integer> listOfKeys)
	{
		Collections.sort(listOfKeys);
	}

	/**
	 * Does this node have both keys set.
	 * 
	 * @return
	 */
	public boolean isFull()
	{
		return MAX_KEYS == keys.size();
	}

	/**
	 * Add a child to this Node. Also sets the parent of the given child to this
	 * node.
	 * 
	 * @param child
	 */
	public void addChild(Node child)
	{
		child.setParent(this);
		children.add(child);
	}

	/**
	 * Get the entire list of children.
	 * 
	 * @return
	 */
	public final List<Node> getChildren()
	{
		return children;
	}

	/**
	 * Does this node have any children.
	 * 
	 * @return
	 */
	public boolean hasChildren()
	{
		return children.size() > 0;
	}

	/**
	 * Get the parent Node of this node.
	 * 
	 * @return
	 */
	public Node getParent()
	{
		return parent;
	}

	/**
	 * Set the parent Node of this Node.
	 * 
	 * @param parent
	 */
	private void setParent(Node parent)
	{
		this.parent = parent;
	}

	@Override
	public String toString()
	{
		String retVal = "";

		if (isFull())
		{
			retVal = "(" + getSmallKey() + ", " + getBigKey() + ")";
		}
		else
		{
			retVal = "(" + getSmallKey() + ")";
		}

		return retVal;
	}

	/**
	 * Get the left key of this node. This can theoretically return null
	 * although there should never be a Node with no keys set.
	 * 
	 * @return
	 */
	public Integer getSmallKey()
	{
		return keys.get(0);
	}

	/**
	 * Get the right key of this node. Can return null (if Node is a twoNode).
	 * 
	 * @return
	 */
	public Integer getBigKey()
	{
		return keys.get(1);
	}

	/**
	 * Useful tree printing method. Based on an example given on <a
	 * href=http://stackoverflow
	 * .com/questions/4965335/how-to-print-binary-tree-diagram>StackOverflow</a>
	 * 
	 * @param prefix
	 * @param isTail
	 */
	public void print(String prefix, boolean isTail)
	{
		BinaryTreesUtil.println(prefix + (isTail ? "--- " : "|-- ")
				+ toString());
		if (children != null)
		{
			for (int i = 0; i < children.size() - 1; i++)
			{
				children.get(i).print(prefix + (isTail ? "    " : "|   "),
						false);
			}
			if (children.size() >= 1)
			{
				children.get(children.size() - 1).print(
						prefix + (isTail ? "    " : "|   "), true);
			}
		}
	}
}
