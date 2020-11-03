package guru.springframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Ronnen Nagal
 * @created 03/11/2020 - 7:10 p.m.
 * @project testing-junit5-mockito
 */
public class AnnotationMockTest {

    // define a pointer to the Map class
    @Mock
    Map<String, String> mapMock;

    // define a pointer to the real Map class
    Map<String, String> mapNoMock;

    @BeforeEach
    void setUp() {

        // initializing the mock
        MockitoAnnotations.initMocks(this);

        // initializing the real Object
        mapNoMock = new HashMap<>();
    }

    @Test
    void testMock() {

        // mocking insertion to a Map
        mapMock.put("key", "foo");

        // will compile, the mock is not empty
        assertFalse(mapMock.isEmpty());

        // will not compile, there are no properties to a mock
        //assertEquals(mapMock.get("key"), "foo");

        // inserting to a real Object
        mapNoMock.put("key2", "foo2");

        // will compile, like the mock
        assertFalse(mapNoMock.isEmpty());

        // runs, the real object has properties
        assertEquals(mapNoMock.get("key2"), "foo2");

    }
}

