package poly.edu.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.Entity.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {
    int countByPost_PostId(int postId);
    boolean existsByUser_UserIdAndPost_PostId(int userId, int postId);
}
