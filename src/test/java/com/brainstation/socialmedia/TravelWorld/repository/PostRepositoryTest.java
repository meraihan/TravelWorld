package com.brainstation.socialmedia.TravelWorld.repository;

import com.brainstation.socialmedia.TravelWorld.model.Area;
import com.brainstation.socialmedia.TravelWorld.model.Posts;
import com.brainstation.socialmedia.TravelWorld.model.User;
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
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void postTest(){
        Posts posts = new Posts();
        posts.setPost("Hello ! I am Test");
        posts.setStatus(Posts.Status.PUBLIC);
        User user = new User();
        user.setId(1);
        posts.setUser(user);
        Area area = new Area();
        area.setId(2);
        posts.setArea(area);
        Number insertedId = postRepository.add(posts).getId();
        log.info("Inserted Posts Id:{}", insertedId);
        Assert.assertNotNull(insertedId);
    }

}
