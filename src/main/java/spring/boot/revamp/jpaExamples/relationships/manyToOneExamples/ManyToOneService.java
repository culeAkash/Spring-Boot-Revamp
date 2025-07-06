package spring.boot.revamp.jpaExamples.relationships.manyToOneExamples;

import org.springframework.stereotype.Service;

@Service
public class ManyToOneService {

    private final OrderDetailsManyToOneRepository orderDetailsManyToOneRepository;

    public ManyToOneService(OrderDetailsManyToOneRepository orderDetailsManyToOneRepository){
        this.orderDetailsManyToOneRepository = orderDetailsManyToOneRepository;
    }

    public OrderDetailsManyToOne createOrder(OrderDetailsManyToOne orderDetailsManyToOne){
        return this.orderDetailsManyToOneRepository.save(orderDetailsManyToOne);
    }

    public OrderDetailsManyToOne getOrderById(Long id){
        return this.orderDetailsManyToOneRepository.findById(id).orElse(null);
    }
}
