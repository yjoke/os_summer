import org.junit.Test;
import top.xin1901.hyj.os.memory.FIFO;
import top.xin1901.hyj.os.memory.LRU;
import top.xin1901.hyj.os.memory.MemoryManage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HeYunjia
 */
public class TestMM {

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
