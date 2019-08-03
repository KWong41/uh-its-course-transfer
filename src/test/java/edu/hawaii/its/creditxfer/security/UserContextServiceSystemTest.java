package edu.hawaii.its.creditxfer.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.hawaii.its.creditxfer.access.AnonymousUser;
import edu.hawaii.its.creditxfer.access.Role;
import edu.hawaii.its.creditxfer.access.User;
import edu.hawaii.its.creditxfer.configuration.CachingConfig;
import edu.hawaii.its.creditxfer.configuration.DatabaseConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DatabaseConfig.class, CachingConfig.class })
public class UserContextServiceSystemTest {

    @Autowired
    private UserContextService userContextService;

    @Test
    public void user() {
        assertNotNull(userContextService);
        User user = userContextService.getCurrentUser();
        assertTrue(user instanceof AnonymousUser);
        assertTrue(user.isEnabled());
        assertEquals("anonymous", user.getUsername());
        assertEquals("anonymous", user.getUid());
        assertEquals(1, user.getAuthorities().size());
        assertTrue(user.hasRole(Role.ANONYMOUS));
        assertNotNull(user.getAttributes());
        assertEquals("", user.getAttribute("uhuuid"));
    }
}
