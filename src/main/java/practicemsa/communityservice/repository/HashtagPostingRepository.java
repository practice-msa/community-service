package practicemsa.communityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practicemsa.communityservice.domain.HashtagPosting;

public interface HashtagPostingRepository extends JpaRepository<HashtagPosting,Long> {
}
