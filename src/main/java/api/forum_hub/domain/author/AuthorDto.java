package api.forum_hub.domain.author;

import jakarta.validation.constraints.NotBlank;

public record AuthorDto
(
    @NotBlank
    String username,

    @NotBlank
    String displayName
) {

    public AuthorDto(AuthorDto authorDto) {
        this(authorDto.username(), authorDto.displayName());
    }
}
