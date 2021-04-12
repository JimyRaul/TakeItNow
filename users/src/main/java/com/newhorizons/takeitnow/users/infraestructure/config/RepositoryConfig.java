package com.newhorizons.takeitnow.users.infraestructure.config;

import com.newhorizons.takeitnow.users.domain.entity.RoleApplication;
import com.newhorizons.takeitnow.users.domain.entity.UserApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(UserApplication.class, RoleApplication.class);
    }
}
