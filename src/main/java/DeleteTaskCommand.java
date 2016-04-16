import java.io.Serializable;
import java.util.Date;

import org.prevayler.Prevayler;

/**
 * Prevayler command that completes a task.
 */
class DeleteTaskCommand extends PrevaylerCommand implements Serializable {

  private static final long serialVersionUID = 1l;
  static final String COMMAND = "delete";

  private long id;

  DeleteTaskCommand(Prevayler prevayler, String commandLine) throws Exception {
    super(prevayler);
    if (!CompleteTaskCommand.valid(commandLine)) {
      throw new IllegalArgumentException("invalid complete command: " + commandLine);
    }
    String[] inputWords = commandLine.trim().split("\\s+");
    this.id = Long.valueOf(inputWords[1]);
  }

  @Override
  public void executeOn(Tasks tasks, Date date) {
    tasks.remove(id);
  }
}
