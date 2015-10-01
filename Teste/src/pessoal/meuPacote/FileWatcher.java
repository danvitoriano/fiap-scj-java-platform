package pessoal.meuPacote;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import javax.swing.RowFilter.Entry;

public class FileWatcher {

    private WatchService watchService;

    private void init() {
        Path path = Paths.get("temp");

        try {
            watchService = FileSystems.getDefault().newWatchService();
            path.register(watchService,  StandardWatchEventKinds.ENTRY_CREATE);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
    
    //...

    private void doRounds() {
        WatchKey key = null;

        while (true) {
            try {
                key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    System.out.println("Event on " + event.context().toString() + " is " + kind);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException: " + e.getMessage());
            }

            boolean reset = key.reset();

            if (!reset) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        FileWatcher m = new FileWatcher();
        m.init();
        m.doRounds();
    }
}