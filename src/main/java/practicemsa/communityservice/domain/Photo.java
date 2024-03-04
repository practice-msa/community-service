package practicemsa.communityservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Getter
public class Photo {

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

    public Photo(){

    }
    public Photo(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
