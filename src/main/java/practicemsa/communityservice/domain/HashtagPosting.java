package practicemsa.communityservice.domain;

import jakarta.persistence.*;

@Entity
public class HashtagPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Posting posting;

    @ManyToOne
    @JoinColumn
    private Hashtag hashtag;
}
