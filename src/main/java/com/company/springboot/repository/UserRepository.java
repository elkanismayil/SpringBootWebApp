package com.company.springboot.repository;

import com.company.springboot.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

//    @Transactional
//    @Modifying
//    @Query("update User u set u.email = ?1, u.firstName = ?2, u.lastName = ?3 where u.id = ?4")
//    void setUserInfoById(String email, String firstName, String lastName, Integer userId);
}
