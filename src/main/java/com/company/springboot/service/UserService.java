package com.company.springboot.service;

import com.company.springboot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserService {
    Page<User> getUsers(int pageNumber);
    void saveUser(User user);
    void updateUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);
    Page<User> findPaginated(int pageNo, int pageSize);
}
