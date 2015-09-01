package org.bookjspjpa.com.dao;

import java.util.List;

import org.bookjspjpa.com.entity.Automobile;

public interface AutomobileDAO {
	void save(Automobile automovel);
	List<Automobile> listAll();
}
