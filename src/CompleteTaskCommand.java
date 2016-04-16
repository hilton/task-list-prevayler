import java.io.Serializable;
import java.util.Date;

import org.prevayler.Transaction;

/**
 * Prevayler command that completes a task.
 */
public class CompleteTaskCommand implements Serializable, Transaction<Tasks> {

  private long id;

  public CompleteTaskCommand(long id) {
    this.id = id;
  }

  @Override
  public void executeOn(Tasks tasks, Date date) {
    tasks.list().stream().filter(task -> task.getId() == id).forEach(task -> task.complete());
  }
}
