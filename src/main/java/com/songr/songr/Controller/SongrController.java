package com.songr.songr.Controller;

import com.songr.songr.Model.AlbumModel;
import com.songr.songr.Model.Song;
import com.songr.songr.Repositories.AlbumRepository;
import com.songr.songr.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping(
//        method={RequestMethod.POST,RequestMethod.GET}
//)
public class SongrController {

    @Autowired
    AlbumRepository AlbumRepository;

    @Autowired
    SongRepository SongRepository;

    //// Home page
    @GetMapping("/")
    public String Home(){
        return "Home";
    }

    //// Create a hello world route
    @GetMapping("/hello")
    @ResponseBody
    public String helloworld () {
        return "Hello World";
    }

    //// Create a route that turns words into UPPER CASE
    @GetMapping("/capitalize/{text}")
    @ResponseBody
    public String capitalize(@PathVariable String text){
    return text.toUpperCase();
    }

    //// Create an Album class to act as a model in our app
@GetMapping("/albums")
public String albumPage(Model model){
    List<AlbumModel> albums = AlbumRepository.findAll();
    model.addAttribute("albums", albums);
    return "Albums";
}
    //// for add albums
    @PostMapping("/addalbums")
    public RedirectView newAlbum(String title, String artist, int songCount, int length, String imageURL){
        AlbumModel newAlbum = new AlbumModel(title, artist, songCount, length, imageURL);
        AlbumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }

    @GetMapping("/album/{id}")
    public String IdaAlbum(Model model,@PathVariable long id){
        AlbumModel album = AlbumRepository.findById(id).get();
        model.addAttribute("album", album);
        List<Song> song= SongRepository.findByTitle(album.getTitle());
        model.addAttribute("song", song);
        return "IdAlbum";
    }

    @GetMapping("/songs")
    public String getSongs(Model model){
        List<Song> song=SongRepository.findAll();
        model.addAttribute("song",song);
        return "Songs";
    }

    @PostMapping("/addsong")
    public RedirectView addSong(Song song, Model model,@RequestParam long IdAlbum){
        AlbumModel album = AlbumRepository.findById(IdAlbum).get();
        model.addAttribute("song", song);
        Song newSong = new Song(song.getTitle(), song.getLength() , album);
        SongRepository.save(newSong);
        return new RedirectView("/album/" + IdAlbum);
    }


}


