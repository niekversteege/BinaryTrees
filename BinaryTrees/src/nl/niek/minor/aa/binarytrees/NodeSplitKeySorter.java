package nl.niek.minor.aa.binarytrees;

public class NodeSplitKeySorter
{
	private Integer	smallKey;

	private Integer	bigKey;

	private Integer	middleKey;

	public NodeSplitKeySorter(Integer key1, Integer key2, Integer key3)
	{
		setSmallKey(key1, key2, key3);
		setBigKey(key1, key2, key3);
		setMiddleKey(key1, key2, key3);
	}

	private void setMiddleKey(Integer key1, Integer key2, Integer key3)
	{
		middleKey = key1;
		
		if (middleKey == smallKey || middleKey == bigKey)
		{
			middleKey = key2;
		}
		if (middleKey == smallKey || middleKey == bigKey)
		{
			middleKey = key3;
		}
	}

	private void setBigKey(Integer key1, Integer key2, Integer key3)
	{
		bigKey = key1;

		if (key2 > bigKey)
		{
			bigKey = key2;
		}
		if (key3 > bigKey)
		{
			bigKey = key3;
		}
	}

	private void setSmallKey(Integer key1, Integer key2, Integer key3)
	{
		smallKey = key1;

		if (key2 < smallKey)
		{
			smallKey = key2;
		}
		if (key3 < smallKey)
		{
			smallKey = key3;
		}
	}

	public Integer getBigKey()
	{
		return bigKey;
	}

	public Integer getSmallKey()
	{
		return smallKey;
	}

	public Integer getMiddleKey()
	{
		return middleKey;
	}
}
