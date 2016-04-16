import java.util.Date;

import org.prevayler.Query;

public class TasksQuery implements Query<Tasks,Tasks> {

  @Override
  public Tasks query(Tasks tasks, Date executionTime) throws Exception {
    return tasks;
  }
}
