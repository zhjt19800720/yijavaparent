package com.yijava.admin.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateDataBaseTableByHibernateConfigFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SchemaExport export = new SchemaExport(new Configuration().configure()
				.setNamingStrategy(new ImprovedNamingStrategy()));

		export.setFormat(false);

		export.setOutputFile("src/test/resources/h2schma.sql");

		export.create(true, false);
	}

}
