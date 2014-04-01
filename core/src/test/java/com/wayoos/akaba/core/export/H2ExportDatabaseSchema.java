/**
 * 
 */
package com.wayoos.akaba.core.export;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/export/H2-ExportDatabaseSchema-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class H2ExportDatabaseSchema extends AbstractExportDatabaseSchema {

	public static final String DATABASE_NAME = "h2";

	@Override
	protected String getDatabaseName() {
		return DATABASE_NAME;
	}

}
