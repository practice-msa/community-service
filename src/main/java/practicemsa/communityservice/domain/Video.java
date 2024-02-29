package practicemsa.communityservice.domain;

import jakarta.persistence.*;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;//동영상 태크의 식별자

    private String url;

    @ManyToOne
    @JoinColumn
    private Posting posting;
}
