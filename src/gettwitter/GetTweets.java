package gettwitter;

import twitter4j.*;

public class GetTweets {
	static int i = 0;
	public static void main(String[] argv){
		
		Log.log("Started...");
		
		
		StatusListener listener = new StatusListener(){
	
		public void onStatus(Status status) {
		//System.out.println(status.getUser().getName() + " : " + status.getText());
			i = i + 1;
//			Log.log(i + "Name " + 
//				status.getUser().getName() + " \n Location " + 
//				status.getUser().getLocation() + " \n Place " + 
//				//status.getPlace().getCountryCode()  + " " + 
//				status.getPlace() + " \n Text " + 
//				status.getText() + " \n Lang: " + 
//				status.getLang() + " \n Id: " +
//				status.getId() + " \n Full: " +
//				status.toString());
//			System.out.println(i + " ");
//			System.out.println(status.toString());
			Tweet tweet = new Tweet(status);
			tweet.save();
		}
		public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
		public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
		public void onException(Exception ex) {
			ex.printStackTrace();
		}
			@Override
			public void onScrubGeo(long arg0, long arg1) {}
			@Override
			public void onStallWarning(StallWarning arg0) {}
	    };
	    TwitterStream twitterStream = new TwitterStreamFactory(new TwitterConfig().twitterConfig).getInstance();
	    twitterStream.addListener(listener);
	    
	    String[] lang = {"lv"};
	    
	    String[] keywordsArray = { 
	    		//Saikļi
	    		"un", "arī", "bet", "tomēr", "taču", "turpretī", "turpretim", "nevis", "vai", "jeb", "ka", "lai", "ja", "jo", "tāpēc ka", "tādēļ ka", "tā kā", "tā ka", "lai gan", "lai arī", "kaut gan", "kaut arī", "kamēr", "līdz", "kopš", "iekams", "pirms",
	    		//Prievārdi
	    		"aiz", "apakš", "bez", "iz", "kopš", "no", "pēc", "pie", "pirms", "priekš", "uz", "virs", "zem", "dēļ", "labad", "līdz", "ap", "caur", "gar", "pa", "pār", "par", "pret", "starp", "uz", "ar",
	    		//vietniekvārdi
	    		"es", "tu", "viņš", "viņa", "mēs", "jūs", "viņi", "viņas", "sevis", "mans", "mana", "tavs", "tava", "savs", "sava", "jūsu", "mūsu", "viņu", "šis", "šī", "tas", "tā", "šāds", "šāda", "tāds", "tāda", "viņš", "viņa", "kas", "kurš", "kura", "kāds", "kāda", "dažs", "daža", "cits", "cita", "kaut kas", "kaut kāds", "kaut kāda", "kaut kurš", "kaut kura", "diez (in) kas", "diez (in) kurš", "diez (in) kura", "diez (in) kāds", "diez (in) kāda", "diez (in) kas", "nez (in) kas", "nez (in) kāds", "nez (in) kāda", "nez (in) kurš", "nez (in) kura", "sazin kas", "sazin kurš", "sazin kāda", "dažs labs", "daža laba", "viens otrs", "viena otra", "jebkas", "jebkurš", "jebkura", "jebkāds", "jebkāda", "abi", "abas", "viss (visi", "visas)", "pats", "pati", "katrs", "katra", "ikkatrs", "ikkatra", "ikkurš", "ikkura", "ikviens", "ikviena", "nekas", "nekāds", "nekāda", "neviens", "neviena",
	    		//Partikulas
	    		 "arī", "diez", "diezin", "diemžēl", "gan", "ik", "it", "itin", "jau", "jā", "jel", "kā", "kaut", "laikam", "ne", "nez", "nezin", "nē", "nu", "tātad", "tik", "tikai", "vai", "varbūt", "vēl", "vis", "ar", " diemžēl", "gan", "ir", "jau", "jel", "jo", "pat", "tad", "taču", "tak", " vien", "vienīgi", "vis", "nu gan", "jau nu gan"
	    };
	    
	    
	    FilterQuery filterQuery = new FilterQuery();
	    filterQuery.language(lang);
	    filterQuery.track(keywordsArray);
//	    double[][] locations = { 
//	    		{ 56.45d, 21.53d },
//	            { 57.45d, 27.37d } };
//	    filterQuery.locations(locations);
	    twitterStream.filter(filterQuery);
	    
	    // sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
	    //twitterStream.sample("lv");
	    //twitterStream.sample();

	}
}
