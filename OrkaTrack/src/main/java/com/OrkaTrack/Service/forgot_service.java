package com.OrkaTrack.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.OrkaTrack.Entity.orkaRegister;
import com.OrkaTrack.Repository.reg_repo;

@Service
public class forgot_service {
    @Autowired
    private email_Service emailService;
    @Autowired
    public reg_repo reg_emprepo;

    @Autowired
    private JavaMailSender mailSender;




   public String generateOtp(String empEmail){
        Random random=new Random();
      int otp = 100000 + random.nextInt(900000);
       //orkaRegister emp=loginRepo.findByPassword(emplogin.getPassword());

        Optional<orkaRegister> useroptional= reg_emprepo.findByEmpEmail(empEmail);
        //Optional<orkaRegister> useroptional = reg_emprepo.findByEmpEmailIgnoreCase("dhanapal.orka@gmail.com");

       System.out.println("empEmail forgot" + useroptional);

        if(useroptional.isPresent()){
            System.out.println("empEmail forgot");
            orkaRegister user=useroptional.get();
            user.setOtp(otp);
           user.setOtpExpiryTime(LocalDateTime.now().plusMinutes(10));
            reg_emprepo.save(user);
           emailService.sendOtpEmail(empEmail, otp);
            return "OTP sent to your email address.";


        }else {
            return "Error: Email not registered.";
       }

    }


//    public String sendOtpToEmail(String empEmail) {
//        // Trim any leading or trailing whitespace from the email
//        empEmail = empEmail.trim();
//
//        // Generate a random 6-digit OTP
//        int otp = new Random().nextInt(900000) + 100000;
//
//        // Create and save the OTP entry in the database
//        orkaRegister emailOtp = new orkaRegister();
//        emailOtp.setEmpEmail(empEmail);
//        emailOtp.setOtp(otp);
//        emailOtp.setOtpExpiryTime(LocalDateTime.now().plusMinutes(10)); // OTP expires in 10 minutes
//        reg_emprepo.save(emailOtp);
//
//        // Send the OTP via email
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(empEmail);
//        message.setSubject("Forgot Password OTP");
//        message.setText("Your OTP is: " + otp + ". It is valid for 10 minutes.");
//        try {
//            mailSender.send(message);
//        } catch (Exception e) {
//            throw new MailParseException("Failed to send OTP email", e);
//        }
//
//        return "OTP sent to your email address.";
//    }

/*    public String sendOtpToEmail(String email) {
        // Ensure email is properly trimmed
        email = email.trim();

        // Generate a random 6-digit OTP
        int otp = new Random().nextInt(900000) + 100000;

        // Create and save the OTP entry in the database
        orkaRegister emailOtp = new orkaRegister();
        emailOtp.setEmpEmail(email);
        emailOtp.setOtp(otp);
        emailOtp.setOtpExpiryTime(LocalDateTime.now().plusMinutes(10)); // OTP expires in 10 minutes
        reg_emprepo.save(emailOtp);

        // Send the OTP via email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Forgot Password OTP");
        message.setText("Your OTP is: " + otp + ". It is valid for 10 minutes.");
        try {
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send OTP email", e);
        }

        return "OTP sent to your email address.";
    }

*/

}