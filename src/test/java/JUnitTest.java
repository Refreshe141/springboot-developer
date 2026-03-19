import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    @DisplayName("1+2는 3이다. (성공 케이스)")
    @Test
    public void junitTest() {
        int n1 = 1;
        int n2 = 2;
        int sum = n1 + n2;

        // expected:3 대신 숫자 3만 적어줍니다.
        Assertions.assertEquals(3, sum);
    }
    @DisplayName("1+3는 4이다. (실패)")
    @Test
    public void junitFaildTest() {
        int n1 = 1;
        int n2 = 3;
        int sum = n1 + n2;

        // 이 테스트는 실행 시 AssertionFailedError가 발생하며 '실패'로 표시됩니다.
        Assertions.assertEquals(3, sum);
    }
}