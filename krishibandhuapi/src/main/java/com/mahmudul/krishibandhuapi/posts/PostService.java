package com.mahmudul.krishibandhuapi.posts;

import org.springframework.stereotype.Service;

import com.mahmudul.krishibandhuapi.exceptions.posts.PostNotFoundException;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post createPost(Post nwPost){
        return postRepository.save(nwPost);
    }

    public Post getPostById(Long postId){
        return postRepository.findById(postId)
                .orElseThrow(()-> new PostNotFoundException("Post Not Found with Id : " + postId));
    }

    public Post updatePost(Post mPost, Long postId){
        return postRepository.findById(postId)
                .map(post -> {
                    post.setDescription(mPost.getDescription());
                    post.setHeading(mPost.getHeading());
                    post.setTags(mPost.getTags());
                    return postRepository.save(post);
                }).orElseThrow(()-> new PostNotFoundException("Post Not Found with Id : " + postId));
    }

    public void deletePost(Long postId){
        if(!postRepository.existsById(postId)){
            throw new PostNotFoundException("Post Not Found with Id : " + postId);
        }
        postRepository.deleteById(postId);
    }
}
