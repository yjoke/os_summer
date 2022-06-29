package top.xin1901.os.main;

import top.xin1901.os.file.CSCAN;
import top.xin1901.os.file.FCFS;
import top.xin1901.os.file.SCAN;
import top.xin1901.os.file.SSTF;
import top.xin1901.os.util.FileUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HeYunjia
 */
public class FMMain {
    public static void main(String[] args) {
        int min = 0;
        int max = 1024;
        int num = 10;

        int now = FileUtil.getRandomNum(min, max);
        List<Integer> list = FileUtil.getRandomList(min, max, num);
        System.out.println("当前位置: " + now);
        System.out.println("待访问地址为: " + list);
        System.out.println("排序后的顺序为: " + list.stream().sorted().collect(Collectors.toList()));

        System.out.println();
        FileUtil.print(new FCFS(now, list));
        System.out.println();
        FileUtil.print(new SSTF(now, list));
        System.out.print("\n正序 ");
        FileUtil.print(new SCAN(now, list, true));
        System.out.print("\n倒序 ");
        FileUtil.print(new SCAN(now, list, false));
        System.out.println();
        FileUtil.print(new CSCAN(now, list));

    }
}
