package webController;

import org.junit.Test;
import webController.redirectStrategy.HalAndDavidRedirectStrategy;
import webController.redirectStrategy.RedirectStrategy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HalAndDavidRedirectStrategyTest {

    RedirectStrategy strategy = new HalAndDavidRedirectStrategy();

    @Test
    public void supportsHalOrDavid() {
        assertTrue(strategy.supports("hal"));
        assertTrue(strategy.supports("david"));
        assertFalse(strategy.supports(null));
        assertFalse(strategy.supports("not"));
        assertFalse(strategy.supports(""));
    }
}