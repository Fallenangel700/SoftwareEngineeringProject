package scheduler;

public class Task
{
    private String taskName;

    public Task(String taskName)
    {
        this.taskName = taskName;
    }

    public String getTaskName()
    {
        return this.taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }
}