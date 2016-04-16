import java.io.Serializable;
import java.util.Date;

import org.prevayler.Transaction;

/**
 * Prevayler command that adds a task to the task list.
 */
public class AddTaskCommand implements Serializable, Transaction<Tasks> {

  private static final long serialVersionUID = 1l;

  private final String summary;

  public AddTaskCommand(String userInput) {
    this.summary = userInput.trim().substring(userInput.indexOf(" ") + 1);
  }

  @Override
  public void executeOn(Tasks tasks, Date date) {
    tasks.add(summary);
  }
}
