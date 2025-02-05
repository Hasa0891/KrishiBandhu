package com.mahmudul.krishibandhuapi.dtos;

import com.mahmudul.krishibandhuapi.posts.Post;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PostDTO {

    @NotBlank
    private String heading;
    
    @NotBlank
    private String tags;
    
    @NotBlank
    private String description;

    public Post toPostEntity(){
        Post post = new Post();
        post.setHeading(heading);
        post.setTags(tags);
        post.setDescription(description);
        return post;
    }
}
