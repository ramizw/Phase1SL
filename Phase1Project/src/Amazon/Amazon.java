package Amazon;

import PageObjects.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;



import java.sql.*;

public class Amazon {
	
	private static final String db = "jdbc:mysql://localhost:3306/amazon";
	private static final String dbserver = "jdbc:mysql://localhost:3306";
	private static final String user = "root";
	private static final String pwd = "root";
	
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	private static PreparedStatement pstmt;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/home/ramizwahabyahoo/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
	
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        
        Home homePage = PageFactory.initElements(driver, Home.class);
        homePage.btnClick();
        homePage.txtGet();
        System.out.println(homePage.txtGet());
        
        String query = "Insert into amazon.amazon_pay (balance) values (?)";
				
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			con=DriverManager.getConnection(db, user, pwd);
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, homePage.txtGet());
			
			int ret = pstmt.executeUpdate();
			if (ret == 1) {
				System.out.println("Successfully added a new record");
			}
			else {
				System.out.println("Unable to add a new record");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
			con.close();
			pstmt.close();
			
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
	}
        
	}

}
