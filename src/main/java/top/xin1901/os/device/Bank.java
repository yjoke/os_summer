package top.xin1901.os.device;

import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author HeYunjia
 */
@ToString
public class Bank {

    /**
     * 可利用资源向量
     */
    private Vector available;

    /**
     * 已经分配给进程的矩阵信息
     */
    private final Map<Integer, Vector> allocation;

    /**
     * 进程需要的最大资源
     */
    private final Map<Integer, Vector> max;

    /**
     * 银行拥有的资源数目
     * @return 返回资源向量的长度
     */
    public int length() {
        return available.length();
    }

    public Bank(Vector available) {
        this.available = available;
        this.allocation = new HashMap<>();
        this.max = new HashMap<>();
    }

    /**
     * 添加一个新的进程, 返回是否添加成功
     *
     * @param process 某进程
     * @return 返回是否添加成功
     */
    public boolean addProcess(Process process) {
        if (available.compareTo(process.getNeed())) {
            allocation.put(process.getId(), Vector.ZeroVector(length()));
            max.put(process.getId(), process.getNeed());
            return true;
        }
        return false;
    }

    /**
     * 进程 process 请求资源, 资源向量为 request
     *
     * @param process 进程
     * @param request 请求资源向量
     * @return 是否分配成功
     */
    public boolean allot(Process process, Vector request) {
        if (!available.compareTo(request)) return false;

        available = available.sub(request);

        if (isSafe()) {
            allocation.put(process.getId(), allocation.get(process.getId()).add(request));
            process.setNeed(process.getNeed().sub(request));
            return true;
        } else {
            available = available.add(request);
            return false;
        }

    }

    /**
     * 判断当前是否是安全状态
     *
     * @return 是否安全
     */
    private boolean isSafe() {
        Vector work = available;
        Set<Integer> finish = new HashSet<>(max.keySet());

        while (true) {
            boolean flag = true;
            for (Integer id : finish) {
                Vector need = max.get(id).sub(allocation.get(id));

                if (!work.compareTo(need)) continue;
                else flag = false;

                work = work.add(allocation.get(id));
                finish.remove(id);
                break;
            }

            if (flag) break;
        }

        return finish.size() == 0;
    }

}
