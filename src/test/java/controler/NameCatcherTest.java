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
    NameDavidFilter mockedDavidFilter = mock(NameDavidFilter.class);
    @Mock
    CacheForAnnotationAndFieldValues mockedCacheForAnnotationAndFieldValues = mock(CacheForAnnotationAndFieldValues.class);
    @Mock
    JSPDispatcher mockedJspDispatcher = mock(JSPDispatcher.class);
    @Mock
    RequestDispatcher mockedDispatcher = mock(RequestDispatcher.class);

    @Test
    public void doFilter_shouldInvokeDoFilterForGivenNameMethod() throws Exception {
        //given
        when(mockedServletRequest.getParameter("name")).thenReturn("david");
        when(mockedDavidFilter.getName()).thenReturn("david");
        when(mockedCacheForAnnotationAndFieldValues.getAnnotationValue()).thenReturn("davidView");
        when(mockedCacheForAnnotationAndFieldValues.getFieldValue()).thenReturn("David here");
        when(mockedServletRequest.getRequestDispatcher("/WEB-INF/view/davidView.jsp")).thenReturn(mockedDispatcher);
        //when
        NameCatcher spyNameCatcher = spy(NameCatcher.class);
        spyNameCatcher.doFilter(mockedServletRequest, mockedServletResponse, mockedFilterChain);
        //then
        verify(spyNameCatcher, times(1)).doFilterForGivenName(mockedServletRequest, mockedServletResponse, "david");
        verify(mockedFilterChain).doFilter(mockedServletRequest, mockedServletResponse);
        verify(mockedDispatcher, times(1)).forward(mockedServletRequest, mockedServletResponse);
        verify(mockedJspDispatcher, times(1)).dispatchToDestinyURL(mockedServletRequest, mockedServletResponse, mockedCacheForAnnotationAndFieldValues);
        verify(mockedServletRequest).getRequestDispatcher("/WEB-INF/view/davidView.jsp");
        verify(mockedServletRequest).setAttribute("responseString", "David here");

    }
}