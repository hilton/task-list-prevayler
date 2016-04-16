import java.io.PrintWriter;

import org.prevayler.Prevayler;

/**
 * A command that displays the task list.
 */
class ShowCommand extends OutputCommand {

  static final String COMMAND = "show";

  private Prevayler prevayler;

  ShowCommand(Prevayler prevayler, PrintWriter out) {
    super(out);
    this.prevayler = prevayler;
  }

  @Override
  public void execute() {
    try {
      // TODO Figure out why the cast is necessary here but not in the Prevayler examples.
      Tasks tasks = (Tasks) prevayler.execute(new TasksQuery());
      tasks.list().forEach(task -> out.println(task));
    }
    catch (Exception e) {
      out.println("Error - could not show tasks: " + e.getMessage());
    }
  }
}
