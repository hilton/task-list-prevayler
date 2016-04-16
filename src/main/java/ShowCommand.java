import java.io.PrintWriter;

/**
 * A command that displays the task list.
 */
public class ShowCommand extends OutputCommand {

  public static final String COMMAND = "show";

  private Tasks tasks;

  public ShowCommand(PrintWriter out, Tasks tasks) {
    super(out);
    this.tasks = tasks;
  }

  @Override
  public void execute() {
    tasks.list().forEach(task -> out.println(task));
  }
}
