package com.hrk.nikestore.modules.banner.repository;

import com.hrk.nikestore.modules.banner.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {
}
