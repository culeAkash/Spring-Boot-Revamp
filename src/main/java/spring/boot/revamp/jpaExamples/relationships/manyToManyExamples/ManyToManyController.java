package spring.boot.revamp.jpaExamples.relationships.manyToManyExamples;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manyToManyJpa")
public class ManyToManyController {

    private final ManyToManyService manyToManyService;

    public ManyToManyController(ManyToManyService manyToManyService){
        this.manyToManyService = manyToManyService;
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductDetailsManyToMany> createProd(@RequestBody ProductDetailsManyToMany product){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.manyToManyService.createProduct(product));
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDetailsManyToMany> createOrder(@RequestBody OrderDetailsManyToMany order){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.manyToManyService.createOrder(order));
    }
}
