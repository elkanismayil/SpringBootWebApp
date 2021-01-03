package com.company.springboot.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "123456789Ayla";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println("encodedPassword = " + encodedPassword);
    }
}
