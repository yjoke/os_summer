import org.junit.Test;
import top.xin1901.os.file.*;
import top.xin1901.os.util.FileUtil;

import java.util.*;

/**
 * @author HeYunjia
 */
public class TestFM {

    @Test
    public void testCSCAN() {
        testFM(new CSCAN());
    }

    @Test
    public void testSCAN() {
        testFM(new SCAN(false));
    }

    @Test
    public void testSSTF() {
        testFM(new SSTF());
    }

    @Test
    public void testFCFS() {
        testFM(new FCFS());
    }

    public void testFM(FileManage fm) {
        int min = 0;
        int max = 1024;
        int num = 10;

        int now = FileUtil.getRandomNum(min, max);
        List<Integer> randomList = FileUtil.getRandomList(min, max, num);
        System.out.println("当前位置: " + now);
        System.out.println("待访问地址为: " + randomList);

        fm.setNow(now);
        fm.setList(randomList);

        Collections.sort(randomList);
        System.out.println("排序后的顺序为: " + randomList);

        FileUtil.print(fm);
    }
}
