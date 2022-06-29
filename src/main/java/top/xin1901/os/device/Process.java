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

}
