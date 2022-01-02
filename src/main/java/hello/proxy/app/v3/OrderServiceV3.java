package hello.proxy.app.v3;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
