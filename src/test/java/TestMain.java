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
public class TestMain {

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


    public void testMM(MemoryManage mm) {
        List<Integer> list = MemoryManage.getList(0, 10240, 10);
        System.out.println(list);
        System.out.println(list.stream().map(integer -> integer / 1024).collect(Collectors.toList()));

        mm.setList(list);

        for (int i = 0; i < 50; i++) {
            mm.getNext().ifPresent(System.out::println);
        }
        System.out.println(mm.getClash());
    }

    @Test
    public void testLRU() {
        testMM(new LRU());
    }

    @Test
    public void testFIFO() {
        testMM(new FIFO());
    }
}
