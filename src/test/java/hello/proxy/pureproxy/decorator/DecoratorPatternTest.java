package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.Component;
import hello.proxy.pureproxy.decorator.code.ComponentImpl;
import hello.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import hello.proxy.pureproxy.decorator.code.MessageDecorator;
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

}
