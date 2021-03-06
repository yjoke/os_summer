package top.xin1901.hyj.os.file;

import java.util.List;

/**
 * @author HeYunjia
 */
public class FCFS extends FileManage {

    public FCFS() {
        super();
    }

    public FCFS(int now, List<Integer> list) {
        super(now, list);
    }

    @Override
    protected void InitQueue() {
        for (Integer i : list) {
            deque.offer(i);
        }
    }

}
