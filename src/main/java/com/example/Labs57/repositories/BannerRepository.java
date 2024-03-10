package com.example.Labs57.repositories;

import com.example.Labs57.models.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner,Long> {
    List<Banner> findByTitle(String title);
}
