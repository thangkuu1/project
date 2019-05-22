package project.thangnd.utils;

import java.util.Comparator;

import project.thangnd.models.MessageChat;

public class CompareMessChat implements Comparator<MessageChat>{

	@Override
	public int compare(MessageChat o1, MessageChat o2) {
		// TODO Auto-generated method stub
		int value = o1.getCount_mess() - o2.getCount_mess();
		return value;
	}

}
