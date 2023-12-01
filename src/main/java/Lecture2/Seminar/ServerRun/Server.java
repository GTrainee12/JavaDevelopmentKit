package Lecture2.Seminar.ServerRun;

public class Server implements ServerListener {

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

    @Override
    public void serverListener (boolean status) {
        if (status){
            stop();
        } else {
            start();
        }

    }
}

