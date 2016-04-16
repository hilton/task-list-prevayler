import java.io.Serializable;
import java.util.Date;
import org.prevayler.Prevayler;

/**
 * Prevayler command that adds a task to the task list.
 */
class AddTaskCommand extends PrevaylerCommand implements Serializable {

  private static final long serialVersionUID = 1l;
  static final String COMMAND = "add";

  private final String summary;

  AddTaskCommand(Prevayler prevayler, String commandLine) {
    super(prevayler);
    if (!valid(commandLine)) {
      throw new IllegalArgumentException("invalid add command: " + commandLine);
    }
    this.summary = commandLine.trim().substring(commandLine.indexOf(" ") + 1);
  }

  @Override
  public void executeOn(Tasks tasks, Date date) {
    tasks.add(summary);
  }

  private static boolean valid(String commandLine) {
    return commandLine.trim().startsWith(COMMAND) &&
      !commandLine.trim().substring(2).trim().isEmpty();
  }
}
