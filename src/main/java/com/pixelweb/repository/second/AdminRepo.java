package com.pixelweb.repository.second;

import com.pixelweb.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<Admin,Long> {
    Admin findByNameAndPass(String name, String pass);
}
