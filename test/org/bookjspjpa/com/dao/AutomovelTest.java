package org.bookjspjpa.com.dao;

import org.bookjspjpa.com.entity.Automovel;

public class AutomovelTest {

	public static void main(String[] args) {
		
		Automovel automovel = new Automovel();
		automovel.setAnoFabricacao(1991);
		automovel.setAnoModelo(1992);
		automovel.setMarca("Fiat");
		automovel.setModelo("Uno Mile");
		automovel.setObservacoes("Vermelho");
		
		JDBCAutomovelDAO automovelDao = new JDBCAutomovelDAO();
		
		automovelDao.salva(automovel);

	}

}
