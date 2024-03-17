package com.example.Labs57.controllers;

import com.example.Labs57.models.Banner;
import com.example.Labs57.models.enums.Role;
import com.example.Labs57.services.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainPageController {
    private final BannerService bannerService;
    @GetMapping("/")
    public String banners(@RequestParam(name = "title",required = false) String title, Principal principal, Model model) {
        model.addAttribute("banners",bannerService.listBanners(title));
        model.addAttribute("user",bannerService.getUserByPrincipal(principal));
        return "banners";
    }
    @GetMapping("/banner/{id}")
    public String bannerInfo(@PathVariable Long id, Principal principal, Model model){
        Banner banner = bannerService.getBannerById(id);
        model.addAttribute("banner",banner);
        model.addAttribute("images", banner.getImages());
        model.addAttribute("user",bannerService.getUserByPrincipal(principal));
        return "banner-info";

    }

    @PostMapping("/banner/create")
    public String createBanner(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, @RequestParam("file3") MultipartFile file3, Banner banner, Principal principal) throws IOException {
        bannerService.saveBanner(principal, banner, file1,file2,file3);
        return "redirect:/";
    }
    @PostMapping("/banner/delete/{id}")
    public String deleteBanner(@PathVariable Long id){
        bannerService.deleteBanner(id);
        return "redirect:/";
    }

}
