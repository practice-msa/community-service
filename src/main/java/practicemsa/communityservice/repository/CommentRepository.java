package practicemsa.communityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicemsa.communityservice.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
