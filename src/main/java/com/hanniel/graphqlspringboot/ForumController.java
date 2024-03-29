package com.hanniel.graphqlspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class ForumController {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

//    @SchemaMapping(typeName = "Query", value = "postById")
    @QueryMapping
    public Post postById(@Argument String id){
        System.out.println("postById");
        return postService.postById(id);
    }

    @MutationMapping
    public Collection<Post> createPost(@Argument String content){
        return postService.createPost(content);
    }

    @MutationMapping
    public Collection<Comment> createComment(@Argument String content,@Argument String postId){
        return commentService.createComment(content, postId);
    }

    @SchemaMapping
    public Collection<Comment> comments(Post post) {
        System.out.println("Comments");
        return commentService.findByPost(post.id());
    }
}
