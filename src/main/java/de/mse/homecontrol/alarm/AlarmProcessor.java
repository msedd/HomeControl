package de.mse.homecontrol.alarm;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class AlarmProcessor implements Processor {

	private boolean check = false;

	public void process(Exchange exchange) throws Exception {
		String returnValue = "0";
		String message = exchange.getIn().toString();
		if (message.indexOf("6") > -1) {
			if (check) {
				check = false;
				returnValue = "0";
				System.out.println("Alarmanlage aus");
			} else {
				check = true;
				returnValue = "5";
				System.out.println("Alarmanlage an");

			}
		} else if (message.indexOf("7") > -1) {
			if (check) {
				returnValue = "2";
				System.err.println("Alarm !!!");
			}

		}

		exchange.getOut().setBody(returnValue);

	}

}
