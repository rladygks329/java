import java.util.Random;
public class Hw3 {
	public static void main(String[] args )
	{	
		for(int i=100;i<1000000; i*=10) {
			int problemsize = i;
			SortArray sortArray = new SortArray<Employee>();
			Employee[] Employees;
			Employees = MakeEmployees(problemsize);
			//mix
			for(int j=0;j<problemsize/2;j++) {
				Random rnd = new Random();
				int a = (int)(rnd.nextInt(problemsize));
				sortArray.swap(Employees,j,a);
			}
			long startTime = System.currentTimeMillis();
			sortArray.quickSort(Employees,0,problemsize-1);
			//sortArray.selectionSort(Employees, problemsize);
			long endTime = System.currentTimeMillis();
			long elaspedTime = endTime - startTime;
			System.out.println("quicksort "+"problemsize = "+problemsize +" time "+elaspedTime);
		}
	}
	private static Employee[] MakeEmployees(int num) {
		Employee[] Employees = new Employee[num];
		for(int i =0; i<num;i++) {
			Random rnd = new Random();
			StringBuffer temp = new StringBuffer();
			for(int j =0;j<4;j++) {
				temp.append((char)((int)rnd.nextInt(26)+65));
			}
			String randomStr = temp.toString();
			String randomStr2 = String.valueOf((char) ((int) (rnd.nextInt(26)) + 65));
			String randomStr3 = String.valueOf((char) ((int) (rnd.nextInt(26)) + 65));
			Employees[i] = new SalariedEmployee( 
			         randomStr,randomStr2, randomStr3, 1, 1, 1001, 800.00 );
			Employees[i].setSsn(i);
		}
		return Employees;
	}
}

