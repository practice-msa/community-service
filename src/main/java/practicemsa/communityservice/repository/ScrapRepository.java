package practicemsa.communityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practicemsa.communityservice.domain.Scrap;

public interface ScrapRepository extends JpaRepository<Scrap,Long> {
}
