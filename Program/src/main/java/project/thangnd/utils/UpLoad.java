package project.thangnd.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class UpLoad {
	public String uploadFile(MultipartFile file){
		if(!file.isEmpty()){
			try {
				byte[] bytes = file.getBytes();
                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "images");
                if (!dir.exists())
                    dir.mkdirs();
                // Create the file on server
                String name = String.valueOf(new Date().getTime()) + ".png";
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                return name;
                } catch (Exception e) {
				e.printStackTrace();
				System.out.println("File error");
			}
			
		}else{
			System.out.println("File not found");
		}
		return null;
	}
		
}
