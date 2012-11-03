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

	public Node()
	{
		keys = new ArrayList<Integer>();
		children = new ArrayList<Node>();
	}

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
		Node sibling = new Node();
		// set big value to sibling node
		sibling.addKey(bigKey);
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

		// set middle value in parent
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

	public boolean isFull()
	{
		return MAX_KEYS == keys.size();
	}

	public void addChild(Node child)
	{
		child.setParent(this);
		children.add(child);
	}

	public List<Node> getChildren()
	{
		return children;
	}

	public boolean hasChildren()
	{
		return children.size() > 0;
	}

	public Node getParent()
	{
		return parent;
	}

	public void setParent(Node parent)
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

	public Integer getSmallKey()
	{
		return keys.get(0);
	}

	public Integer getBigKey()
	{
		return keys.get(1);
	}
}
