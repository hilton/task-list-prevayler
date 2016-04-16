import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * An ordered task list.
 */
public class Tasks implements Serializable {

  private static final long serialVersionUID = 1l;

  private final List<Task> tasks = new ArrayList<>();
  private long nextId = 1L;

  public void add(String summary) {
    tasks.add(new Task(nextId, summary));
    nextId++;
  }

  public List<Task> list() {
    return tasks;
  }

  public void remove(long id) {
    tasks.stream().filter(task -> task.getId() == id).findFirst().ifPresent(task -> tasks.remove(task));
  }
}
