package practicemsa.communityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicemsa.communityservice.domain.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Long> {
}
