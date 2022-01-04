package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComponentImpl implements Component {

    @Override
    public String operation() {
        log.info("Component 구현체 실행");

        return "data";
    }

}
