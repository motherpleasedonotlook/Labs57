package com.example.Labs57.services;

import com.example.Labs57.models.Banner;
import com.example.Labs57.models.Image;
import com.example.Labs57.repositories.BannerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BannerService {
   private final BannerRepository bannerRepository;

   public List<Banner> listBanners(String title){
      if (title!=null) return bannerRepository.findByTitle(title);
      return bannerRepository.findAll();
   }
   public void saveBanner(Banner banner, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
      Image image1;
      Image image2;
      Image image3;
      if (file1.getSize() !=0){
         image1 = toImageEntity(file1);
         image1.setPreviewImage(true);
         banner.addImageToBanner(image1);
      }
      if (file2.getSize() !=0){
         image2 = toImageEntity(file2);
         banner.addImageToBanner(image2);
      }
      if (file3.getSize() !=0){
         image3 = toImageEntity(file3);
         banner.addImageToBanner(image3);
      }
      log.info("Saving new Banner. Title:{}; Author:{}",banner.getTitle(),banner.getAuthor());
      Banner bannerFromDb = bannerRepository.save(banner);
      bannerFromDb.setPreviewImageId(bannerFromDb.getImages().get(0).getId());
      bannerRepository.save(banner);
   }

   private Image toImageEntity(MultipartFile file) throws IOException {
      Image image = new Image();
      image.setSize(file.getSize());
      image.setName(file.getName());
      image.setOriginalFileName(file.getOriginalFilename());
      image.setContentType(file.getContentType());
      image.setBytes(file.getBytes());
      return image;
   }

   public void deleteBanner(Long id){
      bannerRepository.deleteById(id);
   }
   public Banner getBannerById(Long id){
      return bannerRepository.findById(id).orElse(null);
   }
}
