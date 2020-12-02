import java.io.Serializable;
import java.util.ArrayList;

public class ProjectList implements Serializable
{
  ArrayList<Project> projects;

  public ProjectList()
  {
    projects = new ArrayList<Project>();
  }

  public void addProject(int index, Project project)
  {
    projects.add(index, project);
  }

  public void addProject(Project project)
  {
    projects.add(project);
  }

  public void removeProject(Project project)
  {
    projects.remove(project);
  }

  public int size()
  {
    return projects.size();
  }

  public Project getProject(int index)
  {
    if(index<projects.size())
    {
      return projects.get(index);
    }
    else
    {
      return null;
    }
  }
  public Project getProjectById(String id)
  {
    Project project = new Project();

    for (Project p : projects)
    {
      if (p.getId() != null && p.getId().equals(id))
      {
        project = p;
        break;
      }
    }
    return project;
  }

  public String toString()
  {
    String returnStr = "";

    for(int i = 0; i<projects.size(); i++)
    {
      returnStr += projects.get(i) +"\n";
    }
    return returnStr;
  }
}
