package project.thangnd.utils;

import java.util.Comparator;

import project.thangnd.dtos.Restaurant_Info;

public class CompareRestByRate implements Comparator<Restaurant_Info>{

	@Override
	public int compare(Restaurant_Info o1, Restaurant_Info o2) {
		// TODO Auto-generated method stub
		int value = (int) (o2.getRate_rest() - o1.getRate_rest());
		return value;
	}

}
