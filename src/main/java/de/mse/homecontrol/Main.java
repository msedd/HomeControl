package de.mse.homecontrol;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import de.mse.homecontrol.alarm.AlarmSystemRoute;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CamelContext context = new DefaultCamelContext();

		try {
			context.addRoutes(new AlarmSystemRoute());

			context.start();

			while (true) {
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
