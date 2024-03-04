package practicemsa.communityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicemsa.communityservice.domain.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video,Long> {
}
