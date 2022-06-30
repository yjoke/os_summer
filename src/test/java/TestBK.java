import org.junit.Test;
import top.xin1901.os.device.Bank;
import top.xin1901.os.device.Process;
import top.xin1901.os.device.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author HeYunjia
 */
public class TestBK {

    @Test
    public void test1() {
        Vector vector = new Vector();
        System.out.println(vector);
    }

    @Test
    public void test2() {
        Bank bank = new Bank(new Vector(10, 5, 7));

        Process p0 = new Process(0, new Vector(7, 5, 3));
        Process p1 = new Process(1, new Vector(3, 3, 2));
        Process p2 = new Process(2, new Vector(9, 0, 2));
        Process p3 = new Process(3, new Vector(2, 2, 2));
        Process p4 = new Process(4, new Vector(4, 3, 3));

        System.out.println("银行添加进程: ");
        System.out.println(bank.addProcess(p0));
        System.out.println(bank.addProcess(p1));
        System.out.println(bank.addProcess(p2));
        System.out.println(bank.addProcess(p3));
        System.out.println(bank.addProcess(p4));

        System.out.println(bank);

        System.out.println("进程请求资源: ");
        System.out.println(p0.apply(bank, new Vector(0, 1, 0)));
        System.out.println(p1.apply(bank, new Vector(2, 0, 0)));
        System.out.println(p2.apply(bank, new Vector(3, 0, 2)));
        System.out.println(p3.apply(bank, new Vector(2, 1, 1)));
        System.out.println(p4.apply(bank, new Vector(0, 0, 2)));


    }

    @Test
    public void test3() {
        // 建立一个银行
        Bank bank = new Bank(new Vector(10, 5, 7));

        // 进程的最大资源需求
        Vector[] max = new Vector[] {
                new Vector(7, 5, 3),
                new Vector(3, 2, 2),
                new Vector(9, 0, 2),
                new Vector(2, 2, 2),
                new Vector(4, 3, 3),
        };

        // 创建进程
        List<Process> processes = new ArrayList<>();
        for (int i = 0; i < max.length; i++) {
            processes.add(new Process(i, max[i]));
        }

        // 将进程添加入银行管理
        for (Process process : processes) {
            bank.addProcess(process);
        }

        // 请求资源
        Vector[] requests = new Vector[] {
                new Vector(0, 1, 0),
                new Vector(2, 0, 0),
                new Vector(3, 0, 2),
                new Vector(2, 1, 1),
                new Vector(0, 0, 2),
        };

        System.out.println(bank.allot(processes, Arrays.asList(requests)));

        // 进程 1 发起请求 1 0 2
        System.out.println(processes.get(1).apply(bank, new Vector(1, 0, 2)));

        // 进程 4 请求 3 3 0
        System.out.println(processes.get(4).apply(bank, new Vector(3, 3, 0)));

        // 进程 0 请求 0 2 0
        System.out.println(processes.get(0).apply(bank, new Vector(0, 2, 0)));

        // 进程 0 请求 0 1 0
        System.out.println(processes.get(0).apply(bank, new Vector(0, 1, 0)));


    }
}
