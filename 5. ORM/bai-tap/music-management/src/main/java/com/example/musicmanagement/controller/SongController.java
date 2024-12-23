package com.example.musicmanagement.controller;

import com.example.musicmanagement.model.Song;
import com.example.musicmanagement.service.ISongService;
import com.example.musicmanagement.service.impl.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    private ISongService songService = new SongService();

    @GetMapping
    public String list(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "songs/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("song", new Song());
        return "songs/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Song song) {
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "songs/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable int id, @ModelAttribute Song song) {
        song.setId(id);
        songService.update(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        songService.remove(id);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/play")
    public String play(@PathVariable int id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "songs/play";
    }
}
