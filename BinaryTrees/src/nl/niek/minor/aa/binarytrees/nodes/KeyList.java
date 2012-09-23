package nl.niek.minor.aa.binarytrees.nodes;

import java.util.ArrayList;
import java.util.List;

public class KeyList
{
	private final int		maxNrOfKeys;

	private List<Integer>	keys;

	public KeyList(final int maxNrOfKeys)
	{
		this.maxNrOfKeys = maxNrOfKeys;
		keys = new ArrayList<Integer>();
	}

	public final boolean hasKey(Integer key)
	{
		for (Integer i : keys)
		{
			if (i == key)
			{
				return true;
			}
		}

		return false;
	}

	public final boolean isEmpty()
	{
		return keys.isEmpty();
	}

	/**
	 * Sort the keys in order of side. Left element is smallest. Right element
	 * is largest.
	 */
	protected void sortKeys()
	{
		// TODO: all
	}

	protected Integer getLowestKey()
	{
		Integer lowestKey = 0;

		for (Integer i : keys)
		{
			if (i < lowestKey)
				lowestKey = i;
		}

		if (lowestKey == 0)
		{
			return null;
		} else
		{
			return lowestKey;
		}
	}

	protected Integer removeLowestKey()
	{
		Integer lowestKey = getLowestKey();
		keys.remove(lowestKey);
		return lowestKey;
	}

	protected Integer getHighestKey()
	{
		Integer highestKey = 0;

		for (Integer i : keys)
		{
			if (i > highestKey)
				highestKey = i;
		}

		if (highestKey == 0)
		{
			return null;
		} else
		{
			return highestKey;
		}
	}

	protected Integer removeHighestKey()
	{
		Integer highestKey = getHighestKey();
		keys.remove(highestKey);
		return highestKey;
	}

	public boolean isFull()
	{
		return keys.size() >= maxNrOfKeys;
	}

	@Override
	public String toString()
	{
		return keys.toString();
	}

	public void addKeys(List<Integer> keysToAdd)
	{
		if (!(keys.size() + keysToAdd.size() >= maxNrOfKeys))
		{
			keys.addAll(keysToAdd);
			sortKeys();
		} else
		{
			throw new IndexOutOfBoundsException(
					"KeyList is full or new list is too large.");
		}
	}

	public void addKey(Integer key)
	{
		if (!isFull())
		{
			keys.add(key);
			sortKeys();
		} else
		{
			throw new IndexOutOfBoundsException("KeyList is full.");
		}
	}
	
	public List<Integer> getKeys()
	{
		return keys;
	}
}
