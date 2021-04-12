package com.newhorizons.takeitnow.users.infraestructure.pas;

import com.newhorizons.takeitnow.users.domain.entity.UserApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "users")
public interface IUserRepository extends PagingAndSortingRepository<UserApplication, Long> {

    @RestResource(path = "findByUsername")
    UserApplication findByUsername(@Param("username") String username);

    @Query(value = "select u.* from users u where u.username=?1 and u.password=?2", nativeQuery = true)
    UserApplication signInApplication(String username, String password);
}
