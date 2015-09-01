package org.bookjspjpa.com.dao;

import org.bookjspjpa.com.entity.Automobile;

public class AutomobileTest {

	public static void main(String[] args) {
		
		Automobile automobile = new Automobile();
		automobile.setManufactureYear(1991);
		automobile.setModelYear(1992);
		automobile.setBrand("Fiat");
		automobile.setModel("Uno Mile");
		automobile.setComments("Vermelho");
		
		JDBCAutomobileDAO automobileDao = new JDBCAutomobileDAO();
		
		automobileDao.save(automobile);

	}

}
