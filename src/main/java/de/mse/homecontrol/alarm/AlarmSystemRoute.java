package de.mse.homecontrol.alarm;

import org.apache.camel.builder.RouteBuilder;

public class AlarmSystemRoute extends RouteBuilder {

	private static final String MESSAGING_TOPIC_IN = "sensor-topic-in";
	private static final String MESSAGING_TOPIC_OUT = "actor-topic-out";

	private AlarmProcessor alarmProcessor = new AlarmProcessor();

	@Override
	public void configure() throws Exception {
		from("mqtt:in?subscribeTopicName=" + MESSAGING_TOPIC_IN).process(
				alarmProcessor).to("file://out");

		from("file://out").to(
				"mqtt:out?publishTopicName=" + MESSAGING_TOPIC_OUT);

	}

}
