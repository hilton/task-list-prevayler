import java.io.PrintWriter;

import org.prevayler.Prevayler;

/**
 * Parses a command from user input.
 */
class CommandParser {

  private final Prevayler<Tasks> prevayler;
  private final PrintWriter out;

  CommandParser(Prevayler<Tasks> prevayler, PrintWriter out) {
    this.prevayler = prevayler;
    this.out = out;
  }

  Command parse(String commandLine) throws Exception {
    if (commandLine == null) {
      throw new IllegalArgumentException("null command line");
    }
    String[] words = commandLine.trim().split("\\s+");
    if (words.length == 0) {
      return new NullCommand();
    }
    
    String command = words[0];
    switch (command) {
    case HelpCommand.COMMAND:
      return new HelpCommand(out);
    case ShowCommand.COMMAND:
      return new ShowCommand(out, prevayler.prevalentSystem());
    case AddTaskCommand.COMMAND:
      return new AddTaskCommand(prevayler, commandLine);
    case CompleteTaskCommand.COMMAND:
      return new CompleteTaskCommand(prevayler, commandLine);
    case DeleteTaskCommand.COMMAND:
      return new DeleteTaskCommand(prevayler, commandLine);
    default:
      throw new IllegalArgumentException("Unknown command: " + command);
    }
  }
}
