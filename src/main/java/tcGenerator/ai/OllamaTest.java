package tcGenerator.ai;

import com.fasterxml.jackson.databind.ObjectMapper;
import tcGenerator.exporter.ExcelExporter;
import tcGenerator.model.FinalResponse;
import tcGenerator.model.OllamaResponse;
import tcGenerator.model.TestCase;
import tcGenerator.util.FileUtil;

public class OllamaTest {

	public static void main(String[] args) throws Exception {

		String requirementText = FileUtil.readFile("src/main/resources/requirement/NewRequirement.txt");

		String prompt = "You are a Senior QA Automation Engineer.\n\n"
				+ "Generate SOFTWARE TEST CASES both positives and negetives scenarios.\n\n"
				+ "Return JSON ONLY in this structure:\n\n" + "{\n" + "  \"testCases\": [\n" + "    {\n"
				+ "      \"id\": \"TC_001\",\n" + "      \"title\": \"Login\",\n" + "      \"type\": \"positive\",\n"
				+ "      \"steps\": [\"step1\"],\n" + "      \"expectedResult\": \"result\",\n"
				+ "      \"priority\": \"High\"\n" + "    }\n" + "  ]\n" + "}\n\n" + "Requirement:\n" + requirementText;

		String rawResponse = OllamaClient.generate(prompt);
		System.out.println("Response : " + rawResponse);

		ObjectMapper mapper = new ObjectMapper();

		OllamaResponse ollama = mapper.readValue(rawResponse, OllamaResponse.class);

		FinalResponse finalResponse = mapper.readValue(ollama.getResponse(), FinalResponse.class);

		System.out.println("======= FINAL TEST CASES =======");

		for (TestCase tc : finalResponse.getTestCases()) {
			System.out.println(tc.getId() + " | " + tc.getTitle() + " | " + tc.getType() + " | " + tc.getSteps() + " | "
					+ tc.getExpectedResult() + " | " + tc.getPriority());
		}
		ExcelExporter.export(finalResponse.getTestCases(),
				"src/main/java/tcGenerator/generator/output/CERtestcases.xlsx");
	}
}
