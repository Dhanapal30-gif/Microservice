package com.OrkaTrack.Controller;

import com.OrkaTrack.Entity.emp_Login;
import com.OrkaTrack.Entity.orkaRegister;
import com.OrkaTrack.Service.login_Service;
import com.OrkaTrack.Service.reg_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class registerContoller {

    @Autowired
    public reg_Service regService;
    @Autowired
    public login_Service logservice;

//    @PostMapping("/reg_Save")
//    public orkaRegister save_Register(@RequestBody orkaRegister regDetail){
//          regService.regDetail(regDetail);
//        return regDetail;
//    }


    @PostMapping("/reg_Save")
    public ResponseEntity<String> saveRegister(@RequestBody orkaRegister regDetail) {
        // Check if the employee ID already exists in the database
        String result = regService.regDetail(regDetail);

        // If the result indicates an error, return a bad request response
        if (result.startsWith("Error")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

        // If registration is successful, return a created response with the success message
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping("/login")
    public String login(@RequestBody emp_Login emplogin){
        boolean result = logservice.login(emplogin);
        if(result){
            return  "Sucess";
        }
        return "Login Failed";
    }

}
