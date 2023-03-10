package com.demo.cg;

import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;

import static org.easymock.EasyMock.*;

public class A {
    @Test
    public void f() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./generated");

        StringUtils utils = mock(StringUtils.class);

        utils.add("1", "31");
        expect(null).andReturn("131");
        utils.add("aa", "bb");
        expect("").andReturn("aabb");
        replay(utils);
        String a = utils.add("1", "31");
        System.out.println(a);
        utils.add("aa", "bb");

        verify(utils);
    }
}
