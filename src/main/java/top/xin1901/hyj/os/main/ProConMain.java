package top.xin1901.hyj.os.main;

import top.xin1901.hyj.os.process.Consumer;
import top.xin1901.hyj.os.process.Product;
import top.xin1901.hyj.os.process.Producer;
import top.xin1901.hyj.os.process.Storage;

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
