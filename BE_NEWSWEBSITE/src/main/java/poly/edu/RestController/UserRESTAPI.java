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

import poly.edu.Entity.User;
import poly.edu.Repository.UserRepository;

@RestController
@CrossOrigin(origins ="*")
public class UserRESTAPI {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/api/user/{id}")
	public ResponseEntity<User> apiGetUserByUserName(@PathVariable String id) {
		if (!userRepo.existsByUserId(Integer.parseInt(id))) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userRepo.findByUserName(id));
	}
	
	@GetMapping("/api/user")
	public ResponseEntity<List<User>> apiGetUser() {
		return ResponseEntity.ok(userRepo.findAll());
	}
	
	@PostMapping("/api/user")
	public ResponseEntity<User> apiGetUser(@RequestBody User user) {
		if (userRepo.existsById(user.getUserId())) {
			return ResponseEntity.badRequest().build();
		}
		System.out.println(user);
		userRepo.save(user);
		return ResponseEntity.ok(user);
	}
	@PutMapping("/api/user/{id}")
	public ResponseEntity<User> apiUpdateUser(@PathVariable String id,@RequestBody User user) {
		if (!userRepo.existsById(user.getUserId())) {
			return ResponseEntity.badRequest().build();
		}
		userRepo.save(user);
		return ResponseEntity.ok(user);
	}
	@DeleteMapping("/api/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
	    if (!userRepo.existsByUserId(Integer.parseInt(id))) {
	        return ResponseEntity.notFound().build();
	    }
	    System.out.println("debug"+id);
	    userRepo.deleteByUserId(Integer.parseInt(id));
	    return ResponseEntity.ok().build();
	}
}
