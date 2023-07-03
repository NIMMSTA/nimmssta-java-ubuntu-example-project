package demo.nimmsta.core;

public interface Command {
    boolean allowToExecute = false;
    void execute();
}
