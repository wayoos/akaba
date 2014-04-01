/**
 * 
 */
package com.wayoos.akaba.core.export;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;


public abstract class AbstractExportDatabaseSchema {
	private static final Logger logger = LoggerFactory.getLogger(AbstractExportDatabaseSchema.class);

	private static final int SCHEMA_VERSION = 1;

	private static final String PREFIX_TARGET_DIR = "src/sql/";

	private static final String SCHEMA_FILE_NAME = "akaba-v" + SCHEMA_VERSION + ".sql";

	@Autowired
	private LocalSessionFactoryBean localSessionFactoryBean;

	protected abstract String getDatabaseName();

	@Test
	public void exportEngineDatabaseSchema() throws IOException {
		String TARGET_DIR = PREFIX_TARGET_DIR + getDatabaseName() + "/v" + SCHEMA_VERSION + "/";

		String SCHEMA_FILE_PATH = TARGET_DIR + getDatabaseName() + "-" + SCHEMA_FILE_NAME;

		File targetDir = new File(TARGET_DIR);
		targetDir.mkdirs();

		executeSchemaExport(SCHEMA_FILE_PATH, localSessionFactoryBean);
	}

	public void executeSchemaExport(String fileName, LocalSessionFactoryBean sessionFactory) {
		Configuration configuration = sessionFactory.getConfiguration();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.setOutputFile(fileName);
		schemaExport.setFormat(true);
		schemaExport.setDelimiter(";");
		schemaExport.execute(false, false, false, false);
	}

}
