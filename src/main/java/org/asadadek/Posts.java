package org.asadadek;

import org.asadadek.models.Post;
import org.asadadek.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;


/**
 * Created by abhay on 16-04-2017.
 */

@RestController
@RequestMapping("/posts")
public class Posts {


    @Autowired
    private PostRepository repo;


    @PostMapping( produces = "application/json")
    public Post newPost(@RequestParam String title){
        Post post = new Post(title);
        repo.save(post);
        return post;
    }

    @GetMapping( produces = "application/json")
    public List<Post> findByTitle(@RequestParam String pattern){
        return repo.findByTitleContaining(pattern);
    }

    @GetMapping(value = "/{id}", produces = "application/json" )
    public Mono<Post> findById(@PathVariable Integer id) {

        Mono<Post> mono = Mono.defer(() -> Mono.just(findOne(id)));
        System.out.println("Are we async ?");
        return mono;
    }

    private Post findOne(Integer id){
        System.out.println("Yes...???");
        return repo.findOne(id).get();
    }
}
