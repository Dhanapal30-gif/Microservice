package com.OrkaTrack.Repository;

import com.OrkaTrack.Entity.orkaRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface reg_repo extends JpaRepository<orkaRegister,Integer> {

    Optional<orkaRegister> findByEmpId(Integer empId);

    Optional<orkaRegister> findByEmpEmail(String empEmail);

    Optional<orkaRegister> findByEmpEmailIgnoreCase(String empEmail);

}
