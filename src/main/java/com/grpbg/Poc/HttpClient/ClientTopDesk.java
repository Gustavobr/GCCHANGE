package com.grpbg.Poc.HttpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import br.com.big.gctools.client.ClientJIRA;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.grpbg.Poc.DTO.Change;
import com.grpbg.Poc.DTO.ChangeActivity;
import com.grpbg.Poc.DTO.ChangeDTO;
import com.grpbg.Poc.DTO.TaskDTO;
import com.grpbg.Poc.UTIL.SSlUtil;

public class ClientTopDesk {

	/* Default - Builder */
	public ClientTopDesk() {

	}

	private static final String PINHO = "2d798712-e5e2-40f9-8617-114153a30f8a";
	private static final String INTEGRACAO_DEVOPS = "63b132ac-e923-4615-b64f-fcc5ed7c23b1";
	private static final String REQUESTER = "15e182ee-32aa-4687-9d2c-7fb1de0e66c6";
	private static final String ID_AUTHORIZER = "253888cc-4378-4798-85f6-26d2cab088a4";
	private static String CHANGE_DESCRIPTION = null;
	private static String STATUS_CHANGE = null;
	private static JsonParser parser = new JsonParser();
	private static Gson gson = new Gson();
	public static String CHANGE_NUMBER = null;
	private static String URL_CREATE_ACTIVITY = "https://big-test.topdesk.net/tas/api/operatorChangeActivities";
	private static String URL_CREATE_CHANGE = "https://big-test.topdesk.net/tas/api/operatorChanges";
	private static String URL_FIND_CHANGE = "https://big-test.topdesk.net/tas/api/operatorChanges?number=";
	private static String LIST_CHANGES = "https://big-test.topdesk.net/tas/api/operatorChanges?fields=id,changeType&query=phase=in=(prfc,rfc,simple)";
	private static String POST_CHANGE = "https://big-test.topdesk.net/tas/api/operatorChanges";
	private static String URL_CHANGE = "https://big-test.topdesk.net/tas/api/operatorChanges?query=number=in=" + "("
			+ CHANGE_NUMBER + ")";
	private static final String URL_LOGIN = "https://big-test.topdesk.net/tas/api/login/operator";
	private static String TOKEN_ID = null;
	private static final Logger log = LogManager.getLogger(ClientTopDesk.class);
	private static HttpClient client = HttpClient.newHttpClient();
	private static final StringBuilder URL_HOST = new StringBuilder("https://big-test.topdesk.net/tas");
	private static String authString = System.getenv("username") + ":" + System.getenv("senha");
	private static String authStringToken = System.getenv("username") + ":" + System.getenv("password");
	private static byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
	private static byte[] authEncBytesToken = Base64.getEncoder().encode(authStringToken.getBytes());
	private static String authStringEnc = new String(authEncBytes);
	private static String authStringEncToken = new String(authEncBytesToken);
	private static final String URL_INCIDENT = "https://big-test.topdesk.net/tas/api/incidents";
	private static String changeId = null;
	private static ChangeActivity activity = new ChangeActivity();
	private static Change change = new Change();
	public static String Tasks = null;
	public static String FileNames = null;
	private static String json = "{\r\n" + "  \"template\":{\r\n" + "       \"number\": \"MM-0116\",\r\n"
			+ "        \"briefDescription\": \"01 - Requisição - Change\"\r\n" + "  },\r\n" + "  \"requester\":{\r\n"
			+ "    	\"id\": \"c52216ba-4c3f-4d5b-aeb7-eec3f40d8e13\"\r\n" + "  },\r\n"
			+ "  \"request\": \"Automacao-CAB - Call - Teste - Hugo\",\r\n"
			+ "  \"action\": \"Necessidade de automação de Changes do CAB\",\r\n" + "  \"changeType\": \"simple\"\r\n"
			+ "},\r\n" + "\"simple\":{\r\n" + "  \"plannedImplementationDate\": \"2022-01-12T10:09:00+0000\",\r\n"
			+ "  \"authorizer\":{\r\n" + "    \"id\": \"c52216ba-4c3f-4d5b-aeb7-eec3f40d8e13\",\r\n"
			+ "    \"groupId\": \"c52216ba-4c3f-4d5b-aeb7-eec3f40d8e13\",\r\n" + "    \"type\": \"operator\"\r\n"
			+ "  }\r\n" + "},\r\n" + "\"priority\": \"baixa\",\r\n" + "\"impact\" : \"baixo\",\r\n" + "\r\n" + "}\r\n"
			+ "    \r\n" + "  \r\n" + "  \r\n" + "  \r\n" + "       ";

