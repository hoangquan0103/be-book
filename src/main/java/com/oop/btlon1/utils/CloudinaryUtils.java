package com.oop.btlon1.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.IOException;
import java.util.Map;

public class CloudinaryUtils {

    static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dw7daicgc",
            "api_key", "847732192456115",
            "api_secret", "l-1eQg6cJbrd4pK71BSsj5aUEYE"));

    public static String uploadImg(byte[] file, String fileName) {
        try {
            Map<Object, Object> rs =  cloudinary.uploader().upload(file,
                    ObjectUtils.asMap("public_id", fileName));
            for (Object key :
                    rs.keySet()) {
                System.out.println(key + ": " + rs.get(key));
            }

            return (String) rs.get("url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteImg(String name) {
        try {
            Map<Object, Object> rs =  cloudinary.uploader().destroy(name, ObjectUtils.asMap("resource_type", "image"));
            for (Object key :
                    rs.keySet()) {
                System.out.println(key + ": " + rs.get(key));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        deleteImg("longthansdfghjk");
    }
}
