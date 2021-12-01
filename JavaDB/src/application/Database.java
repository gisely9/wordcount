package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/** This database class is connected 
 * to the local MySQL database 
 * @author Gisele Salama Urujeni
 *
 */
public class Database {
	
	// declaring variable 
	
	
	protected static Connection conn;
	
	/** Connection with MYSQL database 
	 * 
	 * @return returns what the database has called 
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		
		try { 
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://24.196.52.166:3306/word_occurrences";
			String username="root";
		    String password = "rootpassword";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return  conn;
			
		} catch (Exception e) {
	        System.out.println(e.getMessage());
	        e.printStackTrace();
	        
	        
		}
		
		// return null if the database is empty 
		
		return null;
		
	}
	
	/** creates words in the database if the words 
	 * don't exist 
	 * @param tableName database name only used when testing 
	 * @throws Exception
	 */


public static void createWordsTable(String tableName) throws Exception {
	try {
		
		//Establishing a connection with the database 
		
		conn = getConnection();
		
		// create a PreparedStatement and execute 
		
		String create = "CREATE TABLE IF NOT EXISTS" + tableName + "(word varchar(255)NOT NULL UNIQUE, frequency int NOT NULL,PRIMARY KEY(word))";
		PreparedStatement pstmt = conn.prepareStatement(create);
		pstmt.executeUpdate();
		
		// close the connection 
		
		conn.close();
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	} finally {
		System.out.println("The Method: createTable() is completed!");
	}
	
	
}

/** Drops the table in the database if it
 * does exist 
 * @param tableName name of the database to be deleted
 * if it exists 
 * @throws Exception
 */


public static void deleteTable(String tableName) throws Exception {
	try { 
		
		// establishing the connection 
		
		conn = getConnection();
		
		//create PreparedStatement and execute
		
		String delete ="DROP TABLE IF EXIST"+ tableName + "";
		PreparedStatement pstmt = conn.prepareStatement(delete);
		pstmt.executeUpdate();
		
		// close the connection 
		conn.close();
	}catch(Exception e) {
		System.out.println("Error in Database.deleteTable():" + e.getMessage());
		e.printStackTrace();
		
	} finally {
		System.out.println("The Method: deleteTable() is complete!");
	}
	
	
}
 /**insert words and frequency values into the database
  * table 
  * @param word desired word to be inserted in the words table 
  * @param frequency occurrence of the word in the program 
  * @throws Exception
  */


public static void post(String word, int frequency) throws Exception {
	
	try {
		
		// Establishing the connection 
		conn =getConnection();
		// Creating a PreparedStatement and execute 
	     String post= "INSERT INTO words (word, frequency)VALUES ('" + word +"', '" + frequency + "')";
	     PreparedStatement pstmt =conn.prepareStatement(post);
	     pstmt.executeUpdate();
	     
	     // close the connection 
	     conn.close();
	}catch(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	     
	   
	}
		
}
/** deletes any words and frequency values from the 
 * database table(words table)
 * @param word any desired word to be deleted from the table
 * @throws Exception
 */

public static void delete(String word) throws Exception {
	try {
		
		// establish the connection 
		conn=getConnection();
		
		// Create PreparedStatement and execute 
		String post = "DELETE FROM words WHERE word ='" + word + "'";
		PreparedStatement pstmt = conn.prepareStatement(post);
		pstmt.executeUpdate();
		
		// close the connection 
		conn.close();
		
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
}

/** Updates the frequency of the selected words 
 * in the database table 
 * @param word target key whose frequency to be updated 
 * @param frequency occurrence of the words in the program
 */

public static void update(String word , int frequency)  {
	
try {
	// establish the connection 
	    conn= getConnection ();
	    
	    // create PreparedStatement and execute 
	    String update = "UPDATE words SET frequency =" + frequency + "WHERE word ='" + word + "'" ;
	    PreparedStatement pstmt = conn.prepareStatement(update);
	    pstmt.executeUpdate();
	    
	    // close the connection 
	    conn.close();
	    
	    
} catch(Exception e) {
	System.out.println(e.getMessage());
	e.printStackTrace();
     }
}

/** Query the word and return its frequency 
 * 
 * @param word searching for the word in the database 
 * @return frequency of the word or -1 if the word does not exist in the databse 
 */

public static int queryFrequency(String word) {
	try {
		
		// establish the connection 
		conn=getConnection();
		
		// create PreparedStatement and execute 
		String query = "SELECT frequency FROM words WHERE word ='" + word + "'";
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs =pstmt.executeQuery();
		 int frequency =0;
		 if(rs.next()) {
			       frequency = rs.getInt(1);
			       
			       // close the connection and return frequency 
			        conn.close();
			        return frequency;
		 } else {
			 
			 frequency =-1;
			 conn.close();
			 return frequency;
		 }
}catch(Exception e) {
	System.out.println("Error in Database.queryFrequency():" + e.getMessage());
	e.printStackTrace();
    }
		
     return -1;

}

/** queries database for *FROM words orders by frequency DESC 
 * and returns a ResultSet
 * @return ResultSet of query SELECT * FROM words ORDER 
 * BY frequency DESC 
 */


public static ResultSet getResults() {
	try {
		conn = getConnection();
		String query ="SELECT * FROM words ORDER BY frequency DESC";
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet results = pstmt.executeQuery();
		return results ;
	}catch(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		
	} finally {
		System.out.println("The Method: queryAll is complete!");
	}


    return null; 
}

/** Testing purposes 
 * 
 * @param args
 */
    
    
    public static void main (String [] args) {
    	try {
    		
    		deleteTable("words");
    		createWordsTable("words");
    		
    		post ("The", 2) ;
    		int freq = queryFrequency("The");
    		System.out.println(freq);
    		
    		post("He", 2);
    		freq = queryFrequency("HEY");
    		System.out.println(freq);
    		
    		getResults();
    		
    		deleteTable("words");
    		createWordsTable("words");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
