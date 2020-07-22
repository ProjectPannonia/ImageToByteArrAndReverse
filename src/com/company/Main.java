package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ByteArrayOutputStream baos = null;
        BufferedImage originalImage = null;
        byte[] imageInByte = null;
        try {
            originalImage = ImageIO.read(new File("D:\\ae.jpg"));
            baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage,"jpg",baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(imageInByte != null) System.out.println("Image converted to byte array successfully!");
        BufferedImage reBufferedImage = null;
        ByteArrayInputStream bais = null;

        try {
            bais = new ByteArrayInputStream(imageInByte);
            reBufferedImage = ImageIO.read(bais);
            File outputFile = new File("D:\\rebuffered.jpg");
            ImageIO.write(reBufferedImage,"jpg",outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
