/**
 * Command that doesn’t do anything, used to ignore empty input.
 */
class NullCommand implements Command {

  @Override
  public void execute() {
  }
}
