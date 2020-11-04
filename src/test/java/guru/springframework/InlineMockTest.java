package guru.springframework;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class InlineMockTest {

    @Test
    void testInlineMock() {

        /*
         define an inline mock for the 'Map' class
         using a static method to create a mock
        */
        Map mapMock = mock(Map.class);

        // validate that it's empty, as expected
        assertEquals(mapMock.size(), 0);

    }
}
