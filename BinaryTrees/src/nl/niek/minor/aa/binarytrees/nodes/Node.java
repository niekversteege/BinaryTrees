package nl.niek.minor.aa.binarytrees.nodes;

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
			// SPLIT
			
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

	public boolean hasBothKeysSet()
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
