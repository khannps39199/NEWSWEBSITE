package poly.edu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.Entity.Share;

public interface ShareRepository extends JpaRepository<Share, Integer> {
    int countByPost_PostId(int postId);
}
