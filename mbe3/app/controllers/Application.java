package controllers;

import java.util.List;

import models.Post;
import play.mvc.Controller;

public class Application extends Controller {
    public static void index() {
        Post frontPost = Post.find("order by postedAt desc").first();
        List<Post> olderPosts = Post.find(
            "order by postedAt desc"
        ).from(1).fetch(10);
        render(frontPost, olderPosts);
    }
    
    public static void show(Long id) {
        Post post = Post.findById(id);
        render(post);
    }
    
    public static void postComment(Long postId, String author, String content) {
        Post post = Post.findById(postId);
        post.addComment(author, content);
        show(postId);
    }
}