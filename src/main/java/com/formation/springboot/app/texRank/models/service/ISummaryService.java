package com.formation.springboot.app.texRank.models.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.formation.springboot.app.texRank.model.SummaryTextRank;

public interface ISummaryService {

	public SummaryTextRank find();
	public String procesarTexto(int cantidadOraciones, String text) throws IOException;
}
