import java.io.Serializable;
import java.util.Date;

import org.prevayler.Transaction;

/**
 * Prevayler command that completes a task.
 */
public class CompleteTaskCommand implements Serializable, Transaction<Tasks> {

  private static final long serialVersionUID = 1l;

  private long id;

  public CompleteTaskCommand(String userInput) throws Exception {
    String[] inputWords = userInput.trim().split("\\s+");
    if (inputWords.length < 2) {
      throw new Exception("Invalid command: " + userInput);
    }
    this.id = Long.valueOf(inputWords[1]);
  }

  @Override
  public void executeOn(Tasks tasks, Date date) {
    tasks.list().stream().filter(task -> task.getId() == id).forEach(task -> task.complete());
  }
}
