package poly.edu.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.Entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser_UserId(int userId);
    List<Post> findByTitleContainingIgnoreCase(String title);
	boolean existsByPostId(Integer id);
	Post findByPostId(Integer postId);
	void deleteByPostId(  Integer id);
}