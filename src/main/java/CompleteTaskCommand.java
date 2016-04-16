import java.io.Serializable;
import java.util.Date;

import org.prevayler.Prevayler;

/**
 * Prevayler command that completes a task.
 */
public class CompleteTaskCommand extends PrevaylerCommand implements Serializable {

  private static final long serialVersionUID = 1l;
  public static final String COMMAND = "complete";

  private long id;

  public CompleteTaskCommand(Prevayler prevayler, String commandLine) throws Exception {
    super(prevayler);
    if (!valid(commandLine)) {
      throw new IllegalArgumentException("Invalid task ID in command: " + commandLine);
    }
    String[] inputWords = commandLine.trim().split("\\s+");
    this.id = Long.valueOf(inputWords[1]);
  }

  @Override
  public void executeOn(Tasks tasks, Date date) {
    tasks.list().stream().filter(task -> task.getId() == id).forEach(task -> task.complete());
  }

  static boolean valid(String commandLine) {
    String[] inputWords = commandLine.trim().split("\\s+");
    try {
      Long.valueOf(inputWords[1]);
      return true;
    }
    catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
      return false;
    }
  }
}
