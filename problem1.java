import java.util.Scanner;

public class yup {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 1001; i++){
			System.out.println("Number: " + i);
			System.out.println(answer(i));
		}
		
	}
	
	public static int answer(int n)
	{
		if(n == 0)
			return 2;
		
		String num = Integer.toString(n);
		
		for(int i = 2; i <= n+1; i++){
			String base = Integer.toString(Integer.parseInt(num, 10), i);
			
			String revBase = "";
			for(int j = base.length()-1 ; j >= 0; j--){
				revBase += base.charAt(j);
			}
			
			if(base.compareTo(revBase) == 0)
				return i;
		}
		
		return -1;
	}
	
}
