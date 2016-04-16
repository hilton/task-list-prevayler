import java.io.Serializable;

/**
 * A task list entry.
 */
class Task implements Serializable {

  private static final long serialVersionUID = 1l;

  private long id;
  private boolean done;
  private final String summary;

  Task(long id, String summary) {
    this.id = id;
    this.summary = summary;
  }

  long getId() {
    return id;
  }

  void complete() {
    done = true;
  }

  @Override
  public String toString() {
    return String.format("#%d [%s] %s", id, done ? "x" : " ", summary);
  }
}
