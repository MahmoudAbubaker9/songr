package com.songr.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class SongrController {

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

    ////////// Create an Album class to act as a model in our app
    @GetMapping("/albums")
    public String Albums(Model model){
        AlbumModel album1 = new AlbumModel("The Shawshank Redemption", "Morgan Freeman",230,40,"https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1000_.jpg");
        AlbumModel album2 = new AlbumModel("The Godfather", "Marlon Brando",3,230,"https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg");
        AlbumModel album3 = new AlbumModel("The Godfather 2", "Marlon Brando",4,230,"https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctNDk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg");
        ArrayList<AlbumModel> allAlbums = new ArrayList<>();
        allAlbums.add(album1);
        allAlbums.add(album2);
        allAlbums.add(album3);
        model.addAttribute("albums",allAlbums);

        return "albums";
    }

    ////////// Create an Album class to act as a model in our app
    @GetMapping("/")
    public String Home(){
        return "Home";
    }



}


