package helper;

import java.io.FileInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

public class PathHelper {
	
	public static String completePath =""; 
	public static Properties p = new Properties() ;
			
	public PathHelper() {
		try {
			Path currrentDirectoryPath = FileSystems.getDefault().getPath("");
			String currentDirectoryName = currrentDirectoryPath.toAbsolutePath().toString();
			completePath = currentDirectoryName+"\\src\\resources\\db.properties";
			FileInputStream finf = new FileInputStream(completePath);
			p.load(finf);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
		
}
