package nl.niek.minor.aa.binarytrees;

import java.util.ArrayList;
import java.util.List;

public abstract class Node
{

	private static final int	MAX_NODES	= 5;

	private Node				parentNode;

	private List<Integer>		keys;

	private final int			nrOfNodes;

	private int					depth;

	public Node(int nrOfNodes, int depth)
	{
		if (nrOfNodes > MAX_NODES)
		{
			throw new IllegalArgumentException(
					"Nodes can only have 5 elemements for now.");
		}

		keys = new ArrayList<Integer>();
		this.nrOfNodes = nrOfNodes;
		parentNode = null;
		this.depth = depth;
	}

	protected boolean isFull()
	{
		return keys.size() >= nrOfNodes;
	}

	protected void addElementAtCorrectPosition(Integer element)
	{
		if (!isFull())
		{
			for (int i = 0; i < keys.size(); i++)
			{
				if (element < i)
				{
					keys.add(i, element);
				}
			}
		} else
		{
			throw new IndexOutOfBoundsException(
					"Cannot add a new elmenent to a full Node.");
		}
	}

	/**
	 * Sort the keys in order of side. Left element is smallest. Right element
	 * is largest.
	 */
	protected void sortKeys()
	{
		//TODO: all
	}

	protected Integer getLeftKey()
	{
		Integer lowestKey = 0;

		for (Integer i : keys)
		{
			if (i < lowestKey)
				lowestKey = i;
		}

		if (lowestKey == 0)
		{
			return null;
		} else
		{
			return lowestKey;
		}
	}

	protected Integer removeLeftKey()
	{
		Integer lowestKey = getLeftKey();
		keys.remove(lowestKey);
		return lowestKey;
	}

	protected Integer getRightKey()
	{
		Integer highestKey = 0;

		for (Integer i : keys)
		{
			if (i > highestKey)
				highestKey = i;
		}

		if (highestKey == 0)
		{
			return null;
		} else
		{
			return highestKey;
		}
	}

	protected Integer removeRightKey()
	{
		Integer highestKey = getRightKey();
		keys.remove(highestKey);
		return highestKey;
	}

	protected Node getParentNode()
	{
		return parentNode;
	}

	protected void setParentNode(Node parentNode)
	{
		this.parentNode = parentNode;
	}

	protected int getDepth()
	{
		return depth;
	}

	protected void setDepth(int depth)
	{
		this.depth = depth;
	}

	public abstract void addElement(Integer element);

	@Override
	public String toString()
	{
		String isRoot = "";
		if (getParentNode() == null)
		{
			isRoot = "* Root Node *";
		}
		return isRoot + " Left key: " + getLeftKey() + " Right key:"
				+ getRightKey();
	}
}