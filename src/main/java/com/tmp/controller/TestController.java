package com.df.web.controller;

import com.df.bac.bean.SceneImage;
import com.df.bac.dao.SceneImageMapper;
import com.df.bac.service.ProductListService;
import com.df.bac.service.SceneImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    SceneImageService sceneImageService;

    @Autowired
    ProductListService productListService;
    @Autowired
    SceneImageMapper sceneImageMapper;

    @GetMapping("/test")
    public String test(Model model) {
        String productId = "f9769fcd-e3cc-4060-b2f5-3dd6edb8e63b";
        List<SceneImage> images = sceneImageService.findSceneImagesBySceneId(productId);
        model.addAttribute("rel_products",images);
        return "fragments/content/product/cus_carouse_product_detail_rel";
    }

}

