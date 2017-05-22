package gettwitter;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfig {
	final String TWITTER_CONSUMER_KEY = "xxx";
	final String TWITTER_SECRET_KEY = "xxx";
	final String TWITTER_ACCESS_TOKEN = "xxx";
	final String TWITTER_ACCESS_TOKEN_SECRET = "xxx";
	
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
