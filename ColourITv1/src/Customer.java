import java.io.Serializable;

public class Customer implements Serializable
{
  private String name;

  public Customer(String name)
  {
    this.name = name;
  }
}
