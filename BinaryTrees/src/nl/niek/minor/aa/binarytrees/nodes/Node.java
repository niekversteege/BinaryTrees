package nl.niek.minor.aa.binarytrees.nodes;

import nl.niek.minor.aa.binarytrees.NodeSplitKeySorter;

public class Node
{
	private int		smallKey	= 0;
	private int		bigKey		= 0;

	private Node	leftChild	= null;
	private Node	rightChild	= null;
	private Node	middleChild	= null;
	private Node	parent		= null;

	public Node()
	{

	}

	public void addKey(int newKey)
	{
		if (smallKey == 0)
		{
			smallKey = newKey;
		}
		else if (bigKey == 0)
		{
			bigKey = newKey;
		}
		else
		{
			// TODO: SPLIT
			NodeSplitKeySorter splitSorter = new NodeSplitKeySorter(bigKey,
					smallKey, newKey);

			bigKey = 0;
			smallKey = 0;

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
		}

		putKeysInOrder();
	}

	private void putKeysInOrder()
	{
		if (smallKey > bigKey)
		{
			int temp = bigKey;
			bigKey = smallKey;
			smallKey = temp;
		}
	}

	private boolean hasBothKeysSet()
	{
		return smallKey != 0 && bigKey != 0;
	}

	public boolean keyAreZero()
	{
		return smallKey == 0 && bigKey == 0;
	}

	public int getSmallKey()
	{
		return smallKey;
	}

	public void setSmallKey(int smallKey)
	{
		this.smallKey = smallKey;
	}

	public int getBigKey()
	{
		return bigKey;
	}

	public void setBigKey(int bigKey)
	{
		this.bigKey = bigKey;
	}

	public Node getLeftChild()
	{
		return leftChild;
	}

	public void setLeftChild(Node leftChild)
	{
		this.leftChild = leftChild;
	}

	public Node getRightChild()
	{
		return rightChild;
	}

	public void setRightChild(Node rightChild)
	{
		this.rightChild = rightChild;
	}

	public Node getMiddleChild()
	{
		return middleChild;
	}

	public void setMiddleChild(Node middleChild)
	{
		this.middleChild = middleChild;
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
		return "[" + smallKey + "] [" + bigKey + "]";
	}
}
