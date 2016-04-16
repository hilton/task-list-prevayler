import java.util.Date;

import org.prevayler.Prevayler;
import org.prevayler.Transaction;

/**
 * A command that executes a Prevayler command.
 */
abstract class PrevaylerCommand implements Command, Transaction<Tasks> {

  private static final long serialVersionUID = 1l;

  protected transient final Prevayler prevayler;

  PrevaylerCommand(Prevayler prevayler) {
    this.prevayler = prevayler;
  }

  public void execute() {
    prevayler.execute(this);
  }

  public abstract void executeOn(Tasks prevalentSystem, Date executionTime);
}
