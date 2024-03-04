package practicemsa.communityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicemsa.communityservice.domain.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long> {
}
