import java.util.Scanner;

public class TestDate
{
  public static void main(String[] args)
  {
    /***
     * Input date program. Asks the user to enter a day, a month and a year.
     * If the user enters an invalid number for day or month, then the program
     * throws and exception and prompts the user to try again.
     */

    Date startDate = Date.today();
    Date deadline = new Date();                 // Create a new Date object
    int year, month, day;                   // Initialize year, month and day
    Scanner scan = new Scanner(System.in);  // Create a Scanner object
    boolean success = false;                // Flag variable for while loops


    while (!success)
    {
      /* The user enters a year value, which is assigned to the variable year and
      set as a field in the date object */
      System.out.print("Enter a year: ");
      year = scan.nextInt();
      deadline.setYear(year);

      /* The user enters a month value, which the program tries to assign to the
     variable year and to set it as a field of the date object. If the entered
     value is invalid, then the program throws an exception, and the while loop
     takes the user back to entering a value for month. If valid, the variable
     success is assigned to true, and the loop ends. */
      do
      {
        System.out.print("Enter a month: ");
        try
        {
          month = scan.nextInt();
          deadline.setMonth(month);
          success = true;
        }
        catch (IllegalDateException e)
        {
          System.out.println(e.getMessage());
        }
      }
      while (!success);

      // Set success again to false for the loop below.
      success = false;

      // Same as the previous loop, but for days.
      do
      {
        System.out.print("Enter a day: ");
        try
        {
          day = scan.nextInt();
          deadline.setDay(day);
          success = true;
        }
        catch (IllegalDateException e)
        {
          System.out.println(e.getMessage());
        }
      }
      while (!success);

      success = false;

      try
      {
        startDate.isBefore(deadline);
        success = true;
      }
      catch (IllegalDateException e)
      {
        System.out.println(e.getMessage());
      }
    }
  }
}
