// Exercise 10.8 Solution: PayrollSystemTest.java
// Employee hierarchy test program.
import java.util.Scanner; // program uses Scanner to obtain user input

public class PayrollSystemTest 
{
   public static void main(String[] args )
   {
      // create subclass objects
      SalariedEmployee salariedEmployee = 
         new SalariedEmployee( 
         "John", "Smith", "111-11-1111", 6, 15, 1944, 800.00 );
      salariedEmployee.setFirstDateOfWork(5, 12, 1955);
      salariedEmployee.setCovid19();
      salariedEmployee.setCovid19Date(3, 12, 2001);
      
      HourlyEmployee hourlyEmployee = 
         new HourlyEmployee( 
         "Karen", "Price", "222-22-2222", 12, 29, 1960, 16.75, 40 );
      hourlyEmployee.setFirstDateOfWork(4, 25, 1965);
      hourlyEmployee.setCovid19();
      hourlyEmployee.setCovid19Date(7, 12, 2005);
      
      CommissionEmployee commissionEmployee = 
         new CommissionEmployee( 
         "Sue", "Jones", "333-33-3333", 9, 8, 1954, 10000, .06 );
      commissionEmployee.setFirstDateOfWork(7, 7, 1975);
      commissionEmployee.setCovid19();
      commissionEmployee.setCovid19Date(3, 13, 2002);
      
      BasePlusCommissionEmployee basePlusCommissionEmployee = 
         new BasePlusCommissionEmployee( 
         "Bob", "Lewis", "444-44-4444", 3, 2, 1965, 5000, .04, 300 );
      basePlusCommissionEmployee.setFirstDateOfWork(12, 16, 1985);
      
      SalariedEmployee salariedEmployee2 = 
    		  new SalariedEmployee(
    	 "Kiin","Kim","555-55-5555",7,22,1954, 700.00);
      salariedEmployee2.setFirstDateOfWork(12,4,1993);
      
      HourlyEmployee hourlyEmployee2 = 
    		  new HourlyEmployee(
    	 "Spirit", "Lee","666-66-6666",8,15,1977,15.00,30);
      hourlyEmployee2.setFirstDateOfWork(1,3,1980);
      
      CommissionEmployee commissionEmployee2 = 
    		  new CommissionEmployee(
    	 "Rumble","Ru","777-77-7777",3,23,1980,80000, 0.6);
      commissionEmployee2.setFirstDateOfWork(5,5,1990);
      
      BasePlusCommissionEmployee basePlusCommissionEmployee2 =
    		  new BasePlusCommissionEmployee(
    	 "Mystic","Candle","888-88-8888",7,29,1994, 5500,.04,300);
      basePlusCommissionEmployee2.setFirstDateOfWork(1,7,2009);
      
      SalariedEmployee salariedEmployee3 = 
    		  new SalariedEmployee(
    	 "Rascal","Tamur","999-99-9999",8,16,1957, 660.00);
      salariedEmployee3.setFirstDateOfWork(3,3,1975);
      
      SalariedEmployee salariedEmployee4 = 
    		  new SalariedEmployee(
    	 "Bdd","Bob","123-45-6789",2,27,1984, 650.00);
      salariedEmployee4.setFirstDateOfWork(3,7,1974);
      
      System.out.println( "Employees processed individually:\n" );
      
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
         salariedEmployee, "earned", salariedEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         hourlyEmployee, "earned", hourlyEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         commissionEmployee, "earned", commissionEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
         basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
    	 salariedEmployee2, "earned", salariedEmployee2.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
    	 hourlyEmployee2, "earned", hourlyEmployee2.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
    	 commissionEmployee2, "earned", commissionEmployee2.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
    	 basePlusCommissionEmployee2,"earned", basePlusCommissionEmployee2.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
    	 salariedEmployee3, "earned", salariedEmployee3.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
    	 salariedEmployee4, "earned", salariedEmployee4.earnings() );
      
      // create Ten element Employee array
      Employee[] employees = new Employee[ 10 ]; 

      // initialize array with Employees
      employees[ 0 ] = salariedEmployee;
      employees[ 1 ] = hourlyEmployee;
      employees[ 2 ] = commissionEmployee; 
      employees[ 3 ] = basePlusCommissionEmployee;
      employees[ 4 ] = salariedEmployee2;
      employees[ 5 ] = hourlyEmployee2;
      employees[ 6 ] = commissionEmployee2; 
      employees[ 7 ] = basePlusCommissionEmployee2;
      employees[ 8 ] = salariedEmployee3;
      employees[ 9 ] = salariedEmployee4;
      
      //create bag and add employee in bag
      BagInterface<Employee> arrayBag = new ArrayBag<>();
      BagInterface<Employee> linkedBag = new LinkedBag<>();
      for(int index = 0;index<employees.length;index ++) {
    	  arrayBag.add(employees[index]);
    	  //linkedBag.add(employees[index]);
      }
    
      Scanner input = new Scanner( System.in ); // to get current month
      int currentMonth;
      int currentYear;

      // get and validate current month
      do
      {
         System.out.print( "Enter the current month (1 - 12): " );
         currentMonth = input.nextInt();
         System.out.println();
      } while ( ( currentMonth < 1 ) || ( currentMonth > 12 ) );
      do
      {
         System.out.print( "Enter the current year : " );
         currentYear = input.nextInt();
         System.out.println();
      } while ( currentYear < 0 );

