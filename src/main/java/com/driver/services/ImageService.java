package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
         Blog blog = blogRepository2.findById(blogId).get();
         Image image = new Image(blog , description , dimensions);

         blog.getImageList().add(image);
         blogRepository2.save(blog);
         return image;
    }

    public void deleteImage(Integer id){

        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        String [] scrArray = screenDimensions.split("X");

        Image image = imageRepository2.findById(id).get();

        String imageDimensions = image.getDimensions();
        String [] imgArray = imageDimensions.split("X");

        int scrl = Integer.parseInt(scrArray[0]);
        int scrb = Integer.parseInt(scrArray[1]);

        int imgl = Integer.parseInt(imgArray[0]);
        int imgb = Integer.parseInt(imgArray[1]);

        return no_Images(scrl,scrb,imgl, imgb);

    }

    private int no_Images(int scrl , int scrb , int imgl , int imgb){
        int lenC = scrl/imgl;
        int lenB = scrb/imgb;

        return lenB*lenC;
    }
}
