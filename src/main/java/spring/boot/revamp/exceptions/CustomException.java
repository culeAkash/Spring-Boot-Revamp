package spring.boot.revamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Invalid Request Passed")
public class CustomException extends RuntimeException {
    private final HttpStatus httpStatus;

    public CustomException(HttpStatus httpStatus,String message){
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus httpStatus(){
        return httpStatus;
    }

}
