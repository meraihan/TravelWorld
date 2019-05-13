package com.brainstation.socialmedia.TravelWorld.repository;

import com.brainstation.socialmedia.TravelWorld.model.User;
import com.brainstation.socialmedia.TravelWorld.utils.Helper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void userTest(){
        User user = new User();
        user.setFullName("Test Name");
        user.setUserName("test");
        user.setPassword(Helper.bCryptEncoder.encode("aaaaa@"));
        user.setEmail("test@gmail.com");
        user.setAddress("Araambag, Dhaka-1000");
        user.setIsActive(true);
        user.setGender(User.Gender.MALE);
        user.setRole(User.Role.USER);
        Number insertedId = userRepository.add(user).getId();
        Assert.assertNotNull(insertedId);
    }
}
