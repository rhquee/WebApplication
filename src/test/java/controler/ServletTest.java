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
- verify tekst "hello zosia"

2. Dla inputu "hal"
- verify tekst
- verify url

3. Dla inputu "david"
- verify tekst
- verify url

4. Poprawność catcha
- verify tekst błędu w przypadku obu błedów z catcha: nie ma wartości pola; nie ma wartości adnotacji

 */
public class ServletTest {

    @Mock
    HttpServletResponse mockedHttpServletResponse = mock(HttpServletResponse.class);
    @Mock
    HttpServletRequest mockedHttpServletRequest = mock(HttpServletRequest.class);
    @Mock
    PrintWriter mockedPrintWriter = mock(PrintWriter.class);

    @Mock
    RequestDispatcher mockedDispatcher = mock(RequestDispatcher.class);
    @Mock
            //Defines a set of methods that a servlet uses to communicate with its servlet container;
            //One context per "web application" per Java Virtual Machine.
    ServletContext mockedServletContext = mock(ServletContext.class);

    @Test
    public void doPost_shouldReturnCorrectOutputForName() throws Exception {
        //given
        when(mockedHttpServletRequest.getParameter("name")).thenReturn("zosia");
        when(mockedHttpServletResponse.getWriter()).thenReturn(mockedPrintWriter);

        //when
        Servlet servlet = new Servlet();
        servlet.doPost(mockedHttpServletRequest, mockedHttpServletResponse);
        //then
        verify(mockedHttpServletResponse).setContentType("text/html;charset=UTF-8");
        verify(mockedPrintWriter).print("<h1>Hello, zosia </h1>");
    }

    @Test
    public void doPost_shouldReturnHalViewWithContentForHal() throws Exception {
        //given
        Servlet servlet = new Servlet();
        when(mockedHttpServletRequest.getParameter("name")).thenReturn("hal");
        when(mockedHttpServletResponse.getWriter()).thenReturn(mockedPrintWriter);
        when(mockedHttpServletRequest.getRequestDispatcher("/WEB-INF/view/halView.jsp")).thenReturn(mockedDispatcher);

        //when
        servlet.doPost(mockedHttpServletRequest, mockedHttpServletResponse);

        //then
//        verify(servlet).getServletContext();
        verify(mockedHttpServletResponse).setContentType("text/html;charset=UTF-8");
        verify(mockedServletContext).getRequestDispatcher("/WEB-INF/view/halView.jsp");
        verify(mockedDispatcher, times(1)).forward(mockedHttpServletRequest, mockedHttpServletResponse);
        verify(mockedPrintWriter).print("My mind is going. I can feel it");

    }

}