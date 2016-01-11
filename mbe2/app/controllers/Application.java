package controllers;

import java.util.List;

import models.Post;
import play.mvc.Controller;

public class Application extends Controller {
	public static void index() {
        Post frontPost = Post.find("order by postedAt desc").first();
        render(frontPost);
    }
    
	public static void show(Long id) {
        render();
    }
}