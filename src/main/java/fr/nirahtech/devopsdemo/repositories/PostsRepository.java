package fr.nirahtech.devopsdemo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.nirahtech.devopsdemo.domain.Post;

@Repository
public interface PostsRepository extends JpaRepository<Post, Integer> {
    Page<Post> findAllByUserId(Integer userId, Pageable pageable);
}
