package com.hrk.nikestore.modules.banner.service;

import com.hrk.nikestore.modules.banner.model.Banner;
import com.hrk.nikestore.modules.banner.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {

    private final BannerRepository bannerRepository;

    @Autowired
    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    public List<Banner> getBanners(){
        return bannerRepository.findAll();
    }
}
