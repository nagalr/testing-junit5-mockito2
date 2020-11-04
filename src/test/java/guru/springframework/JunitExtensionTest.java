package guru.springframework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

/**
 * @author Ronnen Nagal
 * @created 04/11/2020 - 4:14 p.m.
 * @project testing-junit5-mockito
 */
@ExtendWith(MockitoExtension.class)
public class JunitExtensionTest {

    /*
     The same as 'AnnotationMockTest' but the 'init
     is executing by Mockito (not @setup method here)
     */
    @Mock
    Map<String, Object> mapMock;

    @Test
    void testMock() {
        mapMock.put("keyvalue", "foo");
    }


}
