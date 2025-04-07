package com.OrkaTrack.Repository;

import com.OrkaTrack.Entity.orkaRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface login_repo extends JpaRepository<orkaRegister, Integer> {
    orkaRegister findByPassword(String Password);


}
