package top.xin1901.os.file;

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

    public FileManage(int now, List<Integer> list) {
        setNow(now);
        setList(list);
    }

    /**
     * 设置 now
     * @param now 当前位置
     */
    public void setNow(int now) {
        this.now = now;
    }

    /**
     * 设置 List
     * @param list 待处理的序列
     */
    public void setList(List<Integer> list) {
        this.list = list;
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
