package ru.perm.v.family.ctrl;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jorphan.collections.HashTree;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.apache.jmeter.util.JMeterUtils;

import java.io.File;

@Disabled
public class LoadTest {

    @Test
    public void testEchoRequest() {
        String jmeterHome = System.getenv("JMETER_HOME");
        if (jmeterHome == null) {
            throw new RuntimeException("Переменная среды JMETER_HOME не установлена");
        }
        JMeterUtils.setJMeterHome(jmeterHome);
        JMeterUtils.loadJMeterProperties(String.valueOf(new File(jmeterHome, "bin/jmeter.properties")));
        JMeterUtils.initLocale();
        // Создание TestPlan
        TestPlan testPlan = new TestPlan("Java-Generated Test Plan");

        // Сборка дерева элементов (упрощённо)
        HashTree testPlanTree = new HashTree();
        testPlanTree.add(testPlan);

        // Запуск теста
        StandardJMeterEngine engine = new StandardJMeterEngine();
        engine.configure(testPlanTree);
        engine.run();
        engine.stopTest();
        //                threadGroup(10, 30, httpSampler("http://localhost:8780/api/message").method("GET")

    }
}
