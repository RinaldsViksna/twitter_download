package gettwitter;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfig {
	final String TWITTER_CONSUMER_KEY = "pwoSjWeC5bpV4fx5k7MacjAom";
	final String TWITTER_SECRET_KEY = "st91r2O3Cmv5HjFHrcGkr9mx2zIasJWzUhWLuorAPR9R3fTrxo";
	final String TWITTER_ACCESS_TOKEN = "829080109290242048-9Ey3e8rTL5GspIW3AHF8FysRaQyxEUt";
	final String TWITTER_ACCESS_TOKEN_SECRET = "qEBuh6WKIT3RhdAklHwBCcT11cW5F6TNOnx39Y6d37c1Y";
	
	Configuration twitterConfig;

	public TwitterConfig(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true).setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
		  .setOAuthConsumerSecret(TWITTER_SECRET_KEY)
		  .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
		  .setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
		
		twitterConfig = cb.build();
	}
	
}
