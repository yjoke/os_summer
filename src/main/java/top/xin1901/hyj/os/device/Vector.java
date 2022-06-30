package top.xin1901.hyj.os.device;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HeYunjia
 */

public class Vector {

    @Override
    public String toString() {
        return Arrays.toString(value.toArray());
    }

    /**
     * 向量内容
     */
    private final List<Integer> value;

    /**
     * 向量长度
     */
    public int length() {
        return value.size();
    }

    /**
     * 零向量
     */
    public static Vector ZeroVector(int len) {
        return new Vector(new ArrayList<Integer>() {{
            for (int i = 0; i < len; i++) add(0);
        }});
    }

    public Vector(List<Integer> value) {
        this.value = value;
    }

    public Vector(int... value) {
        this.value = new ArrayList<>();
        for (int v : value) {
            this.value.add(v);
        }
    }

    /**
     * 向量加法, 调用向量加参数向量
     *
     * @param other 向量
     * @return 一个新向量
     */
    public Vector add(Vector other) {
        if (this.value.size() != other.value.size()) return null;

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < this.value.size(); i++) {
            res.add(this.value.get(i) + other.value.get(i));
        }

        return new Vector(res);
    }

    /**
     * 向量减法, 调用向量减去参数向量
     *
     * @param other 向量
     * @return 一个新向量
     */
    public Vector sub(Vector other) {
        if (this.value.size() != other.value.size()) return null;

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < this.value.size(); i++) {
            res.add(this.value.get(i) - other.value.get(i));
        }

        return new Vector(res);
    }

    /**
     * 比较调用向量和参数向量
     *
     * @param other 向量
     * @return 调用向量的每一个都不小于参数向量, 返回 true;
     */
    public boolean compareTo(Vector other) {
        if (this.value.size() != other.value.size()) return false;

        Vector v = this.sub(other);

        for (int i : v.value) {
            if (i < 0) return false;
        }

        return true;
    }
}
