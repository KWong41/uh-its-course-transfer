package edu.hawaii.its.creditxfer.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class AppConfigRunTest {

    @Test
    public void construction() {
        AppConfigRun appConfig = new AppConfigRun();
        assertNotNull(appConfig);
        appConfig.init();
    }

}
