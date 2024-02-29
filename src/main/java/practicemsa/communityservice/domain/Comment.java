package practicemsa.communityservice.domain;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;

    private String user_name;

    private String content;

    @ManyToOne
    @JoinColumn
    private Posting posting;

}
