package controler;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameHalFilterTest {
    @Test
    public void getName_shouldReturnExpectedName() throws Exception {
        //given
        String expected = "hal";
        //when
        NameHalFilter nameHalFilter= new NameHalFilter();
        //then
        assertEquals(expected, nameHalFilter.getName());
    }

}