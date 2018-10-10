class test
{
	public static void main(String[] args) {
		String a = "abcdefghijkl";

		int index =2;
		a = a.substring(0, index) + a.substring(index+1);
		System.out.println(a);
	}
}