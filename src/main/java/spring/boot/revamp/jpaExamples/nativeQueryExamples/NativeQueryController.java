package spring.boot.revamp.jpaExamples.nativeQueryExamples;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/nativeQueryJpa")
public class NativeQueryController {

    private final NativeQueryService nativeQueryService;
    private final NativeDynamicQueryService nativeDynamicQueryService;

    public NativeQueryController(NativeQueryService nativeQueryService,NativeDynamicQueryService nativeDynamicQueryService){
        this.nativeQueryService = nativeQueryService;
        this.nativeDynamicQueryService = nativeDynamicQueryService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<Void> createUser(@RequestBody UserDetailsNativeQuery userDetailsNativeQuery){
        this.nativeQueryService.createUser(userDetailsNativeQuery);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/runQuery1")
    public ResponseEntity<Void> runQuery1(){
        System.out.println(this.nativeQueryService.getUserExample1("Akash"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/runQuery2")
    public ResponseEntity<Void> runQuery2(){
        System.out.println(this.nativeQueryService.runQuery2("Akash"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/runQuery3")
    public ResponseEntity<Void> runQuery3(){
        this.nativeDynamicQueryService.getUserDetailsByNameNativeDynamicQuery("Aman");
        return ResponseEntity.ok().build();
    }

}
