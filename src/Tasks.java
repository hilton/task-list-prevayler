import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * An ordered task list.
 */
public class Tasks implements Serializable {

  private final List<String> tasks = new ArrayList<>();

  public void add(String summary) {
    tasks.add(summary);
  }

  public List<String> list() {
    return tasks;
  }
}
