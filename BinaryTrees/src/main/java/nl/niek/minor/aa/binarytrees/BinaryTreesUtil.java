package nl.niek.minor.aa.binarytrees;

import java.util.ArrayList;
import java.util.List;

import nl.niek.minor.aa.binarytrees.nodes.Node;

public class BinaryTreesUtil
{
	public static void printNodeTree(Node rootNode)
	{
		List<Node> root = new ArrayList<Node>();
		root.add(rootNode);

		printNodeTree(root, 1);
	}

	public static void printNodeTree(List<Node> nodes, int layer)
	{
		List<Node> children = new ArrayList<Node>();

		print("Layer " + layer + ": ");
		for (Node n : nodes)
		{
			if (n != null)
			{
				print(n.toString());
				
				if (n.getParent() != null)
				{
					print("(parent: " + n.getParent().toString() + ") | ");
				}
				
				if (n.hasChildren())
				{
					children.addAll(n.getChildren());
				}
			}
		}
		print("\n");

		if (children.size() > 0)
		{
			printNodeTree(children, layer + 1);
		}
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
