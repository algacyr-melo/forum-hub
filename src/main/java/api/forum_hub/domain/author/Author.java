package api.forum_hub.domain.author;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@Embeddable
public class Author {

    private String username;

    @Column(name = "display_name")
    private String displayName;

    public Author(AuthorDto authorDto) {
        this.username = authorDto.username();
        this.displayName = authorDto.displayName();
    }

    public void update(AuthorDto authorDto) {
        if (authorDto.username() != null) {
            this.username = authorDto.username();
        }
        if (authorDto.displayName() != null) {
            this.displayName = authorDto.displayName();
        }
    }
}
