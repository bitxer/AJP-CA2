import java.util.concurrent.BlockingQueue;

public class Handler extends Thread{
    private Reader READER;
    private BlockingQueue<String> SITES;

    public Handler(Reader reader, BlockingQueue<String> sites){
        READER = reader;
        SITES = sites;
    }

    public void run(){
        int counter = 0;
        for (String i : READER.read()){
            counter += 1;
            try {
                SITES.put(i);
                if (counter == 12){
                    return;
                }
                sleep(10);
            } catch (InterruptedException e) {
                return;
            }

        }
    }
}
