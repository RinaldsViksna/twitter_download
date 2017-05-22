package gettwitter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import gettwitter.MysqlDatabase;
import twitter4j.Status;
import twitter4j.User;

public class Tweet {
	public long id;
	public String text;//varchar(200)
	public String source; //varchar(255)
	public String geoLocation; //varchar(255)
	public String place; //varchar(255)
	public String lang;//varchar(20)
	public User user; //mediumtext
	public String fulltweet; //mediumtext
	public Date createdAt; //datetime

	
	//http://twitter4j.org/javadoc/twitter4j/Status.html
	Tweet(Status status){
		id = status.getId();
		text = status.getText();
		source = status.getSource();
//		System.out.println(status.getUser());
		geoLocation = (status.getUser() == null || status.getUser().getLocation() == null ) ? "" : status.getUser().getLocation().toString();
//		System.out.println(status.getPlace());
		place = (status.getPlace() == null || status.getPlace().getCountryCode() == null ) ? "" : status.getPlace().getCountryCode();
		lang = status.getLang();
		user = status.getUser();
		fulltweet = status.toString();
		createdAt = status.getCreatedAt();
		
	}
	
	public boolean save(){
		// Papildus pārbaudu lietotāja uzstādīto valodu
		if ( !user.getLang().equals("lv") ){
			System.out.println("lang " + user.getLang()+" un text ir " + text);
			return false;
		}
		
		MysqlDatabase data = MysqlDatabase.openConnection();
		PreparedStatement preparedStatement;
		String insertTweet = "INSERT INTO tweetlist"
		+ " ( id , text , source, geoLocation , place , lang , user , fulltweet , createdAt )"
		+ " VALUES (?,?,?,?,?,?,?,?,?)";
		
		java.sql.Date createDate = new java.sql.Date(createdAt.getTime());
		String userDb = user.toString();
		
		try {
			if (data.dbConnection == null) {
				Log.log("connection null ");
				data = MysqlDatabase.openConnection();
			}
			preparedStatement = data.dbConnection.prepareStatement(insertTweet);
			Log.log( "Id " + id +" text " + text);
			preparedStatement.setLong(1, id);
			preparedStatement.setString(2, text);
			preparedStatement.setString(3, source);
			preparedStatement.setString(4, geoLocation);
			preparedStatement.setString(5, place);
			preparedStatement.setString(6, lang);
			preparedStatement.setString(7, userDb);
			preparedStatement.setString(8, fulltweet);
			preparedStatement.setDate(9, createDate);
			preparedStatement.executeUpdate();
//			Log.log("Executing update "+preparedStatement.toString());
//			ResultSet rs = preparedStatement.getGeneratedKeys();
//			rs.next();
//			id = rs.getInt(1);
			Log.log("tweet saved" + id);
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
