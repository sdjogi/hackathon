package com.main.app;
import java.io.Serializable;

import javax.imageio.stream.ImageOutputStream;



/**
 * @author jogish
 */
/**
 * @author jogish
 */
public class RetrunCaptchaBean implements Serializable{

    /**
     *  <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    private String id;

    private ImageOutputStream file;


    public ImageOutputStream getFile() {
        return file;
    }


    public void setFile(ImageOutputStream iostream) {
        this.file = iostream;
    }



    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



}
