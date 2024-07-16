package api.forum_hub.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@Embeddable
public class User {

    @Column(unique = true)
    private String username;

    @Column(name = "display_name")
    private String displayName;

    public User(UserDto userDto) {
        this.username = userDto.username();
        this.displayName = userDto.displayName();
    }

    public void update(UserDto userDto) {
        if (userDto.username() != null) {
            this.username = userDto.username();
        }
        if (userDto.displayName() != null) {
            this.displayName = userDto.displayName();
        }
    }
}
