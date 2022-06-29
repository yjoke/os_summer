import com.sun.javaws.IconUtil;
import org.junit.Test;
import top.xin1901.os.memory.FIFO;
import top.xin1901.os.memory.LRU;
import top.xin1901.os.memory.MemoryManage;
import top.xin1901.os.process.Consumer;
import top.xin1901.os.process.Producer;
import top.xin1901.os.process.Product;
import top.xin1901.os.process.Storage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HeYunjia
 */
public class TestPV {

    @Test
    public void testPV() {
//        Storage storage = Storage.getStorage(10);
//
//        new Thread(() -> {
//            int i = 0;
//            while (true) {
//                try {
//                    Producer.production(new Product(i++), storage);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (true) {
//                try {
//                    Consumer.consumption(storage);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }

}
