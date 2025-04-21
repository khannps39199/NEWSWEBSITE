package poly.edu.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import poly.edu.Entity.Post;
import poly.edu.Repository.PostRepository;
import poly.edu.Repository.UserRepository;

@RestController
@CrossOrigin(origins ="*")
public class PostRESTAPI {
	@Autowired
	private PostRepository postRepo;
	@GetMapping("/api/post/{id}")
	public ResponseEntity<Post> apiGetPostById(@PathVariable String id) {
		System.out.println("debug");
		if (!postRepo.existsById(Integer.parseInt(id))) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(postRepo.findByPostId(Integer.parseInt(id)));
	}
	
	@GetMapping("/api/post")
	public ResponseEntity<List<Post>> apiGetUser() {
		return ResponseEntity.ok(postRepo.findAll());
	}
	
	@PostMapping("/api/post")
	public ResponseEntity<Post> apiGetUser(@RequestBody Post user) {
		if (postRepo.existsById(user.getPostId())) {
			return ResponseEntity.badRequest().build();
		}
		postRepo.save(user);
		return ResponseEntity.ok(user);
	}
	@PutMapping("/api/post/{id}")
	public ResponseEntity<Post> apiUpdateUser(@PathVariable String id,@RequestBody Post user) {
		if (!postRepo.existsById(user.getPostId())) {
			return ResponseEntity.badRequest().build();
		}
		postRepo.save(user);
		return ResponseEntity.ok(user);
	}
	@DeleteMapping("/api/post/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
	    if (!postRepo.existsByPostId(Integer.parseInt(id))) {
	        return ResponseEntity.notFound().build();
	    }
	    postRepo.deleteByPostId(Integer.parseInt(id));
	    return ResponseEntity.ok().build();
	}
}
