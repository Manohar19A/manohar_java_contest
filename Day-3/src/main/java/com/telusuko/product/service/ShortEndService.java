package com.telusuko.product.service;

import java.util.HashSet;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusuko.product.entity.ShortEndUrl;
import com.telusuko.product.repository.ShortEndRepo;

@Service
public class ShortEndService {
	@Autowired
	private ShortEndRepo shortEndRepo;
	Random random = new Random();
	 HashSet <String> urls = new HashSet<>();
	 public String removeSpecialCharacters(String url) {
	        url= url.replaceAll("[^a-zA-Z0-9]", "");  
	        //System.out.println(url);
	        urls.add(url);
	        return url;
	    }
	public ShortEndUrl saveUrl(String str) {
		ShortEndUrl se = new ShortEndUrl();
        String chars= str;
        String sURL="";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<8;i++){
            sb.append(chars.charAt(random.nextInt(chars.length()-1)));
        }
        sURL = sb.toString();
        String urls =this.removeSpecialCharacters(sURL);
        System.out.print("telusu.ko/"+urls);
        return se.setShorturl("telusu.ko/"+urls);
    }

}
