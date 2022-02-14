package com.grpbg.Poc.Controller;

import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grpbg.Poc.DTO.ChangeActivity;
import com.grpbg.Poc.DTO.ChangeDTO;
import com.grpbg.Poc.DTO.OperatorChangeDetails;
import com.grpbg.Poc.HttpClient.ClientTopDesk;

@Controller
//@ApplicationScope(proxyMode = ScopedProxyMode.NO)
public class AppController {
	private static final Logger log = LogManager.getLogger(AppController.class);
	private static String authString = System.getenv("username") + ":" + System.getenv("senha");
	private static String authStringToken = System.getenv("username") + ":" + System.getenv("password");
	private static byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
	private static byte[] authEncBytesToken = Base64.getEncoder().encode(authStringToken.getBytes());
	private static String authStringEnc = new String(authEncBytes);
	private static String authStringEncToken = new String(authEncBytesToken);
	private static ChangeDTO change = new ChangeDTO();
	private static String uuid = "c52216ba-4c3f-4d5b-aeb7-eec3f40d8e13";
	public static ChangeActivity changeActivity = new ChangeActivity();
	public static final String HOST = "http://localhost:8080/gcchanges/success";
	public static String change_number = null;
	// Change change = new Change();

	// private static String number = "M2112-000005";
	// private static Change change;
	ClientTopDesk client = new ClientTopDesk();

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}

	@RequestMapping(value = "/success")
	public String success() {
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject(ClientTopDesk.CHANGE_NUMBER);
		return "success";
	}

	public static void inicio(HttpServletRequest request, HttpServletResponse resp, ChangeDTO change)
			throws ServletException, HttpRequestMethodNotSupportedException {
		try {
			PrintWriter out = resp.getWriter();
			out.println("<html>" + "<body>" + "<p> change de nª" + ClientTopDesk.CHANGE_NUMBER + " criada com sucesso!"
					+ "</p>" + "</body>" + "</html>");
			resp.sendRedirect(HOST);
		} catch (Exception ex) {
			throw new RuntimeException(ex.getCause());
		}
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public String novaChange(Model model) throws HttpClientErrorException, Exception {
		String retorno = ClientTopDesk.Listchanges();
		model.addAttribute("retorno", retorno);
		return "novo";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		return "error";
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String status() {
		return "status";
	}

	@RequestMapping(value = "/email", method = RequestMethod.GET, produces = org.springframework.http.MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String/* ModelAndView */ email(/* BindingResult result */ @RequestParam("numero") String numero, Model model)
			throws Exception, RuntimeException {

		try {

			String retorno = ClientTopDesk.getChange(numero);
			model.addAttribute("retorno", retorno);

			return retorno;

		} catch (RuntimeException ex) {

			ex.printStackTrace();
		}
		return null;
	}

	@PostMapping(value = "/save")
	// @RequestMapping(value="/save", method = RequestMethod.GET, produces =
	// org.springframework.http.MediaType.TEXT_HTML_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	@Transactional
	public String save(/* HttpServletRequest request, */ Model model, @RequestParam("nome") String nome,
			@RequestParam("filial") String filial, /* @RequestParam("briefDescription") String titulo, */
			@RequestParam("action") String causa, @RequestParam("changeType") String tipo_requisicao,
			@RequestParam("impact") String impacto, @RequestParam("plannedEndDate") String data_execucao,
			/* @RequestParam("operator") String operador, */ /* @RequestParam("status") String status, */
			/* @RequestParam("activity_description") String descricao_atividade, */
			/* @RequestParam("activityType") String tipo_atividade, */
			@RequestParam("plannedFinalDate") String data_final_atividade,
			// @RequestParam("activityOperatorGroup") String operador_grupo,
			/* @RequestParam("activity_operator") String operador_atividade, */
			/* @RequestParam("activity_status") String status_atividade, */ RedirectAttributes attributes,
			HttpServletRequest request, HttpServletResponse response) throws ResourceNotFoundException, Exception {
		try {
			// Mount Json Object
			// String token_id = uuid;
			change.setTokenID(uuid);
			change.setAction(causa);
			change.setNome(nome);
			change.setFilial(filial);
			// change.setBriefDescription(titulo);
			change.setChangeType(tipo_requisicao);
			change.setImpact(impacto);
			change.setPlannedEndDate(data_execucao);
			// change.setChangeType(tipo_atividade);

			// changeActivity.setBriefDescription(descricao_atividade);
			changeActivity.setPlannedFinalDate(change.getPlannedEndDate());
			changeActivity.setPlannedFinalDate(change.getPlannedEndDate());
			// changeActivity.setActivityType(tipo_atividade);
			changeActivity.setPlannedFinalDate(data_final_atividade);
			changeActivity.setChangePhase("progress");
			// changeActivity.setOperator(operador_atividade);
			// changeActivity.setStatus(status_atividade);
			// changeActivity.setOperatorGroup(operador_grupo);

			String retorno = ClientTopDesk.createChange(change);

			if (retorno.equalsIgnoreCase("inserido") == true) {
				// log.debug(changeActivity);
				attributes.addFlashAttribute("message",
						"Change" + " " + ClientTopDesk.CHANGE_NUMBER + " " + "criada com sucesso.");
				attributes.addFlashAttribute("error", "Erro na criação da change.");
				//AppController.inicio(request, response, change);
				model.addAttribute("change_number", ClientTopDesk.CHANGE_NUMBER);
				System.out.println("Change de nª" + " " + ClientTopDesk.CHANGE_NUMBER + " criada com sucesso!");
				return "success";
			} else {
				return "redirect:error";
			}
		} catch (RuntimeException ex) {
			ex.printStackTrace();

		}
		return null;

	}

	@PostMapping(value = "/novo")
	@Transactional
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<OperatorChangeDetails> save(@Valid @RequestBody OperatorChangeDetails change)
			throws ResourceNotFoundException, Exception {
		// var content = request.getParameter("content");
		try {

			org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
			header.add("Content-Type", "application/json");
			header.add("Charset", "UTF-8");
			header.add("Authorization", "Basic " + authStringEnc);
			// HttpStatus code = (ClientTopDesk.createChange(change));

		} catch (ResourceNotFoundException ex) {
			log.info("resource not found!");

			log.catching(ex.getCause());

			ex.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		// }

		/*
		 * else { if (ClientTopDesk.getChange(number).getCHANGE_DESCRIPTION().
		 * equalsIgnoreCase("Change E-CAB") == true &&
		 * ClientTopDesk.getChange(number).getSTATUS_CHANGE()
		 * .equalsIgnoreCase("Aguardando aprovação") == true) { return "change"; } }
		 */
	}

}
