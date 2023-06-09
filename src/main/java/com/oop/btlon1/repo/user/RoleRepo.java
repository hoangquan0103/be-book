package com.oop.btlon1.repo.user;

import com.oop.btlon1.entity.user.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepo extends MongoRepository<Role, String> {
    Role findByName(String name);
}
