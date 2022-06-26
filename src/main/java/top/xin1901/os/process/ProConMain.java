package top.xin1901.os.process;

/**
 * @author HeYunjia
 */
public class ProConMain {
    public static void main(String[] args) {
        Storage storage = Storage.getStorage(10);

        new Thread(() -> {while(true) Consumer.consumption(storage, 1000);}).start();

        new Thread(() -> {
            int i = 0;
            while (true) {
                Producer.production(new Product(i++), storage, 10000);
            }
        }).start();

    }
}
