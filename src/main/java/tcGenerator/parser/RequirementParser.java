package tcGenerator.parser;

import tcGenerator.util.FileUtil;

public class RequirementParser {

	public static void main(String[] args) {
		
		String filePath= System.getProperty("user.dir")+ "//src//main//resources//requirement//login.txt";
		String requirementText= FileUtil.readFile(filePath);
		
		System.out.println("======== Requirement Text ========");
		System.out.println(requirementText);
	}

}
