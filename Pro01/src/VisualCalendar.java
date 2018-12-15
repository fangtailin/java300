import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/***
 * ���ӻ���������
 * 
 * @author Administrator
 *
 */
public class VisualCalendar {
	public static void main(String[] args) {

		System.out.println("������Ҫ����(���ո�ʽ2030-1-21)��");
		Scanner scanner=new Scanner(System.in);
		String inputStr= scanner.nextLine();
		
		//String temp = "2030-1-21";
		String temp=inputStr;

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = format.parse(temp);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);

			int day=calendar.get(Calendar.DATE);
			
			calendar.set(Calendar.DATE, 1);
			// System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
			// System.out.println(calendar.getActualMaximum(Calendar.DATE));

			int maxDate = calendar.getActualMaximum(Calendar.DATE);
			int tempdayofweek = calendar.get(Calendar.DAY_OF_WEEK);

			System.out.println("��\tһ\t��\t��\t��\t��\t��");

			for (int i = 1; i < tempdayofweek; i++) {
				System.out.print('\t');
			}

			for (int i = 1; i <= maxDate; i++) {

				if(i==day) {
					System.out.print("*");
				}
				System.out.print(i + "\t");

				int w = calendar.get(Calendar.DAY_OF_WEEK);
				if (w == Calendar.SATURDAY) {
					System.out.print("\n");
				}

				calendar.add(Calendar.DATE, 1);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
