package webController;

import config.Initializer;
import config.SpringRootConfig;
import config.SpringWebConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static sun.security.krb5.internal.crypto.Nonce.value;

/**
 * Created by kfrak on 05.12.2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration (classes = {SpringRootConfig.class, SpringWebConfig.class})
public class NameControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }


    @Test
    public void resolveView_showHelloPageWithGreeting() throws Exception {
        this.mockMvc.perform(post("/hello")
                .param("name", "Popopop"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("name", "Pp"));
    }

    @Test
    public void resolveView_showHalPage() throws Exception {
        this.mockMvc.perform(post("/hello")
                .param("name", "hal"))
                .andExpect(status().isOk())
                .andExpect(view().name("halView"))
                .andExpect(model().attribute("responseString", "My mind is going. I can feel it"));
    }










//    @Test
//    public void givenWAC_whenServletContext_thenItProvidesGreetController() {
//        final ServletContext servletContext = webApplicationContext.getServletContext();
//        Assert.assertNotNull(servletContext);
//        Assert.assertTrue(servletContext instanceof MockServletContext);
//        Assert.assertNotNull(webApplicationContext.getBean("nameController"));
//    }
}