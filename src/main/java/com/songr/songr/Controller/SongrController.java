package com.songr.songr.Controller;

import com.songr.songr.Model.AlbumModel;
import com.songr.songr.Repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(
        method={RequestMethod.POST,RequestMethod.GET}
)
public class SongrController {

    @Autowired
    AlbumRepository AlbumRepository;

    ////////// Create a hello world route
    @GetMapping("/hello")
    @ResponseBody
    public String helloworld () {
        return "Hello World";
    }

    ////////// Create a route that turns words into UPPER CASE
    @GetMapping("/capitalize/{text}")
    @ResponseBody
    public String capitalize(@PathVariable String text){
    return text.toUpperCase();
    }

//    ////////// Create an Album class to act as a model in our app
@GetMapping("/albums")
public String albumPage(Model model){
    List<AlbumModel> albums = AlbumRepository.findAll();
    model.addAttribute("albums", albums);
    return "Albums";
}

    @PostMapping("/addalbums")
    public RedirectView createAlbum(String title, String artist, int songCount, int lengthInS, String imageURL){
        AlbumModel newAlbum = new AlbumModel(title, artist, songCount, lengthInS, imageURL);
        AlbumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }

    //////////
    @GetMapping("/")
    public String Home(){
        return "Home";
    }



}


