package top.xin1901.os.device;

import java.util.Map;

/**
 * @author HeYunjia
 */
public class Bank {

    /**
     * 可利用资源向量
     */
    private Vector available;

    /**
     * 已经分配给进程的矩阵信息
     */
    private Map<Integer, Vector> allocation;

    /**
     * 进程需要的最大资源
     */
    private Map<Integer, Vector> max;

    /**
     * 进程 process 请求资源, 资源向量为 request
     * @param process 进程
     * @param request 请求资源向量
     * @return 是否分配成功
     */
    public boolean allot(Process process, Vector request) {

        return false;
    }

    /**
     * 判断当前是否是安全状态
     * @return 是否安全
     */
    private boolean isSafe() {

        return true;
    }

}
