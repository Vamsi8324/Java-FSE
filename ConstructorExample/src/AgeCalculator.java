
import java.time.*;  
import java.util.*;  
public class AgeCalculator  
{    
public static void main(String args[])  
{  
System.out.println("Welcome to age calculator");
LocalDate dob = LocalDate.of(1991, 11, 02);  
 
LocalDate curDate = LocalDate.now();  
  
Period period = Period.between(dob, curDate);  
  
System.out.println("Date :"+dob);
System.out.printf("Your age is %d years %d months and %d days.", period.getYears(), period.getMonths(), period.getDays());  
}  
}  
