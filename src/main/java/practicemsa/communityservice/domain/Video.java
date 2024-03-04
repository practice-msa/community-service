package practicemsa.communityservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private Posting posting;

    public void setPosting(Posting posting) {
        this.posting = posting;
    }

    public Video(){

    }

    public Video(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", posting=" + posting +
                '}';
    }
}
