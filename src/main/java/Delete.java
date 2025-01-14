import java.io.IOException;

public class Delete extends Command{
    private Tasks tasks;
    private Task task;
    private Ui ui;
    private Storage storage;

    /**
     * Constructor for command for user to delete a task from the list.
     * @param tasks list of all existing tasks
     * @param index index of task to be deleted
     * @param ui Handles interaction with user.
     * @param storage updates "data/duke.txt" file
     */
    public Delete(Tasks tasks, int index, Ui ui, Storage storage) {
        this.tasks = tasks;
        this.task = tasks.get(index);
        this.ui = ui;
        this.storage = storage;
    }

    public void execute() throws IOException {
        ui.delete(task, tasks);
        tasks.delete(task);
        storage.writeToFile(tasks);
    }
}
