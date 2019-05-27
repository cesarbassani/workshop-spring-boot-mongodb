package com.cesarbassani.workshopmongo.services;

import com.cesarbassani.workshopmongo.domain.Post;
import com.cesarbassani.workshopmongo.repository.PostRepository;
import com.cesarbassani.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
//        return postRepository.findByTitleContainingIgnoreCase(text);
        return postRepository.searchTitle(text);
    }
}
