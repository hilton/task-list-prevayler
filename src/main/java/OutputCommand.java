import java.io.PrintWriter;

/**
 * A command that writes console output.
 */
public abstract class OutputCommand implements Command {

  protected final PrintWriter out;

  public OutputCommand(PrintWriter out) {this.out = out;}

  public abstract void execute();
}
