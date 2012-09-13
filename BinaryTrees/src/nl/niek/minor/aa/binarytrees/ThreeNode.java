package nl.niek.minor.aa.binarytrees;

public class ThreeNode extends Node {

	private static final int THREE_NODES = 3;

	public ThreeNode() {
		super(THREE_NODES);
	}

	@Override
	public void addElement(Integer element) {
		// if !isFull
		// add element in correct key
		// else
		// split node: move middle value to upper node. new nodes for other
		// values
	}
	
	private void moveKeyToUpperNode()
	{
		// check if there is a Node above this one
		// if so: move the middle value upwards.
	}
	
	private void split()
	{
		// Split the node into two separate nodes
		// Create a new node with the highest key of the two that are left (there should only be two: the middle one is moved to the node above this one)
		// Keep the lower of the two keys in this node.
	}
}
