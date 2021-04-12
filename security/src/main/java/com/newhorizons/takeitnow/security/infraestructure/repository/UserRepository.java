package com.newhorizons.takeitnow.security.infraestructure.repository;

import com.newhorizons.takeitnow.security.domain.entity.UserApplication;
import com.newhorizons.takeitnow.security.domain.repository.IUserRepository;
import com.newhorizons.takeitnow.security.infraestructure.feign.IUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    private IUserFeign iUserFeign;

    public UserApplication authenticationByUsername(String username){
        return iUserFeign.authenticationByUsername(username);
    }
}
