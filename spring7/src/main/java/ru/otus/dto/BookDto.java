package ru.otus.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Data
@EqualsAndHashCode
public class BookDto {
    private Long id;
    private String name;
    private Integer yearIssue;
    private Integer numberPages;
    private List<GenreDto> genres;
    private List<AuthorDto> authors;
}