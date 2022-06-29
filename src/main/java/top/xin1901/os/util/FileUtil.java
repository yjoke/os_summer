package top.xin1901.os.util;

import top.xin1901.os.file.FileManage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HeYunjia
 */
public class FileUtil {

    /**
     * 传入一个配置好的 FileManage, 迭代打印扫描过程
     * @param fm FileManage
     */
    public static void print(FileManage fm) {
        List<Integer> res = new LinkedList<>();
        while (fm.hasNext()) {
            res.add(fm.next());
        }

        String[] method = fm.getClass().toString().split("\\.");
        System.out.println(method[method.length - 1] + " 访问顺序为: " + res);
        System.out.println(method[method.length - 1] + " 移动总长度: " + fm.getSum());
        System.out.println(method[method.length - 1] + " 平均移动次数: " + fm.getAvg());
    }

    /**
     * 获取一个长度为 num 的随机序列, 范围为 [min, max)
     * @param min 最小值
     * @param max 最大值
     * @param num 序列长度
     * @return 返回一个序列
     */
    public static List<Integer> getRandomList(int min, int max, int num) {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            res.add(getRandomNum(min, max));
        }

        return res;
    }

    /**
     * 返回一个范围为 [min, max) 的随机数
     * @param min 最小值
     * @param max 最大值
     * @return 返回一个数据
     */
    public static int getRandomNum(int min, int max) {
        return min <= max ? (int) (Math.random() * (max - min) + min) : 0;
    }
}
