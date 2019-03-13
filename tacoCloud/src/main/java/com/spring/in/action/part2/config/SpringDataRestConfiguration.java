package com.spring.in.action.part2.config;

import com.spring.in.action.part2.model.Taco;
import com.spring.in.action.part2.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.*;

import java.util.List;

@Configuration
public class SpringDataRestConfiguration {

    @Bean
    public ResourceProcessor<PagedResources<Resource<Taco>>> tacoProcessor(EntityLinks links) {

        return new ResourceProcessor<PagedResources<Resource<Taco>>>() {
            @Override
            public PagedResources<Resource<Taco>> process(
                    PagedResources<Resource<Taco>> resource) {
                resource.add(
                        links.linkFor(Taco.class)
                                .slash("recent")
                                .withRel("recents"));
                return resource;
            }
        };
    }

    @Bean
    public ResourceProcessor<Resources<Resource<User>>> userProcessor(EntityLinks links) {
        return new ResourceProcessor<Resources<Resource<User>>>() {
            @Override
            public Resources<Resource<User>> process(Resources<Resource<User>> resource) {
                resource.removeLinks();
                return resource;
            }
        };
    }
}
