package practicemsa.communityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicemsa.communityservice.domain.Photo;

import java.util.Optional;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long> {
    Optional<Photo> findByUrl(String url);

    void deleteByUrl(String url);
}
