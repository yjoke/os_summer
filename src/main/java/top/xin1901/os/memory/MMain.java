package top.xin1901.os.memory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HeYunjia
 */
public class MMain {
    public static void main(String[] args) {
        int minAdd = 0;
        int maxAdd = 10240;
        int num = 20;

        List<Integer> list = MemoryManage.getList(minAdd, maxAdd, num);

        System.out.println("指令流: " + list);
        System.out.println("对应的页表: " + list.stream().map(i -> i / 1024).collect(Collectors.toList()));

        System.out.print("FIFO ");
        new FIFO(list).printAll();

        System.out.print("\nLRU ");
        new LRU(list).printAll();

    }
}
