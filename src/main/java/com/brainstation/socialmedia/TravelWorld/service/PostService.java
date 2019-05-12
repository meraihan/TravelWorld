package com.brainstation.socialmedia.TravelWorld.service;

import com.brainstation.socialmedia.TravelWorld.model.Posts;
import com.brainstation.socialmedia.TravelWorld.model.User;
import com.brainstation.socialmedia.TravelWorld.repository.PostRepository;
import com.brainstation.socialmedia.TravelWorld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    public List<Posts> findAllPost(){
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Posts> postsList = postRepository.findAll();
        List<Posts> list = new ArrayList<>();
        for (Posts post: postsList){
            if(post.getStatus()==Posts.Status.PUBLIC || post.getStatus()==Posts.Status.PRIVATE &&
                    post.getUser().getId()==user.getId()){
                list.add(post);
            }
        }
        return list;

    }

    public Posts addPost(Posts post) {
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        User user1 = new User();
        user1.setId(user.getId());
        post.setUser(user1);
        return postRepository.add(post);
    }

    public Posts getPost(int userId) {
        return postRepository.findPostByUserId(userId);
    }

}