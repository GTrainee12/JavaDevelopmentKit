package Lecture1;

public class Server {

    boolean isServerWorking;
    private final Listener listener;
    public Server(Listener listener) {
        this.listener = listener;
        this.isServerWorking = false;
    }

    public void start() {
        if (!isServerWorking) {
            isServerWorking = true;
            listener.messageRes("Status server: " + isServerWorking);
        } else {
            listener.messageRes("Server is running");
        }

    }

    public void stop() {
        if (isServerWorking) {
            isServerWorking = false;
            listener.messageRes("Status server: " + isServerWorking);
        } else {
            listener.messageRes("The server is not running");
        }

    }
}
