import java.io.PrintWriter;

/**
 * A command that writes console output.
 */
abstract class OutputCommand implements Command {

  protected final PrintWriter out;

  OutputCommand(PrintWriter out) {this.out = out;}

  public abstract void execute();
}
