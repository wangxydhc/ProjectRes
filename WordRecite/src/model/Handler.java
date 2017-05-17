package model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Handler {
	public Word handle(Word word){
		word.setId(word.getId()+1);
		word.setRemTimes(word.getRemTimes()+1);
		String s="sateopine";
		word.setState(s);
		ProNode pn=new ProNode();
		Date date=new Date();
		pn.setDate(date);
		pn.setState(s);
		pn.setWhichTime(word.getRemTimes());
//		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ProNode temp=word.getProNode();
		if (temp==null)
			word.setProNode(pn);
		else
		{
			while(temp.getNext()!=null)
				temp=temp.getNext();			
				temp.setNext(pn);			
		}
		return word;
		}
}
