package nl.niek.minor.aa.binarytrees.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import nl.niek.minor.aa.binarytrees.Tree;
import nl.niek.minor.aa.binarytrees.nodes.Node;

public class BinaryTreesCLI
{
	private static final int	MAX_INPUT	= 1000;
	private static final String	STOP		= "stop";

	private Tree				tree;

	public BinaryTreesCLI(Tree tree)
	{
		this.tree = tree;
	}

	public static void printNodeTree(Node rootNode)
	{
		rootNode.print();
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

	public void start()
	{
		while (true)
		{
			println("Enter a number: (type 'stop' to exit)");
			String input = getInput();

			if (isStopCommand(input))
			{
				println("Stopping.");
				break;
			}

			Integer inputNumber = Integer.parseInt(input);

			if (inputNumber > 0 && inputNumber < MAX_INPUT)
			{
				tree.addKey(inputNumber);
				tree.getRootNode().print();
			}
			else
			{
				println("Please use a reasonable number.");
			}
		}
	}

	private boolean isStopCommand(String input)
	{
		return input.equalsIgnoreCase(STOP);
	}

	private String getInput()
	{

		String input = "";
		BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(
				System.in));
		try
		{
			input = inputBuffer.readLine();
		}
		catch (IOException e)
		{
			// TODO: hackerdehax
			e.printStackTrace();
		}

		return input;
	}
}
