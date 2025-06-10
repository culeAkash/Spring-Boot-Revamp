package spring.boot.revamp.controllerAnnotations.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;
import spring.boot.revamp.controllerAnnotations.models.User;

import java.beans.PropertyEditorSupport;

@RestController
@RequestMapping("/api/v1/contannots")
public class DemoControllerContAnnots {


    @GetMapping(path = "/demo")
    public String getDemo(){
        return "Hello Annotations";
    }

    // before each mapping method this binder gets called and all fields matching the fields used in the binder will get updated.
    @InitBinder
    protected void initBinder(DataBinder dataBinder){
        dataBinder.registerCustomEditor(String.class,"age", new FirstNamePropertyEditor());
    }


    @GetMapping(path = "/fetchUser")
    public String getUserDetails(@RequestParam(name = "firstName",required = true) String firstName,
                                 @RequestParam(name = "lastName",required = false) String lastName,
                                 @RequestParam(name = "age",required = true)int age
                                 ){
        return "Firstname: " + firstName + " , LastName: " + lastName + ", Age: " + age;
    }


    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        return ResponseEntity.ok("User saved: username :" + user.getUsername() + " and email: " + user.getEmail());
    }


    private static class FirstNamePropertyEditor extends PropertyEditorSupport{
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Integer.parseInt(text.trim())+20);
        }
    }

}



