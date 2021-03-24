package com.goheeji.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("form",new Post());
        List<Post> posts = postService.findPosts();
        model.addAttribute("posts", posts);
        return "home";
    }

    @PostMapping("/")
    public String add(Post form){
        postService.add(form);
        //postService.remove(post);
        return "redirect:/";

    }

    @GetMapping("/{id}")
    public String remove(@PathVariable Long id){
        Post post = postRepository.findOne(id);
        postService.remove(post);
        return "redirect:/";
    }


}
