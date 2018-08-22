package controler;

import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;
/*
Test:
- dla inputu = "johny"
-- 1) status 418 sie zgadza (verify)
-- 2) łańcuch się nie wykonuje dalej

- dla inputu != "johny"
-- łańcuch idzie dalej
 */

public class NameFilterTest {

    @Mock
    ServletRequest mockedServletRequest = mock(ServletRequest.class);
    @Mock
    HttpServletResponse mockedServletResponse = mock(HttpServletResponse.class);
    @Mock
    FilterChain mockedFilterChain = mock(FilterChain.class);

    @Test
    public void doFilter_shouldSetAndSend418Error() throws Exception {
        //given
        when(mockedServletRequest.getParameter("name")).thenReturn("johny");

        //when
        NameFilter nameFilter = new NameFilter();
        nameFilter.doFilter(mockedServletRequest, mockedServletResponse , mockedFilterChain);

        //then
        verifyZeroInteractions(mockedFilterChain);
        verify(mockedServletResponse).setStatus(418);
        verify(mockedServletResponse).sendError(418);
    }


    @Test
    public void doFilter_shouldDoFilterOnFilterChain() throws Exception {
        //given
        when(mockedServletRequest.getParameter("name")).thenReturn("zosia");

        //when
        NameFilter nameFilter = new NameFilter();
        nameFilter.doFilter(mockedServletRequest, mockedServletResponse , mockedFilterChain);

        //then
        verify(mockedFilterChain).doFilter(mockedServletRequest, mockedServletResponse);
    }


}