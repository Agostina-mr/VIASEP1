import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable
{
  private ArrayList<Task> tasks;

  public TaskList()
  {
    tasks = new ArrayList<Task>();
  }

  public void addTask(Task task)
  {
    tasks.add(task);
  }

  public void removeTask(Task task)
  {
    tasks.remove(task);
  }

  public int size()
  {
    return tasks.size();
  }
  public Task getTaskById(String id)
  {
    Task task = new Task();

    for (Task t : tasks)
    {
      if (t.getId() != null && t.getId().equals(id))
      {
        task = t;
        break;
      }
    }
    return task;
  }

  public Task getTask(int index)
  {
    if(index < tasks.size())
    {
      return tasks.get(index);
    }
    else
    {
      return null;
    }
  }
}
