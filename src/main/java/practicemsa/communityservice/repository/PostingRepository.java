package practicemsa.communityservice.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import practicemsa.communityservice.domain.Posting;

@Repository
public interface PostingRepository extends JpaRepository<Posting,Long> {



}
