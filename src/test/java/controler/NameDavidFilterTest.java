package controler;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kfrak on 29.08.2018.
 */
public class NameDavidFilterTest {
    @Test
    public void getName_shouldReturnExpectedName() throws Exception {
        //given
        String expected = "david";
        //when
        NameDavidFilter nameDavidFilter = new NameDavidFilter();
        //then
        assertEquals(expected, nameDavidFilter.getName());
    }

}