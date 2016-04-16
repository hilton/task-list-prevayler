import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;

/**
 * Command-line task list application.
 */
public class TaskList {

  private final BufferedReader in;
  private final PrintWriter out;
  private final Prevayler<Tasks> prevayler;
  private final Tasks tasks;

  /**
   * Starts the application and initialises Prevayler.
   */
  public static void main(String[] args) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    try {
      Prevayler<Tasks> prevayler = PrevaylerFactory.createPrevayler(new Tasks());
      new TaskList(prevayler, in, out).run();
    }
    catch (Exception e) {
      out.println("Start-up error: " + e.getMessage());
    }
  }

  public TaskList(Prevayler<Tasks> prevayler, BufferedReader reader, PrintWriter writer) {
    this.prevayler = prevayler;
    this.tasks = prevayler.prevalentSystem();
    this.in = reader;
    this.out = writer;
  }

  public void run() {
    out.println("Task list - enter ‘help’ to list commands");
    while (true) {
      out.print("tasks> ");
      out.flush();
      String commandLine;
      try {
        commandLine = in.readLine();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      if (commandLine.equals("quit")) {
        break;
      }
      if (!commandLine.trim().isEmpty()) {
        execute(commandLine);
      }
    }
  }

  /**
   * Front-end for executing a command.
   */
  private void execute(String commandLine) {
    try {
      CommandParser parser = new CommandParser(prevayler, out);
      Command command = parser.parse(commandLine);
      command.execute();
    }
    catch (Exception e) {
      reportError(e.getMessage());
    }
  }

  private void reportError(String error) {
    out.println(error);
  }
}
