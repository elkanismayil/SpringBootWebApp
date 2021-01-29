package com.company.springboot.service;

import com.company.springboot.entity.User;
import com.company.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository repository;

    @Override
    public Page<User> getUsers(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 5);
        return repository.findAll(pageable);
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public void updateUser(User user) {
        repository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id).get();
    }


    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<User> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.repository.findAll(pageable);
    }


}
