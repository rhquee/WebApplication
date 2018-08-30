package controler;

import model.CacheForAnnotationAndFieldValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class NameCatcherTest {
    @Mock
    ServletRequest mockedServletRequest;
    @Mock
    HttpServletResponse mockedServletResponse;
    @Mock
    FilterChain mockedFilterChain;
    @Mock
    CacheForAnnotationAndFieldValues mockedCacheForAnnotationAndFieldValues;
    @Mock
    RequestDispatcher mockedDispatcher;

    @Test
    public void doFilter_shouldReturnCorrectResultForDavid() throws Exception {
        //given
        when(mockedServletRequest.getParameter("name")).thenReturn("david");
        when(mockedServletRequest.getRequestDispatcher("/WEB-INF/view/davidView.jsp")).thenReturn(mockedDispatcher);
        mockedCacheForAnnotationAndFieldValues = new CacheForAnnotationAndFieldValues("david");

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
        verify(mockedFilterChain).doFilter(mockedServletRequest, mockedServletResponse);
        verify(mockedDispatcher).forward(mockedServletRequest, mockedServletResponse);
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