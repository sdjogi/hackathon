
package com.main.app;

/**
 * @author jogish
 */
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.UniColorBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomListColorGenerator;
import com.octo.captcha.component.image.deformation.ImageDeformation;
import com.octo.captcha.component.image.deformation.ImageDeformationByFilters;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.DeformedComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;

@RestController
public class CaptchaController {

    @RequestMapping("/getCaptcha")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getImage() {
        File outputfile = new File("C:\\Users\\jogish\\Desktop\\saved.png");
        try{

            int minWordLength = 4;
            int maxWordLength = 5;
            int fontSize = 20;
            int imageWidth = 100;
            int imageHeight = 36;
            final ImageDeformation backDef = new ImageDeformationByFilters(new java.awt.image.ImageFilter[] {});
            final ImageDeformation textDef = new ImageDeformationByFilters(new java.awt.image.ImageFilter[] {});
            final ImageDeformation postDef = new ImageDeformationByFilters(new java.awt.image.ImageFilter[] {});
            TextPaster randomPaster = new DecoratedRandomTextPaster(minWordLength, maxWordLength,
                    new RandomListColorGenerator(new java.awt.Color[] { new java.awt.Color(23, 170, 27),
                            new java.awt.Color(220, 34, 11), new java.awt.Color(23, 67, 172) }), new TextDecorator[] {});
            BackgroundGenerator background = new UniColorBackgroundGenerator(imageWidth, imageHeight,
                    java.awt.Color.white);
            FontGenerator font = new RandomFontGenerator(fontSize, fontSize);
            final WordToImage word2image = new DeformedComposedWordToImage(font, background, randomPaster, backDef,
                    textDef, postDef);
            java.awt.image.BufferedImage img = word2image.getImage(getCaptcha());
            ImageIO.write(img, "png", outputfile);

        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.ok(outputfile, MediaType.APPLICATION_OCTET_STREAM).header("content-disposition","attachment; filename = "+outputfile.getName()).build();

    }

    String getCaptcha() {
        Random random = new Random();
        int length = 4;
        StringBuffer captchaStringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++){
            int captchaNumber = Math.abs(random.nextInt()) % 60;
            int charNumber = 0;
            if(captchaNumber < 26){
                charNumber = 65 + captchaNumber;
            }else if(captchaNumber < 52){
                charNumber = 97 + (captchaNumber - 26);
            }else{
                charNumber = 48 + (captchaNumber - 52);
            }
            captchaStringBuffer.append((char) charNumber);
        }

        return captchaStringBuffer.toString();
    }

}