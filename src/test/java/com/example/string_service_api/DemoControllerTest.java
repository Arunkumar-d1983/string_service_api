package com.example.string_service_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import com.example.string_service_api.controller.DemoController;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.JsonNode;

@WebMvcTest(DemoController.class)
public class DemoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void testRemoveFirstAndLast_validStrings() throws Exception {
		String[] inputs = { "eloquent", "country", "xyz", "*123*%qwerty+" };
		for (String input : inputs) {
			String json = mockMvc.perform(get("/api/remove?input=" + input))
					.andExpect(status().isOk())
					.andReturn().getResponse().getContentAsString();

			JsonNode node = objectMapper.readTree(json);
			System.out.println("Input: " + node.get("input").asText()
					+ " → Output: " + node.get("result").asText());
		}
	}

	@Test
	void testRemoveFirstAndLast_twoCharacters() throws Exception {
		String json = mockMvc.perform(get("/api/remove").param("input", "ab"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		JsonNode node = objectMapper.readTree(json);

		System.out.println("Input: " + node.get("input").asText()
				+ " → Output: \"" + node.get("result").asText() + "\" (expected: empty string)");
	}

	@Test
	void testRemoveFirstAndLast_tooShort() throws Exception {
		String[] inputs = { "a", "" };

		for (String input : inputs) {
			String json = mockMvc.perform(get("/api/remove").param("input", input))
					.andExpect(status().isBadRequest())
					.andReturn().getResponse().getContentAsString();

			JsonNode node = objectMapper.readTree(json);
			System.out.println("Input: " + (input.isEmpty() ? "(empty string)" : input)
					+ " → Error: " + node.get("error").asText());
		}
	}
}
