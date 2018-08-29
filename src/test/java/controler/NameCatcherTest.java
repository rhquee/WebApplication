package controler;

import model.CacheForAnnotationAndFieldValues;
import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class NameCatcherTest {

    @Mock
    ServletRequest mockedServletRequest = mock(ServletRequest.class);
    @Mock
    HttpServletResponse mockedServletResponse = mock(HttpServletResponse.class);
    @Mock
    FilterChain mockedFilterChain = mock(FilterChain.class);
    @Mock
    CacheForAnnotationAndFieldValues mockedCacheForAnnotationAndFieldValues = mock(CacheForAnnotationAndFieldValues.class);
    @Mock
    RequestDispatcher mockedDispatcher = mock(RequestDispatcher.class);

    @Test
    public void doFilter_shouldReturnCorrectResultForDavid() throws Exception {
        //given
        when(mockedServletRequest.getParameter("name")).thenReturn("david");
        when(mockedServletRequest.getRequestDispatcher("/WEB-INF/view/davidView.jsp")).thenReturn(mockedDispatcher);
        when(mockedCacheForAnnotationAndFieldValues.getAnnotationValue()).thenReturn("davidView");
        when(mockedCacheForAnnotationAndFieldValues.getFieldValue()).thenReturn("David here");

        //when
        NameCatcher spyNameCatcher = spy(NameCatcher.class);
        when(spyNameCatcher.getName()).thenReturn("david");
        spyNameCatcher.doFilter(mockedServletRequest, mockedServletResponse, mockedFilterChain);

        //then
        /*
        * - czy się wywołała metoda doFilterForGivenName
        * - czy łańcuch poszedł dalej
        * - czy został wykonany forward
        * - czy odpowiedź jest pod odpowiednim URL
        * - czy odpowiedź ma odpowiedni content
         */
        verify(spyNameCatcher, times(1)).doFilterForGivenName(mockedServletRequest, mockedServletResponse, "david");
        verify(mockedFilterChain).doFilter(mockedServletRequest, mockedServletResponse);
        verify(mockedDispatcher, times(1)).forward(mockedServletRequest, mockedServletResponse);
        verify(mockedServletRequest).getRequestDispatcher("/WEB-INF/view/davidView.jsp");
        verify(mockedServletRequest).setAttribute("responseString", "David here");
    }

    @Test
    public void doFilter_shouldReturnCorrectResultForZosia() throws Exception {
        //given
        when(mockedServletRequest.getParameter("name")).thenReturn("zosia");

        //when
        NameCatcher spyNameCatcher = spy(NameCatcher.class);
        spyNameCatcher.doFilter(mockedServletRequest, mockedServletResponse, mockedFilterChain);

        //then
        /*
        * - czy się nie wywoła metoda doFilterForGivenName
        * - czy łańcuch poszedł dalej
         */
        verify(spyNameCatcher, times(0)).doFilterForGivenName(mockedServletRequest, mockedServletResponse, "david");
        verify(mockedFilterChain).doFilter(mockedServletRequest, mockedServletResponse);
    }
}