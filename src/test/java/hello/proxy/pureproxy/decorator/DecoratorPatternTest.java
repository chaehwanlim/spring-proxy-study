package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component componentImpl = new ComponentImpl();

        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(componentImpl);
        decoratorPatternClient.execute();
    }

    @Test
    void decorator1() {
        Component componentImpl = new ComponentImpl();
        Component messageDecorator = new MessageDecorator(componentImpl);

        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(messageDecorator);
        decoratorPatternClient.execute();
    }

    @Test
    void decorator2() {
        Component componentImpl = new ComponentImpl();
        MessageDecorator messageDecorator = new MessageDecorator(componentImpl);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);

        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }

}
