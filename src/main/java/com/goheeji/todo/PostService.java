package com.goheeji.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class PostService
{
    private final PostRepository postRepository;
    public Long add(Post post){
        postRepository.save(post);
        return post.getId();
    }

    public void remove(Post post) {
        Post post1 = postRepository.findOne(post.getId());
       postRepository.remove(post1);
    }

    public List<Post> findPosts() {
        return postRepository.findAll();
    }
}