	public static String getToken() throws RuntimeException, Exception {
		try {
			log.info("By pass certificado!");
			SSlUtil.byPassSelfSignedCertificate();
			if (System.getenv("username").equalsIgnoreCase("integracao_devops") == true) {
				HttpRequest request = HttpRequest.newBuilder(URI.create(URL_LOGIN))
						.header("Authorization", "Basic " + authStringEnc).version(Version.HTTP_1_1)
						.timeout(Duration.ofMinutes(1)).GET().build();
				HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

				TOKEN_ID = response.body().toString();

				return TOKEN_ID;
			}
		} catch (Exception ex) {
			log.error("Erro durante obtenção de TOKEN_ID");
			ex.printStackTrace();
		}
		return null;
	}

	public static String Listchanges() throws HttpClientErrorException, Exception {
		try {
			List<br.com.big.gctools.dto.TaskDTO> lista = new ArrayList<>();
			lista = ClientJIRA.exec();
			if (!lista.isEmpty() == true) {
				for (br.com.big.gctools.dto.TaskDTO task : lista) {
					Tasks = "Task:" + "\n" + task.getLink_task();
					FileNames = "Arquivos:" + "\n" + task.getListFiles();
				}
				return Tasks + "\n" + FileNames;

			}
		} catch (Exception ex) {

		}
		return null;
	}

