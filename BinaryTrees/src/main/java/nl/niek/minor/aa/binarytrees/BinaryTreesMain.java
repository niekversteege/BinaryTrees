package nl.niek.minor.aa.binarytrees;

import nl.niek.minor.aa.binarytrees.cli.BinaryTreesCLI;

public class BinaryTreesMain
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Tree tree = new Tree();

		/* example from book */
//		tree.addKey(9);
//		tree.addKey(5);
//		tree.addKey(8);
//		tree.addKey(3);
//		tree.addKey(2);
//		tree.addKey(4);
//		tree.addKey(7);
		
		BinaryTreesCLI cli = new BinaryTreesCLI(tree);
		cli.start();
	}

}
