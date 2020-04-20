package com.fashionmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenerateTable {
	public void createTable() {
		Connection con = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement pr = con.prepareStatement("CREATE TABLE \"ProductTBL\" (\r\n" + 
					"	\"ProductID\" serial NOT NULL,\r\n" + 
					"	\"ProductName\" varchar(40) NOT NULL,\r\n" + 
					"	\"quantity\" integer NOT NULL,\r\n" + 
					"	\"UnitPrice\" integer NOT NULL,\r\n" + 
					"	\"Description\" TEXT,\r\n" + 
					"	\"BrandID\" integer,\r\n" + 
					"	\"CategoryID\" integer NOT NULL,\r\n" + 
					"	\"LastUpdate\" DATE NOT NULL,\r\n" + 
					"	\"Sale\" integer,\r\n" + 
					"	CONSTRAINT \"ProductTBL_pk\" PRIMARY KEY (\"ProductID\")\r\n" + 
					") WITH (\r\n" + 
					"  OIDS=FALSE\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"CREATE TABLE \"OrderLineTBL\" (\r\n" + 
					"	\"OrderID\" integer NOT NULL,\r\n" + 
					"	\"ProductDetailID\" integer NOT NULL,\r\n" + 
					"	\"Quantity\" integer NOT NULL,\r\n" + 
					"	\"UnitPrice\" FLOAT NOT NULL,\r\n" + 
					"	CONSTRAINT \"OrderLineTBL_pk\" PRIMARY KEY (\"OrderID\",\"ProductDetailID\")\r\n" + 
					") WITH (\r\n" + 
					"  OIDS=FALSE\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"CREATE TABLE \"CustomerTBL\" (\r\n" + 
					"	\"CustomerID\" varchar(5) NOT NULL,\r\n" + 
					"	\"UserName\" varchar(255) NOT NULL,\r\n" + 
					"	\"Password\" varchar(30) NOT NULL,\r\n" + 
					"	\"CustomerName\" varchar(50) NOT NULL,\r\n" + 
					"	\"Phone\" varchar(11),\r\n" + 
					"	\"Address\" varchar(100),\r\n" + 
					"	\"Email\" varchar(100),\r\n" + 
					"	\"GenderID\" integer NOT NULL,\r\n" + 
					"	CONSTRAINT \"CustomerTBL_pk\" PRIMARY KEY (\"CustomerID\")\r\n" + 
					") WITH (\r\n" + 
					"  OIDS=FALSE\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"CREATE TABLE \"OrderTBL\" (\r\n" + 
					"	\"OrderID\" serial NOT NULL,\r\n" + 
					"	\"OrderDate\" DATETIME,\r\n" + 
					"	\"CustomerID\" varchar(5),\r\n" + 
					"	CONSTRAINT \"OrderTBL_pk\" PRIMARY KEY (\"OrderID\")\r\n" + 
					") WITH (\r\n" + 
					"  OIDS=FALSE\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"CREATE TABLE \"ImageTBL\" (\r\n" + 
					"	\"ProductID\" integer NOT NULL,\r\n" + 
					"	\"image\" varchar(255) NOT NULL\r\n" + 
					") WITH (\r\n" + 
					"  OIDS=FALSE\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"CREATE TABLE \"BrandTBL\" (\r\n" + 
					"	\"BrandID\" serial NOT NULL,\r\n" + 
					"	\"Brand_name\" varchar(50) NOT NULL,\r\n" + 
					"	\"Description\" varchar(255),\r\n" + 
					"	CONSTRAINT \"BrandTBL_pk\" PRIMARY KEY (\"BrandID\")\r\n" + 
					") WITH (\r\n" + 
					"  OIDS=FALSE\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"CREATE TABLE \"CategoryTBL\" (\r\n" + 
					"	\"CategoryID\" serial NOT NULL,\r\n" + 
					"	\"CategoryName\" varchar(50) NOT NULL,\r\n" + 
					"	CONSTRAINT \"CategoryTBL_pk\" PRIMARY KEY (\"CategoryID\")\r\n" + 
					") WITH (\r\n" + 
					"  OIDS=FALSE\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"CREATE TABLE \"ProductDetailTBL\" (\r\n" + 
					"	\"DetailID\" serial NOT NULL,\r\n" + 
					"	\"ProductID\" integer NOT NULL,\r\n" + 
					"	\"Size\" integer NOT NULL,\r\n" + 
					"	\"Color\" varchar(10) NOT NULL,\r\n" + 
					"	\"Quantity\" integer NOT NULL,\r\n" + 
					"	CONSTRAINT \"ProductDetailTBL_pk\" PRIMARY KEY (\"DetailID\")\r\n" + 
					") WITH (\r\n" + 
					"  OIDS=FALSE\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"CREATE TABLE \"Gender\" (\r\n" + 
					"	\"GenderID\" serial NOT NULL,\r\n" + 
					"	\"Gender\" varchar(10) NOT NULL,\r\n" + 
					"	CONSTRAINT \"Gender_pk\" PRIMARY KEY (\"GenderID\")\r\n" + 
					") WITH (\r\n" + 
					"  OIDS=FALSE\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"CREATE TABLE \"GenderForProduct\" (\r\n" + 
					"	\"ProductID\" integer NOT NULL,\r\n" + 
					"	\"GenderID\" integer NOT NULL,\r\n" + 
					"	CONSTRAINT \"GenderForProduct_pk\" PRIMARY KEY (\"ProductID\",\"GenderID\")\r\n" + 
					") WITH (\r\n" + 
					"  OIDS=FALSE\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"CREATE TABLE \"AdminAccount\" (\r\n" + 
					"	\"ID\" serial NOT NULL,\r\n" + 
					"	\"UserName\" varchar(50) NOT NULL,\r\n" + 
					"	\"Password\" varchar(50) NOT NULL,\r\n" + 
					"	\"Name\" varchar(50) NOT NULL,\r\n" + 
					"	CONSTRAINT \"AdminAccount_pk\" PRIMARY KEY (\"ID\")\r\n" + 
					") WITH (\r\n" + 
					"  OIDS=FALSE\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"ALTER TABLE \"ProductTBL\" ADD CONSTRAINT \"ProductTBL_fk0\" FOREIGN KEY (\"BrandID\") REFERENCES \"BrandTBL\"(\"BrandID\");\r\n" + 
					"ALTER TABLE \"ProductTBL\" ADD CONSTRAINT \"ProductTBL_fk1\" FOREIGN KEY (\"CategoryID\") REFERENCES \"CategoryTBL\"(\"CategoryID\");\r\n" + 
					"\r\n" + 
					"ALTER TABLE \"OrderLineTBL\" ADD CONSTRAINT \"OrderLineTBL_fk0\" FOREIGN KEY (\"OrderID\") REFERENCES \"OrderTBL\"(\"OrderID\");\r\n" + 
					"ALTER TABLE \"OrderLineTBL\" ADD CONSTRAINT \"OrderLineTBL_fk1\" FOREIGN KEY (\"ProductDetailID\") REFERENCES \"ProductDetailTBL\"(\"DetailID\");\r\n" + 
					"\r\n" + 
					"ALTER TABLE \"CustomerTBL\" ADD CONSTRAINT \"CustomerTBL_fk0\" FOREIGN KEY (\"GenderID\") REFERENCES \"Gender\"(\"GenderID\");\r\n" + 
					"\r\n" + 
					"ALTER TABLE \"OrderTBL\" ADD CONSTRAINT \"OrderTBL_fk0\" FOREIGN KEY (\"CustomerID\") REFERENCES \"CustomerTBL\"(\"CustomerID\");\r\n" + 
					"\r\n" + 
					"ALTER TABLE \"ImageTBL\" ADD CONSTRAINT \"ImageTBL_fk0\" FOREIGN KEY (\"ProductID\") REFERENCES \"ProductTBL\"(\"ProductID\");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"ALTER TABLE \"ProductDetailTBL\" ADD CONSTRAINT \"ProductDetailTBL_fk0\" FOREIGN KEY (\"ProductID\") REFERENCES \"ProductTBL\"(\"ProductID\");\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"ALTER TABLE \"GenderForProduct\" ADD CONSTRAINT \"GenderForProduct_fk0\" FOREIGN KEY (\"ProductID\") REFERENCES \"ProductTBL\"(\"ProductID\");\r\n" + 
					"ALTER TABLE \"GenderForProduct\" ADD CONSTRAINT \"GenderForProduct_fk1\" FOREIGN KEY (\"GenderID\") REFERENCES \"Gender\"(\"GenderID\");\r\n" + 
					"\r\n" + 
					"");
			pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertData() {
		Connection con = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement pr = con.prepareStatement("INSERT INTO product (ProductName, UnitPrice, Description, BrandID, CategoryID, LastUpdate)\r\n" + 
					"VALUES ( 'product1', 50000, 'something', 1, 1, now()),\r\n" + 
					"		( 'product1', 50000, 'something', 1, 1, now()),\r\n" + 
					"		( 'product1', 50000, 'something', 1, 1, now()),\r\n" + 
					"		( 'product1', 50000, 'something', 1, 1, now()),\r\n" + 
					"		( 'product1', 50000, 'something', 1, 1, now());");
			pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void dropTable() {
		Connection con = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement pr = con.prepareStatement("ALTER TABLE ProductTBL DROP COLUMN quantity;");
			pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
