package practicemsa.communityservice.domain;

import jakarta.persistence.*;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;//이미지 태크의 식별자

    private String url;

    @ManyToOne
    @JoinColumn
    private Photo photo;
}
