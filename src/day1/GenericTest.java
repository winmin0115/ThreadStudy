package day1;
import java.util.*;
public class GenericTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("java");
		list.add("100");
		list.add("servlet");
		list.add("jdbc");
		
		for(int i=0; i < list.size(); i++)
			System.out.println(list.get(i));
		System.out.println();		
		
		for(Object value : list) {
			String s = (String)value;		
			System.out.println(s);
		}
		String ss = UUID.randomUUID().toString();
		System.out.println(ss.length());   //OAUTH2.0 Ű ���̶� ���°� �Ȱ��� ������������ �׳� �̰ž��� Ű �߱� ������... ��ſ� �������� �̷��� �����ؾ��ϱ��ϴµ� �ӽ÷δ� ��밡����.. ����� ������?
		System.out.println(ss);
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			Object value = iter.next();
			String s = (String)value;		
			System.out.println(s);
		}
	}
}
