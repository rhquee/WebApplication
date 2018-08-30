package controler;

import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

/*
1. Dla inputu "zosia"
- czy atrybut {name} ustawił sie na zosia
- czy wykonał sie forward
- czy poprawny URL /hello
 */
public class ServletTest {

    @Mock
    HttpServletResponse mockedHttpServletResponse = mock(HttpServletResponse.class);
    @Mock
    HttpServletRequest mockedHttpServletRequest = mock(HttpServletRequest.class);
    @Mock
    RequestDispatcher mockedDispatcher = mock(RequestDispatcher.class);

    @Test
    public void doPost_shouldReturnCorrectOutputForName() throws Exception {
        //given
        when(mockedHttpServletRequest.getParameter("name")).thenReturn("Zosia");
        when(mockedHttpServletRequest.getRequestDispatcher("/WEB-INF/view/hello.jsp")).thenReturn(mockedDispatcher);

        //when
        Servlet servlet = new Servlet();
        servlet.doPost(mockedHttpServletRequest, mockedHttpServletResponse);

        //then
        verify(mockedDispatcher).forward(mockedHttpServletRequest, mockedHttpServletResponse);
        verify(mockedHttpServletRequest).setAttribute("name", "Zosia");
    }
}