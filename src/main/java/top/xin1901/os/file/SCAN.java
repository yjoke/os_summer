package top.xin1901.os.file;

import java.util.Collections;
import java.util.List;

/**
 * @author HeYunjia
 */
public class SCAN extends FileManage {

    /**
     * 当前扫描方向
     * true: 向高地址方向
     * false: 向低地址方向
     */
    boolean direction;

    public SCAN(boolean direction) {
        super();
        this.direction = direction;
    }

    public SCAN(int now, List<Integer> list, boolean direction) {
        super(now, list);
        this.direction = direction;
    }

    @Override
    protected void InitQueue() {
        Collections.sort(list);

        int index = Collections.binarySearch(list, now);
        if (index < 0)
            index = -index - 1;
        else if (!direction)
            index += 1;

        for (int i = index; i < list.size(); i++) {
            deque.offer(list.get(i));
        }

        if (direction) {
            for (int i = index - 1; i >= 0; i--) {
                deque.offer(list.get(i));
            }
        } else {
            for (int i = 0; i < index; i++) {
                deque.push(list.get(i));
            }
        }
    }

}
