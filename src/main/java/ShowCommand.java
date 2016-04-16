import java.io.PrintWriter;

/**
 * A command that displays the task list.
 */
class ShowCommand extends OutputCommand {

  static final String COMMAND = "show";

  private Tasks tasks;

  ShowCommand(PrintWriter out, Tasks tasks) {
    super(out);
    this.tasks = tasks;
  }

  @Override
  public void execute() {
    tasks.list().forEach(task -> out.println(task));
  }
}
