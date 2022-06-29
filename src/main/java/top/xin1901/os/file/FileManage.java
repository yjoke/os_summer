package top.xin1901.os.file;

import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author HeYunjia
 */
public abstract class FileManage implements Iterator<Integer> {

    /**
     * 当前位置
     */
    protected int now;

    /**
     * 待处理序列
     */
    protected List<Integer> list;

    /**
     * 已经处理的数量
     */
    protected int n;

    /**
     * 磁道访问总长度
     */
    protected int sum;

    /**
     * 访问队列
     */
    protected Deque<Integer> deque;

    public FileManage(int now, List<Integer> list) {
        this.now = now;
        this.list = list;
        this.n = 0;
        this.sum = 0;
    }

    /**
     * 获取下一个位置
     * @return 下一个的位置
     */
    public abstract Integer getNext();

    public static List<Integer> getList(int min, int max, int num) {
        return null;
    }
}
