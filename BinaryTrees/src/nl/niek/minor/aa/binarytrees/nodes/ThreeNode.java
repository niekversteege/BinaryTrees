package nl.niek.minor.aa.binarytrees.nodes;


public class ThreeNode extends Node
{

	private static final int	NR_OF_KEYS	= 2;


	public ThreeNode(int depth)
	{
		super(NR_OF_KEYS, depth);
	}

	public ThreeNode(Node parentNode)
	{
		super(NR_OF_KEYS, parentNode);
	}
}
