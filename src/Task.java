import java.io.Serializable;

/**
 * A task list entry.
 */
public class Task implements Serializable {

  private static final long serialVersionUID = 1l;

  private long id;
  private boolean done;
  private final String summary;

  public Task(long id, String summary) {
    this.id = id;
    this.summary = summary;
  }

  public long getId() {
    return id;
  }

  public void complete() {
    done = true;
  }

  @Override
  public String toString() {
    return String.format("#%d [%s] %s", id, done ? "x" : " ", summary);
  }
}
