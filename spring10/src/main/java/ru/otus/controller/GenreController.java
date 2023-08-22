package ru.otus.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.dto.GenreDto;
import ru.otus.service.GenreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping("/api/genre")
    public List<GenreDto> getAllGenres() {
        return genreService.getAll();
    }

    @PostMapping("/api/genre")
    public GenreDto addGenre(@RequestBody GenreDto genre) {
        return genreService.create(genre);
    }
}