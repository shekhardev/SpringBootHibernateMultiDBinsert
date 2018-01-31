package com.pixelweb.repository.first;

import com.pixelweb.model.User;
import org.springframework.data.repository.CrudRepository;

public interface FirstRepo extends CrudRepository<User,Long> {
    User findByNameAndPass(String name, String pass);
}
