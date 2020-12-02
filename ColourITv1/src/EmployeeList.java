import java.io.Serializable;
import java.util.ArrayList;

public class EmployeeList implements Serializable
{
  private ArrayList<Employee> employees;

  public EmployeeList()
  {
    employees = new ArrayList<Employee>();
  }
}
