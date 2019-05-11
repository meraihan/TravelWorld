package com.brainstation.socialmedia.TravelWorld.service;

import com.brainstation.socialmedia.TravelWorld.model.Posts;
import com.brainstation.socialmedia.TravelWorld.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Posts addPost(Posts post) {
        return postRepository.add(post);
    }

    public Posts getPost(int userId) {
        return postRepository.findPostByUserId(userId);
    }

}