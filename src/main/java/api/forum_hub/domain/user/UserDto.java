package api.forum_hub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record UserDto
(
    @NotBlank
    String username,

    @NotBlank
    String displayName
) {

    public UserDto(UserDto userDto) {
        this(userDto.username(), userDto.displayName());
    }
}
