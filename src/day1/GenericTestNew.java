package day1;
import java.util.*;
public class GenericTestNew {
	public static void main(String[] args) {
		// ���׸��� ��� ������ ����Ǿ� ������� Ŭ������ ��ü ������
		// Ÿ�� �Ķ���Ͷ�� ���� ����Ѵ�. 
		ArrayList<String> list = new ArrayList<String>();  // Ÿ���Ķ����
		list.add("java");
		list.add("100");
		list.add("servlet");
		list.add("jdbc");
		
		for(int i=0; i < list.size(); i++)
			System.out.println(list.get(i));
		System.out.println();		
		
		for(String value : list) {			
			System.out.println(value);
		}
		System.out.println();
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String s = iter.next();			
			System.out.println(s);
		}
	}
}

