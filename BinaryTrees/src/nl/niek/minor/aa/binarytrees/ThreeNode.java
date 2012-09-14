package nl.niek.minor.aa.binarytrees;

public class ThreeNode extends Node
{

	private static final int	THREE_NODES	= 3;

	public ThreeNode(int depth)
	{
		super(THREE_NODES, depth);
	}

	public ThreeNode(Node parentNode)
	{
		this(parentNode.getDepth() + 1);
		setParentNode(parentNode);
	}

	@Override
	public void addElement(Integer element)
	{
		// if !isFull
		// add element in correct key
		// else
		// split node: move middle value to upper node. new nodes for other
		split();
		// values
	}

	private void moveKeyToParent(Integer key)
	{
		// check if there is a Node above this one
		// if so: move the middle value upwards.
		Node parentNode = getParentNode();

		if (parentNode != null)
		{
			parentNode.addElement(key);
		}
		else
		{
			// create new node and make this parent.
		}
	}

	private void split()
	{
		// Split the node into two separate nodes
		// Create a new node with the highest key of the two that are left
		// Create this new node with the same parent as this one!
		// (there should only be two: the middle one is moved to the node above
		// this one)
		// Keep the lower of the two keys in this node.

		Node newRightNode = new ThreeNode(getParentNode());
		// add node to list of nodes?
		// add all elements that are larger than the middle key to the new Node.
	}

	protected Integer getMiddleKey()
	{
		return null;
	}

	protected Integer removeMiddleKey()
	{
		return null;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " Middle key: " + getMiddleKey();
	}
}
