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

    public void setNow(int now) {
        this.now = now;
    }

    public void setList(List<Integer> list) {
        this.list = list;
        if (deque == null) InitQueue();
    }

    public int getSum() {
        return sum;
    }

    public double getAvg() {
        return 1D * sum / n;
    }

    public FileManage() {
        this.n = 0;
        this.sum = 0;
    }

    public FileManage(int now, List<Integer> list) {
        this.now = now;
        this.list = list;
        this.n = 0;
        this.sum = 0;
    }

    /**
     * 初始化队列
     */
    protected abstract void InitQueue();

    @Override
    public boolean hasNext() {
        return n < list.size();
    }

    @Override
    public Integer next() {
        if (deque.isEmpty()) return null;

        Integer next = deque.poll();

        n += 1;
        sum += Math.abs(now - next);
        now = next;

        return now;
    }
}
