import java.io.Serializable;

public class Task implements Serializable
{
  private String id, description, status, requirementId;
  private double totalHours, timeEstimate;
  private Date deadline;
  private Employee teamMember;

  // Constructors
  public Task(String requirementId, String id, String description, Date deadline)
  {
    this.requirementId = requirementId;
    this.id = id;
    this.description = description;
    this.deadline = deadline;
  }

  public Task()
  {

  }

  // Getters
  public String getId()
  {
    return id;
  }

  // toString
  public String toString()
  {
    String str = "-----------------------";
    return str + "\nRequirement id: " + requirementId + "\nTask id: " + id
        + "\nStatus: " + status + "\nDescription: "
        + description + "\nDeadline: " + deadline
        + "\nTeam Member: " + teamMember + "\nTotal Hours: " + totalHours
        + "\nTime Estimate: " + timeEstimate;
  }
}
