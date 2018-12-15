
import java.util.Scanner;

/**
 * ≤‚ ‘ªÒµ√º¸≈Ã ‰»Î
 * 
 * @author Administrator
 *
 */
public class TestScanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Name:");
		String name = scanner.nextLine();
		System.out.println("Enter Hobby:");
		String hobby = scanner.nextLine();
		
		System.out.println(name);
		System.out.println(hobby);
	}
}