	public static String getChange(String number) throws Exception {
		try {
			log.info("By pass certificado!");
			SSlUtil.byPassSelfSignedCertificate();
			// number = CHANGE_NUMBER;

			TOKEN_ID = ClientTopDesk.getToken();

			if (TOKEN_ID != null && !TOKEN_ID.isEmpty() == true) {
				ClientTopDesk.CHANGE_NUMBER = number;
				String URL = "https://big-test.topdesk.net/tas/api/operatorChanges?query=number=in=" + "("
						+ CHANGE_NUMBER + ")";
				HttpRequest request = HttpRequest.newBuilder(URI.create(URL)).timeout(Duration.ofSeconds(300))
						.header("Authorization", "Basic " + authStringEncToken).version(Version.HTTP_1_1)
						.version(HttpClient.Version.HTTP_1_1).build();
				log.debug(client);
				HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

				@SuppressWarnings("deprecation")
				JsonElement jsonElement = parser.parse(response.body().toString()).getAsJsonObject();
				JsonObject obj = jsonElement.getAsJsonObject();
				JsonElement simpleElement = obj.getAsJsonObject().get("results");
				JsonArray array = simpleElement.getAsJsonArray();
				for (int x = 0; x < array.size(); x++) {
					STATUS_CHANGE = array.get(x).getAsJsonObject().get("status").getAsJsonObject().get("name")
							.getAsString();
					CHANGE_DESCRIPTION = array.get(x).getAsJsonObject().get("briefDescription").getAsString();

					log.debug("montando objeto change");
					// change.setCHANGE_DESCRIPTION(CHANGE_DESCRIPTION);
					// change.setSTATUS_CHANGE(STATUS_CHANGE);
					// return change;
				}

				// Change change= null;
				return "Status:" + " " + STATUS_CHANGE + " -------------- " + "\n" + "Descrição:" + " "
						+ CHANGE_DESCRIPTION;
			}

		}

		catch (RuntimeException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public HttpClient getClient() {
		return client;
	}

	public void setClient(HttpClient client) {
		ClientTopDesk.client = client;
	}

	public static String getChangeID(ChangeDTO change) throws Exception {
		try {
			if (change != null) {

			}
		} catch (Exception ex) {
			throw new RuntimeException(ex.getCause());
		}
		return "";
	}

	public static int sendPost(String requestBody) throws Exception {
		try {
			HttpRequest request = HttpRequest.newBuilder().POST(BodyPublishers.ofString(requestBody))
					.uri(URI.create(URL_CREATE_CHANGE)).setHeader("User-Agent", "Java 11 HttpClient Bot")
					.header("Content-Type", "application/json")
					.setHeader("Authorization", "Basic " + authStringEncToken).version(Version.HTTP_2).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			changeId = getChangeId(response);
			CHANGE_NUMBER = getChangeNumber(response);
			int statusCode = response.statusCode();
			return statusCode;
		} catch (RuntimeException ex) {
			throw new RuntimeException(ex.getCause());
		}
	}

	public static String getChangeId(HttpResponse<String> response) throws JsonSyntaxException {
		JsonElement jsonElement = parser.parse(response.body().toString()).getAsJsonObject();
		JsonObject obj = jsonElement.getAsJsonObject();

		String changeId = obj.getAsJsonObject().get("id").getAsString();

		return changeId;
	}

	public static String getChangeNumber(HttpResponse<String> response) throws JsonSyntaxException {
		JsonElement jsonElement = parser.parse(response.body().toString()).getAsJsonObject();
		JsonObject obj = jsonElement.getAsJsonObject();
		String change_number = obj.getAsJsonObject().get("number").getAsString();
		return change_number;

	}

	public static /* HttpStatus */ String createChange(ChangeDTO change) throws Exception, ResourceNotFoundException {
		try {
			String requestBody = null;
			log.info("Montando requestBody");
			JSONObject json = new JSONObject();
			JSONObject template = new JSONObject();
			JSONObject requester = new JSONObject();
			template.put("number", "MM-0093");
			template.put("briefDescription", change.getBriefDescription());
			json.put("template", template);
			requester.put("id", PINHO);
			json.put("requester", requester);
			json.put("request", change.getRequest());
			json.put("impact", change.getImpact());
			json.put("action", change.getAction());
			json.put("changeType", "extensive");
			JSONObject simple = new JSONObject();
			simple.put("plannedImplementationDate", change.getPlannedEndDate());
			json.put("simple", simple);
			JSONObject authorizer = new JSONObject();
			authorizer.put("id", ID_AUTHORIZER);
			// authorizer.put("groupId", "c52216ba-4c3f-4d5b-aeb7-eec3f40d8e13");
			authorizer.put("type", "operator");
			simple.put("authorizer", authorizer);
			json.put("impact", change.getImpact());

			System.out.println(json);
			requestBody = json.toString();
			// JsonString.replace("map", "requester");
			// requestBody = JsonString;
			// String json = gson.toJson(requestBody);
			log.info("By pass certificado!");
			SSlUtil.byPassSelfSignedCertificate();
			/*
			 * HttpRequest request =
			 * HttpRequest.newBuilder(URI.create(URL_CREATE_CHANGE)).timeout(Duration.
			 * ofSeconds(300)) .header("Authorization", "Basic " +
			 * authStringEncToken).version(Version.HTTP_1_1)
			 * .POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();
			 * HttpResponse<String> response = client.send(request,
			 * BodyHandlers.ofString());
			 */

			int statusCode = ClientTopDesk.sendPost(requestBody);
			// changeId = getChangeId(response);
			// boolean insert = ClientTopDesk.createActivity(changeId,
			// AppController.changeActivity);
			log.info("verificando StatusCode da request");
			if (statusCode == 201 /* && insert == true */) {
				return "inserido";
			} else {
				return "Erro";

			}
		} catch (Exception ex) {
			throw new RuntimeException(ex.getCause());
		}
	}

	public List<TaskDTO> getTasks() throws RuntimeException, Exception {
		try {

		} catch (RuntimeException ex) {
			ex.getCause();
		}
		return null;
	}

	private static boolean createActivity(String changeId, ChangeActivity activity) {
		try {
			if (changeId != null && activity != null) {
				String requestBody = null;
				log.info("Montando requestBody");
				JSONObject json = new JSONObject();
				json.put("changeId", changeId);
				json.put("briefDescription", activity.getBriefDescription());
				json.put("activityType", "normal");
				json.put("changePhase", "progress");
				json.put("status", "Planned");
				// json.put("plannedFinalDate",
				// AppController.changeActivity.getPlannedFinalDate());
				requestBody = json.toString();

				HttpRequest request = HttpRequest.newBuilder().POST(BodyPublishers.ofString(requestBody))
						.uri(URI.create(URL_CREATE_ACTIVITY)).setHeader("User-Agent", "Java 11 HttpClient Bot")
						.header("Content-Type", "application/json")
						.setHeader("Authorization", "Basic " + authStringEncToken).version(Version.HTTP_2).build();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

				if (response.statusCode() == 201) {
					return true;
				} else {
					return false;
				}
			}

		} catch (Exception ex) {

		}
		return false;

	}
}
