package org.bookjspjpa.com.dao;

import java.util.List;

import org.bookjspjpa.com.entity.Automovel;

public interface AutomovelDAO {
	void salva(Automovel automovel);
	List<Automovel> lista();
}
