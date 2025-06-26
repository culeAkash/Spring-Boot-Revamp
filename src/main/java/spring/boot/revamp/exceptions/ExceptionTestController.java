package spring.boot.revamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exceptions")
public class ExceptionTestController {

    @GetMapping(path = "/get")
    public String getUser(){
        throw new CustomException(HttpStatus.BAD_REQUEST,"request is not correct, please check");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Invalid Request Passed")
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
