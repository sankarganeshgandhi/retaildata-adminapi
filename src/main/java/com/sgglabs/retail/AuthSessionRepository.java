package com.sgglabs.retail;

import com.sgglabs.retail.model.AuthSession;
import com.sgglabs.retail.model.User;
import org.springframework.data.repository.CrudRepository;

public interface AuthSessionRepository extends CrudRepository<AuthSession, Long> {
    public AuthSession findByUserName(final String userName);
}