package nl.niek.minor.aa.binarytrees.nodes;

import java.util.ArrayList;
import java.util.List;

public abstract class Node extends KeyList
{
	private static final int	MAX_KEYS	= 5;

	private Node				parentNode;

	private int					depth;

	private List<Node>			childNodes;

	private final int			maxNrOfChilds;

	private Node(final int maxNrOfKeys)
	{
		super(maxNrOfKeys);

		if (maxNrOfKeys > MAX_KEYS)
		{
			throw new IllegalArgumentException(
					"Nodes can only have max. 5 keys for now.");
		}

		this.maxNrOfChilds = maxNrOfKeys + 1;
		childNodes = new ArrayList<Node>();
	}

	public Node(final int maxNrOfKeys, int depth)
	{
		this(maxNrOfKeys);
		parentNode = null;
		this.depth = depth;
	}

	public Node(final int maxNrOfKeys, Node parentNode)
	{
		this(maxNrOfKeys, parentNode.getDepth() + 1);
	}

	public final boolean hasChildren()
	{
		return !childNodes.isEmpty();
	}

	public final boolean isRootNode()
	{
		return getParentNode() == null;
	}

	public Node getParentNode()
	{
		return parentNode;
	}

	public final boolean hasParentNode()
	{
		return parentNode != null;
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

	public Node getChild(Integer key)
	{
		// TODO: all

		return null;
	}

	public final boolean canAddChild()
	{
		return childNodes.size() <= maxNrOfChilds;
	}

	public void addChild(Node childNode)
	{
		if (canAddChild())
		{
			throw new IndexOutOfBoundsException(
					"Cannot add child to a node with max childs.");
		} else
		{
			childNodes.add(childNode);
		}
	}

	@Override
	public String toString()
	{
		return super.toString();
	}
}