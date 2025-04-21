package poly.edu.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.Entity.Comment;

public interface CommentReposotory extends JpaRepository<Comment, Integer> {
    List<Comment> findByPost_PostId(int postId);
}