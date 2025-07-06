package spring.boot.revamp.jpaExamples.relationships.manyToOneExamples;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jpaManyToOne")
public class ManyToOneController {

    private final ManyToOneService manyToOneService;

    public ManyToOneController(ManyToOneService service){
        this.manyToOneService = service;
    }


    @PostMapping("/createOrder")
    public ResponseEntity<OrderDetailsManyToOne> createUser(@RequestBody OrderDetailsManyToOne orderDetails){
        return ResponseEntity.ok(
                this.manyToOneService.createOrder(orderDetails)
        );
    }

//    @GetMapping("/getUser/{userId}")
//    public ResponseEntity<UserDetailsOneToMany> getUserById(@PathVariable("userId") Long id){
//        return ResponseEntity.ok(
//                this.oneToManyService.getUserId(id)
//        );
//    }

    // Example to orphanRemoval
    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity<OrderDetailsManyToOne> getUserById(@PathVariable("orderId") Long id){
        OrderDetailsManyToOne orderDetailsManyToOne = this.manyToOneService.getOrderById(id);
        return ResponseEntity.ok(orderDetailsManyToOne);
    }

}
