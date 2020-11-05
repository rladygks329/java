// Exercise 10.8 Solution: Employee.java
// Employee abstract superclass.

public abstract class Employee implements Comparable<Employee>
{
   private String firstName;
   private String lastName;
   private String socialSecurityNumber;
   private Date birthDate;
   private Date firstDateOfWork;
   private Boolean covid19;
   private Date covid19Date;
   private int ssn;

   // six-argument constructor
   public Employee(String first, String last) {
	   firstName = first;
	   lastName = last;
	   socialSecurityNumber = "X";
	   covid19 = false;
	   ssn = 0;
   }
   public Employee( String first, String last, String ssn, 
      int month, int day, int year )
   {
      firstName = first;
      lastName = last;
      socialSecurityNumber = ssn;
      birthDate = new Date( month, day, year );
      covid19 = false;
      this.ssn = 0;
   } // end six-argument Employee constructor

   // set first name
   public void setFirstName( String first )
   {
      firstName = first;
   } // end method setFirstName

   // return first name
   public String getFirstName()
   {
      return firstName;
   } // end method getFirstName

   // set last name
   public void setLastName( String last )
   {
      lastName = last;
   } // end method setLastName

   // return last name
   public String getLastName()
   {
      return lastName;
   } // end method getLastName

   // set social security number
   public void setSocialSecurityNumber( String ssn )
   {
      socialSecurityNumber = ssn;  // should validate
   } // end method setSocialSecurityNumber

   // return social security number
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   } // end method getSocialSecurityNumber

   // set birth date
   public void setBirthDate( int month, int day, int year )
   {
      birthDate = new Date( month, day, year );
   } // end method setBirthDate

   // return birth date
   public Date getBirthDate()
   {
      return birthDate;
   } // end method getBirthDate
   public void setFirstDateOfWork( int month, int day, int year ) {
	   firstDateOfWork = new Date( month, day, year);
   }
   public Date getFirstDayOfWork() {
	   return firstDateOfWork;
   }
   public boolean getCovid19() {
	   return covid19;
   }
   public void setCovid19() {
	   covid19 = true;
   }
   public void setCovid19Date(int month, int day, int year) {
	   if(getCovid19()) {
		   covid19Date = new Date(month, day, year);
	   }
   }
   public Date getCovid19Date() {
	   return covid19Date;
   }
   public int getSsn() {
	   return ssn;
   }
   public void setSsn(int num) {
	   ssn = num;
   }
   // return String representation of Employee object
   @Override
   public String toString()
   {
      return String.format( "%s %s\n%s: %s\n%s: %s\n%s: %s,", 
         getFirstName(), getLastName(), 
         "social security number", getSocialSecurityNumber(), 
         "birth date", getBirthDate(),"firstDateOfWork",getFirstDayOfWork() );
   } // end method toString

   // abstract method overridden by subclasses
   public abstract double earnings();
   
   @Override
   public int compareTo(Employee other) {
	   int mySsn = getSsn();
	   int otherSsn = other.getSsn();
	   if(mySsn > otherSsn)
		   return 1;
	   else if(mySsn == otherSsn)
		   return 0;
	   else
		   return -1;
   }
} // end abstract class Employee

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