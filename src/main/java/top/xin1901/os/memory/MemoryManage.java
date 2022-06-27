package top.xin1901.os.memory;

import java.util.*;

/**
 * @author HeYunjia
 */
public abstract class MemoryManage {

    /**
     * 页大小
     */
    protected int pageSize;

    /**
     * 页表大小
     */
    protected int TableLen;

    /**
     * 指令地址流
     */
    protected List<Integer> list;

    /**
     * 该访问第 n 个值
     */
    protected int n;

    /**
     * 冲突次数
     */
    protected int clash;

    /**
     * 存放页表的状态栈
     */
    protected Deque<Integer> table;

    protected MemoryManage() {
        table = new ArrayDeque<>();

        pageSize = 1024;
        TableLen = 3;
        n = 0;
        clash = 0;
    }

    /**
     * 迭代器, 获取下一个页面状态
     * @return 获取下一个页面状态
     */
    public abstract Optional<List<Integer>> getNext();

    /**
     * 输入一个页面流
     */
    public void setList(List<Integer> list) {
        this.list = list;
    }

    /**
     * 将状态栈转换为页表
     */
    public List<Integer> tableToList() {
        return new ArrayList<>(table);
    }

    /**
     * 获取一个随机的指令地址, 地址范围 左闭右开
     */
    public static List<Integer> getList(int minAdd, int maxAdd, int num) {

        List<Integer> list = new ArrayList<>();
        int diff = maxAdd - minAdd;

        for (int i = 0; i < num; i++) {
            double random = Math.random();
            if (i <= num / 4D)
                list.add((int) (random * diff / 4D + minAdd));
            else if (i >= num * 3D / 4D)
                list.add((int) (random * diff / 4D + minAdd + diff / 4D * 3D));
            else
                list.add((int) (random * diff / 2D + minAdd + diff / 4D));
        }

        return list;
    }

    /**
     * clash 的 getter 方法
     * @return 返回 clash 的值
     */
    public int getClash() {
        return clash;
    }

    /**
     * 获取全部的序列, 返回二位数组
     * @return 每一次的序列集合
     */
    public Optional<List<List<Integer>>> getAll() {
        if (list.size() == 0) return Optional.empty();

        int backup = n;
        n = 0;

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            res.add(getNext().orElse(new ArrayList<>()));
        }

        n = backup;

        return Optional.of(res);
    }

    /**
     * 按照页表样式打印输出, 附带打印冲突次数
     */
    public void printAll() {
        List<List<Integer>> lists = getAll().orElse(new ArrayList<>());

        System.out.println("页面更迭为: ");
        for (int i = 0; i < lists.get(lists.size() - 1).size(); i++) {
            for (List<Integer> list : lists) {
                if (i >= list.size()) System.out.print("  ");
                else System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }

        System.out.println("页面冲突次数为: " + clash);
    }
}
