package practicemsa.communityservice.domain;

import jakarta.persistence.*;

@Entity
public class Scrap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Posting posting;

    private Long user_id;
}
