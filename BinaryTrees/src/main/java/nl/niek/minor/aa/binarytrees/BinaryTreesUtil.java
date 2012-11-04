package nl.niek.minor.aa.binarytrees;

import java.util.List;

import nl.niek.minor.aa.binarytrees.nodes.Node;

public class BinaryTreesUtil
{
	public static void printNodeTree(Node rootNode)
	{
		rootNode.print("", true);
	}

	public static void print(String string)
	{
		System.out.print(string);
	}

	public static void println(String string)
	{
		System.out.println(string);
	}

	public static void printNodeList(List<Node> children)
	{
		for (Node n : children)
		{
			if (n != null)
			{
				print(n.toString() + " ");
			}
		}
		print("\n");
	}
}
