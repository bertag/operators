package net.bertag.operators;

import org.junit.jupiter.api.Test;

public class JOpsTest {

    @Test
    void test() {
        Integer a = 1;
        Integer b = null;
        System.out.println("j" + Ops.plus(a, b));

        Object c = new Object();
        Object d = null;
        System.out.println("j" + Ops.op(c, d, (x, y) -> new Object()));
    }
}
