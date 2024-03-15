package com.formation.springboot.app.texRank.models.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formation.springboot.app.texRank.model.SummaryTextRank;

import textsummary.LuceneSentenceProcessor;
import textsummary.PageRanker;
import textsummary.SummaryBot;

@Service
public class SummaryServiceImpl implements ISummaryService{
	
	@Autowired
	private RestTemplate clienteRest; 
	
	@Override
	public SummaryTextRank find(){
		SummaryTextRank ra= new SummaryTextRank("Hola");
		
		return ra; 
	}
	
	public String procesarTexto(int cantidadOraciones, String text) throws IOException{
		LuceneSentenceProcessor lProc = new LuceneSentenceProcessor();
		//nlpProc.SetRelevantTokenTags(new String[]{"CD", "FW", "JJ", "JJR", "JJS", "LS", "MD", "NN", "NNP", "NNPS", "NNS", "PDT", "PRP$", "RB", "RBR", "RBS", "RP", "SYM", "VB", "VBD", "VBG", "VBN", "VBP", "VBZ"});
		PageRanker pageRanker = new PageRanker();
		SummaryBot summaryBot = new SummaryBot(lProc, pageRanker);
		String lineas = "";

		for (String s : summaryBot.SummarizeArticle(cantidadOraciones, text)) {
			lineas += s + "\n";
		}
		return lineas;
	}

}
