package com.nto.dockermysql.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource("classpath:application-dev.properties")
public class AppConfigProperties {

	@Value("${db_driver}")
	private String db_driver;

	@Value("${db_url}")
	private String db_url;

	@Value("${db_username}")
	private String db_username;

	@Value("${db_password}")
	private String db_password;

	public String getDb_driver() {
		return db_driver;
	}

	public void setDb_driver(String db_driver) {
		this.db_driver = db_driver;
	}

	public String getDb_url() {
		return db_url;
	}

	public void setDb_url(String db_url) {
		this.db_url = db_url;
	}

	public String getDb_username() {
		return db_username;
	}

	public void setDb_username(String db_username) {
		this.db_username = db_username;
	}

	public String getDb_password() {
		return db_password;
	}

	public void setDb_password(String db_password) {
		this.db_password = db_password;
	}
	
	@Override
	public String toString() {
		return "AppConfigProperties{\n" +
				"db_driver = " + db_driver + "\n" + 
				"db_url = " + db_url + "\n" +
				"db_username = " + db_username + "\n" +
				"db_password = " + db_password +
				"\n}";
	}

}
