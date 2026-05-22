package fr.nirahtech.devopsdemo.controllers;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.nirahtech.devopsdemo.domain.Post;
import fr.nirahtech.devopsdemo.repositories.PostsRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
@RequestMapping("/posts")
public class PostsRestController {

    private final PostsRepository postsRepository;
    private final MeterRegistry meterRegistry;
    private final Counter counter;
    private final Gauge gauge;


    private static final int bidule() {
        return 1;
    }


    public PostsRestController(PostsRepository postsRepository, MeterRegistry meterRegistry) {
        this.postsRepository = postsRepository;
        this.meterRegistry = meterRegistry;

        this.counter = Counter.builder("post_bidule_total")
            .description("Nombre total de posts qui ont été créés.")
            .register(this.meterRegistry);

        this.gauge = Gauge.builder("post_bidule_count", PostsRestController::bidule).register(meterRegistry);
    }

    @GetMapping("")
    public Page<Post> findAllPosts(Pageable pageable, @RequestParam(name="user_id", required = false) Integer userId) {
        final Page<Post> posts;
        
        if (Objects.isNull(userId)) {
            posts = this.postsRepository.findAll(pageable);
        } else {
            posts = this.postsRepository.findAllByUserId(userId, pageable);
        }
        return posts;
    }

    @PostMapping("")
    public Post createPost(@RequestBody Post post) {
        this.counter.increment();
        return this.postsRepository.save(post);
    }
}
