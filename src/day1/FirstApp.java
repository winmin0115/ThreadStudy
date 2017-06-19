package day1;

class Member {
	String name;
	Member(String name){
		this.name = name;
	}
	
	public String toString(){
		return "Member [name="+name+"]";
	}
}

public class FirstApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("main() start...");
		Thread.sleep(3000);
		Member m1 = new Member("½Â¹Î");
		System.out.println(m1.toString());
		Thread.sleep(3000);
		Member m2 = new Member("»óÇö");
		System.out.println(m2.toString());
		System.out.println("main() stop...");
	}

}
