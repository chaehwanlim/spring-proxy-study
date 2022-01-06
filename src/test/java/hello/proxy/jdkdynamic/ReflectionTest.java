package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();

        // 공통 로직 1 시작
        log.info("start");
        String result1 = target.callA();    // 호출하는 메서드만 다르다
        log.info("result={}", result1);

        // 공통 로직 2 시작
        log.info("start");
        String result2 = target.callB();
        log.info("result={}", result2);

        // 리플렉션을 사용해서 중복 로직을 공통화, 동적으로 호출 메서드를 변경할 수 있다.
    }

    @Test
    void reflection1() throws Exception {
        // 클래스 정보
        Class<?> helloClass = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // callA 메서드 정보
        Method methodCallA = helloClass.getMethod("callA");
        Object result1 = methodCallA.invoke(target);    // target 인스턴스의 callA를 호출한다
        log.info("result1={}", result1);

        // callB 메서드 정보
        Method methodCallB = helloClass.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2={}", result2);
    }

    @Test
    void reflection2() throws Exception {
        // 클래스 정보
        Class<?> helloClass = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // callA 메서드 정보
        Method methodCallA = helloClass.getMethod("callA");
        dynamicCall(methodCallA, target);

        // callB 메서드 정보
        Method methodCallB = helloClass.getMethod("callB");
        dynamicCall(methodCallB, target);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        log.info("start");
        Object result = method.invoke(target);
        log.info("result={}", result);
    }


    static class Hello {

        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }

    }

}
