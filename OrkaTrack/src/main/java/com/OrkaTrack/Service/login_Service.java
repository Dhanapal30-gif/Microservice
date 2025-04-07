package com.OrkaTrack.Service;

import com.OrkaTrack.Entity.emp_Login;
import com.OrkaTrack.Entity.orkaRegister;
import com.OrkaTrack.Repository.login_repo;
import com.OrkaTrack.Repository.reg_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class login_Service {
    @Autowired
    public login_repo loginRepo;


    public boolean login(emp_Login emplogin) {
        orkaRegister emp=loginRepo.findByPassword(emplogin.getPassword());
        System.out.println("emp"+emp);
        if(emp!=null){
            System.out.println("emp +emp ");
            return emplogin.password.equals(emp.password);
        }
        return false;
    }
}
