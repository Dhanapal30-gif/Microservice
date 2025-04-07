package com.OrkaTrack.Service;

import com.OrkaTrack.Entity.emp_Login;
import com.OrkaTrack.Entity.orkaRegister;
import com.OrkaTrack.Repository.reg_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class reg_Service {

    @Autowired
    public reg_repo reg_emprepo;

//    public orkaRegister regDetail(orkaRegister regDetail){
//    return reg_emprepo.save(regDetail);
//    }

    public String regDetail(orkaRegister regDetail) {
        try {
            Optional<orkaRegister> existingEmployee = reg_emprepo.findByEmpId(regDetail.getEmpId());

            if (existingEmployee.isPresent()) {
                return "Error: Employee ID already exists. Registration failed.";
            }

            reg_emprepo.save(regDetail);
            return "Registration successful!";
        } catch (Exception e) {
            // Log the exception for debugging
            System.err.println("Error: " + e.getMessage());
            // Return a generic error message
            return "Error: Something went wrong during registration.";
        }
    }

//    public boolean login(emp_Login empLogin) {
//            orkaRegister user=reg_emprepo.findByPassword(empLogin.getEmp_Password());
//            if(user!=null){
//                return empLogin.emp_Password.equals(user.emp_Password);
//            }
//            return false;
//
//    }
}
