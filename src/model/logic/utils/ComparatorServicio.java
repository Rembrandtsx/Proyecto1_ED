package model.logic.utils;
import java.util.Comparator;

import model.vo.Service;

public class ComparatorServicio implements Comparator<Service>
{
	public int compare(Service s1, Service s2)
	{
		if(s1.getDateStart().before(s2.getDateStart()))
		{ 
			return -1;
		}
		else if(s1.getDateStart() == s2.getDateStart())
		{
			if(s1.getDateEnd().before(s2.getDateEnd()))
			{
				return -1;
			}
			else if(s1.getDateEnd() == s2.getDateEnd())
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
		else
		{
			return 1;
		}
	}
}