package com.newhorizons.takeitnow.security.domain.repository;

import com.newhorizons.takeitnow.security.domain.entity.UserApplication;

public interface IUserRepository {
    UserApplication authenticationByUsername(String username);
}
