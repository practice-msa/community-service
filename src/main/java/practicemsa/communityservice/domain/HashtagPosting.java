package practicemsa.communityservice.domain;

import jakarta.persistence.*;

@Entity
public class HashtagPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Posting posting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Hashtag hashtag;
}
