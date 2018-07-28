import java.util.HashSet;

public class Handler extends Thread{
    private Reader READER;
    private HashSet<Site> SITES;

    public Handler(Reader reader, HashSet<Site> sites){
        READER = reader;
        SITES = sites;
    }

    public void run(){
        synchronized (SITES){
            READER.read();
        }
    }
}
