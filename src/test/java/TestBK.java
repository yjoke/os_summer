import org.junit.Test;
import top.xin1901.os.device.Bank;
import top.xin1901.os.device.Process;
import top.xin1901.os.device.Vector;


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


}
