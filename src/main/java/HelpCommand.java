import java.io.PrintWriter;

/**
 * A command that displays the command help.
 */
class HelpCommand extends OutputCommand {

  static final String COMMAND = "help";

  HelpCommand(PrintWriter out) {
    super(out);
  }

  @Override
  public void execute() {
    out.println("Commands:");
    out.println("  show");
    out.println("  add <task summary>");
    out.println("  complete <task ID>");
    out.println("  delete <task ID>");
    out.println("  quit");
    out.println();
  }
}
