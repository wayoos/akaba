/**
 * 
 */
package com.wayoos.akaba.core.tools;

import java.sql.SQLException;

public class H2Console {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] consoleServerArgs;
		if (args.length <= 0) {
			consoleServerArgs = new String[] { "-web", "-webPort", "8082", "-properties", "memFS:" };
		} else {
			consoleServerArgs = args;
		}

		try {
			org.h2.tools.Server.createWebServer(consoleServerArgs).start();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		//		<bean class="org.h2.tools.Server" factory-method="createWebServer" init-method="start" destroy-method="stop"> -->
		//		<!-- 		<constructor-arg value="-web,-webPort,8082,-properties,memFS:" /> -->
		//		<!-- 	</bean> -->
	}
}
