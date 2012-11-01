package nl.niek.minor.aa.binarytrees.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		}
		// set middle value in parent
		parent.addKey(middleKey);
		// set small value in this
		this.addKey(smallKey);
		// set this as left child in parent
		parent.addChild(this);
		// set parent as parent
		this.setParent(parent);

		// create a sibling node
		Node sibling = new Node();
		// set big value to sibling node
		sibling.addKey(bigKey);
		// set sibling node as child of new parent
		parent.addChild(sibling);
		// set sibling node as right child in parent
		sibling.setParent(parent);

		// TODO: what to do when parent has too many children?
		// TODO: make keys and children a list! Keep track of keys with
		// a number or size().
		// TODO: redistribute children after splitting, according to
		// keys of other nodes.

	}

	public Node getChild(int key)
	{
		Node child = null;

		if (hasChildren())
		{
			/* If this is a 2Node, else 3Node */
			if (keys.size() == 1)
			{
				if (key < getSmallKey())
				{
					// get child with keys smaller than smallKey
				}
				else
				{
					// get child with keys larger than key
				}
			}
			else
			{
				if (key < getSmallKey())
				{
					// get child with keys smaller than smallKey
				}
				else if (key > getSmallKey() && key < getBigKey())
				{
					// get child with keys bigger than smallkey and smaller than
					// bigkey
				}
				else
				{
					// get child with keys bigger than bigkey
				}
			}
		}

		return child;
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
		if (isFull())
		{
			return "[" + getSmallKey() + "][" + getBigKey() + "]";
		}
		else
		{
			return "[" + getSmallKey() + "]";
		}
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
