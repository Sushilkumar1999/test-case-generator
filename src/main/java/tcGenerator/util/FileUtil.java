package tcGenerator.util;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
	
	public static String readFile(String filePath) {
		try {
			return Files.readString(Paths.get(filePath));
		}catch(Exception e) {
			throw new RuntimeException("Failed to read the requirement",e);
		}
	}
}
