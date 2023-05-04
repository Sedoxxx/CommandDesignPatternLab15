// Mohamed Aymen Daassi CS-04
// m.daassi@innopolis.university
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SmartLock lock = new SmartLock();
        Command lockDoorCommand = new LockDoorCommand(lock);
        Command unlockDoorCommand = new UnlockDoorCommand(lock);
        lock.setCommand(lockDoorCommand);
        lock.trigger();
        lock.setCommand(unlockDoorCommand);
        lock.trigger();

    }
}

interface Command {
    public void execute();
}

class LockDoorCommand implements Command {
    private SmartLock lock;

    public LockDoorCommand(SmartLock lock) {
        this.lock = lock;
    }

    public void execute() {
        lock.lock();
    }
}
class UnlockDoorCommand implements Command {
    private SmartLock lock;

    public UnlockDoorCommand(SmartLock lock) {
        this.lock = lock;
    }

    public void execute() {
        lock.unlock();
    }
}

interface Device {
    public void setCommand(Command command);
    public void trigger();
}
class SmartLock implements Device {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void trigger() {
        command.execute();
    }

    public void lock() {
        System.out.println("It's locked");
    }

    public void unlock() {
        System.out.println("It's unlocked");
    }
}
