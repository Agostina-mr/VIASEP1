import java.io.Serializable;

public class Project implements Serializable
{
  private String id, title, description;
  private RequirementList requirements;

  public Project(String id, String title, String description)
  {
    this.id = id;
    this.title = title;
    this.description = description;
    requirements = new RequirementList();
  }
  public Project(String id)
  {
    this.id = id;
    requirements = new RequirementList();
  }

  public Project()
  {
    requirements = new RequirementList();
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }


  public String getId()
  {
    return id;
  }

  public String getTitle()
  {
    return title;
  }


  public RequirementList getRequirements()
  {
    return requirements;
  }

  public void setRequirements(RequirementList requirements)
  {
    this.requirements = requirements;
  }

  public String getDescription()
  {
    return description;
  }

  public String toString()
  {
    String str = "-----------------------";
    return str + "\nProject id: " + id + "\nTitle: " + title + "\nDescription: " +
        description;
  }
}
