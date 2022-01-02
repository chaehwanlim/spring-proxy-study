package hello.proxy.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
// @Controller를 쓰면 컴포넌트 스캔의 대상이 되기 때문에 일부러 안 씀. V2는 수동 등록하는 게 목표
@RequestMapping
@ResponseBody
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;

    @GetMapping("/v2/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);

        return "ok";
    }

    @GetMapping("/v2/request")
    public String noLog() {
        return "ok";
    }

}
