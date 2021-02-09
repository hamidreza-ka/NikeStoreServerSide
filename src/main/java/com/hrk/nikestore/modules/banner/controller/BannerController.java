package com.hrk.nikestore.modules.banner.controller;

import com.hrk.nikestore.modules.banner.model.Banner;
import com.hrk.nikestore.modules.banner.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController {

    private final BannerService bannerService;

    @Autowired
    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @RequestMapping(value = "/slider", method = RequestMethod.GET)
    public List<Banner> getBanners(){
        return bannerService.getBanners();
    }
}
