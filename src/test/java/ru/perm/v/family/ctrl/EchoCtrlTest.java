package ru.perm.v.family.ctrl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EchoCtrlTest {
    @Test
    void testEcho() {
        EchoCtrl ctrl = new EchoCtrl();

        assertEquals("MESSAGE", ctrl.echo("MESSAGE"));
    }
}
