package spring.boot.revamp.jpaExamples.relationships.manyToManyExamples;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManyToManyService {

    private final OrderDetailsManyToManyRepository orderRepository;
    private final ProductDetailsManyToManyRepository productRepository;

    public ManyToManyService(OrderDetailsManyToManyRepository orderRepository, ProductDetailsManyToManyRepository productRepository){
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public ProductDetailsManyToMany createProduct(ProductDetailsManyToMany product){
        return this.productRepository.save(product);
    }

    public OrderDetailsManyToMany createOrder(OrderDetailsManyToMany order){
        List<ProductDetailsManyToMany> productDetailsManyToManies = order.getProducts().stream().map(product ->
            this.productRepository.findById(product.getProductId()).orElse(null)
        ).toList();
        order.setProducts(productDetailsManyToManies);
        return this.orderRepository.save(order);
    }
}
