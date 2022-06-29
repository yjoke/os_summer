import org.junit.Test;
import top.xin1901.os.file.FCFS;
import top.xin1901.os.file.FileManage;
import top.xin1901.os.util.FileUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HeYunjia
 */
public class TestFM {

    public void testFM(FileManage fm) {
        int min = 0;
        int max = 1024;
        int num = 10;

        List<Integer> randomList = FileUtil.getRandomList(min, max, num);
        System.out.println("待访问地址为: " + randomList);

        fm.setNow((int) (Math.random() * (max - min) + min));
        fm.setList(randomList);

        List<Integer> res = new LinkedList<>();
        while (fm.hasNext()) {
            res.add(fm.next());
        }

        String[] method = fm.getClass().toString().split("\\.");
        System.out.println(method[method.length - 1] + " 访问顺序为: " + res);
    }

    @Test
    public void testFCFS() {
        testFM(new FCFS());
    }
}
