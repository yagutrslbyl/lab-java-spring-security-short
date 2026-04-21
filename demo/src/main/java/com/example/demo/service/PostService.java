package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Post;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    public Post addPost(Post post, Integer authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        post.setAuthor(author);
        return postRepository.save(post);
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public void delete(Integer id) {
        postRepository.deleteById(id);
    }


}
