package top.xin1901.os.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author HeYunjia
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Process {

    /**
     * 进程的标识
     */
    private int id;

    /**
     * 最大的资源需求向量
     */
    private Vector max;

    /**
     * 还需要的资源向量
     */
    private Vector need;

    public Process(int id, Vector max) {
        this.id = id;
        this.max = max;
        this.need = max;
    }

    /**
     * 向 bank 银行发起大小为 request 的资源请求
     * @param request 资源向量
     * @return 请求是否成功
     */
    public boolean apply(Bank bank, Vector request) {
        if (!need.compareTo(request)) return false;
        return bank.allot(this, request);
    }

}
