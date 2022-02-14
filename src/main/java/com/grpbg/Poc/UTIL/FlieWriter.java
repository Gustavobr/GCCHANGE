package com.grpbg.Poc.UTIL;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

import com.google.gson.JsonObject;

public class FlieWriter {

	public static void main(String[] args) throws IOException {
		JSONObject json = new JSONObject();
		JSONObject template = new JSONObject();
		JSONObject requester = new JSONObject();
		template.put("number", "MM-0116");
		template.put("briefDescription", "01 - Requisição - Change");
		json.put("template", template);
		requester.put("id", "c52216ba-4c3f-4d5b-aeb7-eec3f40d8e13");
		json.put("requester", requester);
		json.put("request", "Teste - Automacao-CAB");
		json.put("impact", "baixo");
		json.put("action", "Necesssidade de Automação nas Changes do - CAB");
		json.put("changeType", "simple");
		JSONObject simple = new JSONObject();
		simple.put("plannedImplementationDate", "2022-01-12T10:09:00+0000");
		json.put("simple", simple);
		JSONObject authorizer = new JSONObject();
		authorizer.put("id", "c52216ba-4c3f-4d5b-aeb7-eec3f40d8e13");
		authorizer.put("groupId", "c52216ba-4c3f-4d5b-aeb7-eec3f40d8e13");
		authorizer.put("type", "operator");
		simple.put("authorizer", authorizer);
		json.put("impact", "baixo");

		
		System.out.println(json);
		// fw.write(json.toString());

	}

}
