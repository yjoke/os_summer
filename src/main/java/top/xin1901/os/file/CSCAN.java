package top.xin1901.os.file;

import java.util.Collections;
import java.util.List;

/**
 * @author HeYunjia
 */
public class CSCAN extends FileManage {

    public CSCAN() {
        super();
    }

    public CSCAN(int now, List<Integer> list) {
        super(now, list);
    }

    @Override
    protected void InitQueue() {
        Collections.sort(list);

        int index = Collections.binarySearch(list, now);
        if (index < 0) index = -index - 1;

        for (int i = index; i < list.size(); i++) {
            deque.offer(list.get(i));
        }

        for (int i = 0; i < index; i++) {
            deque.offer(list.get(i));
        }
    }
}
