package practicemsa.communityservice.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hashtag {

    @Id
    private String id;

    @OneToMany(mappedBy = "hashtagPosting")
    private List<HashtagPosting> hashtagPostingList=new ArrayList<>();


}
