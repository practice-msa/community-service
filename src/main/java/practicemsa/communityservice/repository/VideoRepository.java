package practicemsa.communityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicemsa.communityservice.domain.Photo;
import practicemsa.communityservice.domain.Video;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video,Long> {
    Optional<Video> findByUrl(String url);
}
