package gettwitter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class MysqlDatabase {
	private	static	final	String	DB_DRIVER	=	"com.mysql.jdbc.Driver";	
	private	static	final	String	DB_CONNECTION	=	"jdbc:mysql://localhost:3306/";
	private static  final   String  DB_NAME  =  "tweets";
	private	static	final	String	DB_USER	=	"root";	
	private	static	final	String	DB_PASSWORD	=	"654321";	
	
	public Connection	dbConnection;
	public static MysqlDatabase db;
	Statement statement ;
	ResultSet	result ;

	public MysqlDatabase() {	
		try	{	
			Class.forName(DB_DRIVER);	
			this.dbConnection	=	
				DriverManager.getConnection(DB_CONNECTION+DB_NAME+"?useUnicode=true&characterEncoding=utf-8",DB_USER,DB_PASSWORD);	
		}	catch	(ClassNotFoundException | SQLException	e)	{	
			Log.log("dbconnection "+ e.getMessage());	
		}
	}
	public static MysqlDatabase openConnection(){
        if ( db == null ) {
        	db = new MysqlDatabase();
        }
        return db;
	}
	 
	public void closeConnection(){
		if	(this.statement	!=	null)	{
			try {
				this.statement.close();
			} catch (SQLException e) {
				Log.log(e.getMessage());
			}	
		}
		if	(this.dbConnection	!=	null)	{
			try {
				this.dbConnection.close();
			} catch (SQLException e) {
				Log.log(e.getMessage());	
			}	
		}
	}
	
	public ResultSet query(String query){
		try {
			statement = this.dbConnection.createStatement();
			result	=	statement.executeQuery(query);
		} catch (SQLException e) {
			Log.log(e.getMessage());	
		}	
		return result;
	}
	
}