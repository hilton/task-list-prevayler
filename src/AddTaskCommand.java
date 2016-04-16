import java.io.Serializable;
import java.util.Date;

import org.prevayler.Transaction;

/**
 * Prevayler command that adds a task to the task list.
 */
public class AddTaskCommand implements Serializable, Transaction<Tasks> {

  private static final long serialVersionUID = 1l;

  private final String summary;

  public AddTaskCommand(String summary) {
    this.summary = summary;
  }

  @Override
  public void executeOn(Tasks tasks, Date date) {
    tasks.add(summary);
  }
}