      System.out.println( "Employees processed polymorphically:\n" );
      
      
      //if we use ArrayBag
      System.out.println("----------currentMonth------------");
      
     Employee tempEmployee = null;
	  int arrayBagSize = arrayBag.getCurrentSize();
	  int linkedBagSize = linkedBag.getCurrentSize();
	  
	  //current covid19
	  int covid19 = 0;
	  arrayBagSize = arrayBag.getCurrentSize();
	  for(int index = 0; index < arrayBagSize; index++) {
    	  tempEmployee = arrayBag.remove();
    	  if(tempEmployee.getCovid19()) {
    		  covid19 += 1;
    	  }
    	  linkedBag.add(tempEmployee);
      }
	  System.out.println("Current covid19 Infestor = "+covid19);
	  
	  //20200401 covid19
	  int InfestorBefore20200401 = 0;
	  linkedBagSize = linkedBag.getCurrentSize();
      for(int index = 0; index < linkedBagSize; index++) {
    	  //System.out.println("success ");
    	  tempEmployee = linkedBag.remove();
    	  if(tempEmployee.getCovid19()) {
    		  if(tempEmployee.getCovid19Date().getYear() <= 2020) {
        		  if(tempEmployee.getCovid19Date().getMonth() < 4) {
        			  InfestorBefore20200401 += 1;
        		  }
        	  }
    	  }
    	  arrayBag.add(tempEmployee);
      }
      System.out.println("Before20200401 covid19 Infestor = "+InfestorBefore20200401);
	  
      //
	  arrayBagSize = arrayBag.getCurrentSize();
      for(int index = 0; index < arrayBagSize; index++) {
    	  tempEmployee = arrayBag.remove(); 
    	  calculateMoney(tempEmployee, currentMonth,currentYear);
    	  linkedBag.add(tempEmployee);
      }
      
      //nextMonth
      if(currentMonth+1 == 13) {
    	  currentMonth =1;
      }
      else {
    	  currentMonth +=1;
      }
      
      System.out.println("----------nextMonth------------");
      System.out.println("NextMonth = "+currentMonth);
	  linkedBagSize = linkedBag.getCurrentSize();
      for(int index = 0; index < linkedBagSize; index++) {
    	  tempEmployee = linkedBag.remove(); 
    	  calculateMoney(tempEmployee, currentMonth,currentYear);
    	  arrayBag.add(tempEmployee);
      }
      //using LinkedBag
      //System.out.println("-----------Using LinkedBag-----------");
      //CalculateLinkedBag(linkedBag, currentMonth, currentYear);

      // get type name of each object in employees array
      for ( int j = 0; j < employees.length; j++ )
         System.out.printf( "Employee %d is a %s\n", j, 
            employees[ j ].getClass().getName() ); 
   } // end main
   private static void calculateMoney(Employee currentEmployee, int currentMonth, int currentYear) {
	   System.out.println( currentEmployee ); // invokes toString
       if( currentYear - currentEmployee.getFirstDayOfWork().getYear() > 10 ) {
	         // determine whether element is a BasePlusCommissionEmployee
	         if ( currentEmployee instanceof BasePlusCommissionEmployee ) 
	         {
	            // downcast Employee reference to 
	            // BasePlusCommissionEmployee reference
	            BasePlusCommissionEmployee employee = 
	               ( BasePlusCommissionEmployee ) currentEmployee;
	
	            double oldBaseSalary = employee.getBaseSalary();
	            employee.setBaseSalary( 1.10 * oldBaseSalary );
	            System.out.printf( 
	               "new base salary with 10%% increase is: $%,.2f\n",
	               employee.getBaseSalary() );
	         }
	         // end if
	         if( currentEmployee instanceof SalariedEmployee) {
	        	 SalariedEmployee employee = (SalariedEmployee) currentEmployee;
	        	 double oldSalary = employee.getWeeklySalary();
	        	 employee.setWeeklySalary( 1.1 * oldSalary );
	        	 System.out.printf(
	        			 "new slaried with 10%% increase is: $%,.2f\n",
	        			 employee.getWeeklySalary());
	         }
	         if( currentEmployee instanceof HourlyEmployee ) {
	        	 HourlyEmployee employee = (HourlyEmployee) currentEmployee;
	        	 double oldHourly = employee.getWage();
	        	 employee.setWage(1.1 * oldHourly);
	        	 System.out.printf(
	        			 "new hourly wage with 10%% increase is :$%,.2f\n",
	        			 employee.getWage());
	         }
	         if( currentEmployee instanceof CommissionEmployee ) {
	        	 CommissionEmployee employee = (CommissionEmployee) currentEmployee;
	        	 double oldCommision = employee.getGrossSales();
	        	 employee.setGrossSales(1.1 * oldCommision);
	        	 System.out.printf(
	        			 "new Commission salary with 10%% increase is: $%,.2f\n",
	        			 employee.getGrossSales());
	         }
       }

       // if month of employee's birthday, add $100 to salary
       if ( currentMonth == currentEmployee.getBirthDate().getMonth() )
          System.out.printf(
             "earned $%,.2f %s\n\n", currentEmployee.earnings(), 
             "plus $100.00 birthday bonus" );
       else
          System.out.printf( 
             "earned $%,.2f\n\n", currentEmployee.earnings() );
    }//end CalculateMoney
   
} // end class PayrollSystemTest

/**************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
