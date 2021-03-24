package com.goheeji.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PostServiceTest {

    @Autowired PostService postService;
    @Autowired PostRepository postRepository;

    @Test
    public void 추가() throws Exception{

        //Given
        Post post = new Post();
        post.setContent("오늘의 할일!");

        //When
        Long saveId = postService.add(post);

        //Then
        Assertions.assertEquals(post,postRepository.findOne(saveId));


    }

}