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
		System.out.println(ss.length());   //OAUTH2.0 키 길이랑 형태가 똑같아 인증서버에서 그냥 이거쓰면 키 발급 가능함... 대신에 리프레시 이런거 구현해야하긴하는데 임시로는 사용가능함.. 기공에 넣을까?
		System.out.println(ss);
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			Object value = iter.next();
			String s = (String)value;		
			System.out.println(s);
		}
	}
}
