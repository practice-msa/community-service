package practicemsa.communityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicemsa.communityservice.domain.Hashtag;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag,String> {
}
