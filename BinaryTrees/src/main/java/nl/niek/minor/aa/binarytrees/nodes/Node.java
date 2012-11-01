package nl.niek.minor.aa.binarytrees.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node
{
	private static final int	MAX_KEYS	= 2;
	private List<Integer>		keys;
	private List<Node>			children;
	private Node				parent;

	public Node()
	{
		keys = new ArrayList<Integer>();
		children = new ArrayList<Node>();
	}

	public void addKey(int newKey)
	{
		if (newKey == 0)
		{
			throw new IllegalArgumentException("Key can't be 0.");
		}
		if (keys.size() < MAX_KEYS)
		{
			keys.add(newKey);
			sortKeys();
		}
	}

	private void sortKeys()
	{
		Collections.sort(keys);
	}

	public boolean isFull()
	{
		return MAX_KEYS == keys.size();
	}

	public void addChild(Node child)
	{
		children.add(child);
	}

	public Node getChild(int key)
	{
		return null;
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
		return "[" + getSmallKey() + "] [" + getBigKey() + "]";
	}

	public int getSmallKey()
	{
		return keys.get(0);
	}

	public int getBigKey()
	{
		return keys.get(1);
	}
}
