package com.sgglabs.retail;

import com.sgglabs.retail.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUserName(final String userName);
}