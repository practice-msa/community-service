package practicemsa.communityservice.domain;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Posting {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long userId;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String title;

    @NotEmpty
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
    private List<Likes> likesList=new ArrayList<>();

    @OneToMany(mappedBy = "posting")
    private List<Scrap>scrapList=new ArrayList<>();

    private int hits=0;

    public Posting(){

    }

    public Posting(Long userId, String userName, String title, String content,List<Photo>photoList,
                   List<Video>videoList,List<HashtagPosting>hashtagPostingList,
                   List<Comment>commentList,List<Likes>likesList,List<Scrap>scrapList) {
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.photoList=photoList;
        //photoList.stream().forEach(m->m);
        this.videoList=videoList;
        this.hashtagPostingList=hashtagPostingList;
        this.commentList=commentList;
        this.likesList=likesList;
        this.scrapList=scrapList;

        this.hits=0;
    }
}
