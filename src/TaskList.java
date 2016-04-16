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
    while (true) {
      out.print("tasks> ");
      out.flush();
      String userInput;
      try {
        userInput = in.readLine();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      if (userInput.equals("quit")) {
        break;
      }
      if (!userInput.trim().isEmpty()) {
        execute(userInput);
      }
    }
  }

  /**
   * Front-end for executing a command.
   */
  private void execute(String userInput) {
    String[] inputWords = userInput.trim().split("\\s+");
    if (inputWords.length == 0) {
      return;
    }
    String command = inputWords[0];
    switch (command) {
    case "show":
      show();
      break;
    case "add":
      String summary = userInput.trim().substring(command.length() + 1);
      prevayler.execute(new AddTaskCommand(summary));
      break;
    case "complete":
      Long taskId = Long.valueOf(inputWords[1]);
      prevayler.execute(new CompleteTaskCommand(taskId));
      break;
    default:
      reportError(command);
      break;
    }
  }

  /**
   * Displays the task list.
   */
  private void show() {
    tasks.list().forEach(task -> out.println(task));
  }

  private void reportError(String command) {
    out.printf("Unknown command: %s%n", command);
  }
}
