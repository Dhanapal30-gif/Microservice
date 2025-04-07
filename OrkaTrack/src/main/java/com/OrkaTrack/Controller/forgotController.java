package com.OrkaTrack.Controller;

import com.OrkaTrack.Service.forgot_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class forgotController {
    @Autowired
   public forgot_service forgotpasswordService;

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotpassword(@RequestBody String empEmail){
       System.out.println("email////////////"+ empEmail);
            String response= forgotpasswordService.generateOtp(empEmail);
           return ResponseEntity.ok(response);
   }



//    @PostMapping("/forgot-password")
//    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> request) {
//        String empEmail = request.get("empEmail").trim();
//        String response = forgotpasswordService.sendOtpToEmail(empEmail);
//        return new ResponseEntity<>(response, HttpStatus.OK);
   }
/*
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("emailid");

        if (email == null || email.trim().isEmpty()) {
            return new ResponseEntity<>("Email ID is required.", HttpStatus.BAD_REQUEST);
        }

        email = email.trim(); // Trim the email address
        String response = forgotpasswordService.sendOtpToEmail(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/


