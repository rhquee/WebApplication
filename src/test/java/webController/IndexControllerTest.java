//package webController;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockServletContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import javax.servlet.ServletContext;
//
///**
// * Created by kfrak on 05.12.2018.
// */
//@RunWith(SpringJUnit4ClassRunner.class) //entry-point to start using the Spring Test framework
//@ContextConfiguration //we provided the ApplicationConfig.class config class which loads the configuration we need for this particular test.
//@WebAppConfiguration //will load the web application context.
//public class IndexControllerTest {
//    //provides the web application configuration. It loads all the application beans and controllers into the context.
//    @Autowired
//    private WebApplicationContext wac;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() throws Exception {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//    }
//
//    @Test
//    public void givenWac_whenServletContext_thenItProvidesGreetController() {
//        ServletContext servletContext = wac.getServletContext();
//        Assert.assertNotNull(servletContext);
//        Assert.assertTrue(servletContext instanceof MockServletContext);
//        Assert.assertNotNull(wac.getBean("greetController"));
//    }
//
//    @Test
//    public void showIndexPage() throws Exception {
//
//    }
//
//}