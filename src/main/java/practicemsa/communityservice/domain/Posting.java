package practicemsa.communityservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Posting {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String userName;

    private String title;

    private String content;

    @OneToMany(mappedBy = "posting")
    private List<Photo> photoList=new ArrayList<>();

    @OneToMany(mappedBy = "posting")
    private List<Video> videoList=new ArrayList<>();

    @OneToMany(mappedBy = "posting")
    private List<HashtagPosting> hashtagPostingList=new ArrayList<>();

    @OneToMany(mappedBy = "posting")
    private List<Comment> commentList=new ArrayList<>();

    @OneToMany(mappedBy = "posting")
    private List<Likes> greatList=new ArrayList<>();

    @OneToMany(mappedBy = "posting")
    private List<Scrap>scrapList=new ArrayList<>();

    private int hits=0;

    public Posting(){

    }


}