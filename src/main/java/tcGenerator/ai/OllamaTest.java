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
		System.out.println("requirementText: " + requirementText);

		String prompt = "You are a Senior QA Automation Engineer.\n\n" +

				"Generate COMPLETE software test cases covering ALL modules:\n" + "1. Login\n" + "2. Product Listing\n"
				+ "3. Add to Cart\n" + "4. Checkout\n" + "5. Order Placement\n\n" +

				"Include BOTH positive and negative scenarios for EACH module.\n\n" +

				"IMPORTANT RULES:\n" + "- Do NOT focus only on Login.\n" + "- Every feature must have test cases.\n"
				+ "- Output VALID JSON only.\n" + "- No explanations outside JSON.\n\n" +

				"Return JSON STRICTLY in this structure:\n\n" +

				"{\n" + "  \"testCases\": [\n" + "    {\n" + "      \"id\": \"TC_1\",\n"
				+ "      \"title\": \"<short title>\",\n" + "      \"type\": \"positive|negative\",\n"
				+ "      \"steps\": [\"step1\", \"step2\"],\n" + "      \"expectedResult\": \"result\",\n"
				+ "      \"priority\": \"High|Medium|Low\"\n" + "    }\n" + "  ]\n" + "}\n\n" +

				"Generate MULTIPLE test cases per module.\n\n" +

				"Requirement:\n" + requirementText;

		String rawResponse = OllamaClient.generate(prompt);
		System.out.println("Response : " + rawResponse);

		ObjectMapper mapper = new ObjectMapper();

		OllamaResponse ollama = mapper.readValue(rawResponse, OllamaResponse.class);

		FinalResponse finalResponse = mapper.readValue(ollama.getResponse(), FinalResponse.class);
		System.out.println("Final formatted response : " + finalResponse);

		System.out.println("======= FINAL TEST CASES =======");

		for (TestCase tc : finalResponse.getTestCases()) {
			System.out.println(tc.getId() + " | " + tc.getTitle() + " | " + tc.getType() + " | " + tc.getSteps() + " | "
					+ tc.getExpectedResult() + " | " + tc.getPriority());
		}
		ExcelExporter.export(finalResponse.getTestCases(),
				"src/main/java/tcGenerator/generator/output/CERtestcases.xlsx");
	}
}
