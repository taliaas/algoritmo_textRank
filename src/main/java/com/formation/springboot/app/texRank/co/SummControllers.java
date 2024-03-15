package com.formation.springboot.app.texRank.co;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.springboot.app.texRank.models.service.ISummaryService;

@RestController
public class SummControllers {

	@Autowired
	public ISummaryService summServices;

	@PostMapping("/summary")
	public ResponseEntity<String> summary(@RequestBody SummaryDTO body) throws IOException {
		String text = URLDecoder.decode(body.getText(), StandardCharsets.UTF_8.toString());
		String summary = summServices.procesarTexto(body.getCantOraciones(),text);
	    return new ResponseEntity<>(summary, HttpStatus.OK);
	}

}
