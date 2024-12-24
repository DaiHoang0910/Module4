package com.example.music.controller;

import com.example.music.model.Song;
import com.example.music.service.IService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private IService songService;

    @GetMapping
    public String listSongs(Model model) {
        model.addAttribute("songs", songService.getAllSongs());
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("song", new Song());
        return "add";
    }

    @PostMapping("/add")
    public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        songService.saveSong(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Song song = songService.getSongById(id);
        if (song == null) {
            return "redirect:/songs";
        }
        model.addAttribute("song", song);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateSong(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit";
        }
        songService.updateSong(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/delete")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return "redirect:/songs";
    }
}
