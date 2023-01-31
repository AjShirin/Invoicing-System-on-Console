create database InvoiceGrociares;

USE InvoiceGrociares;

Select * From Shop_detail;
Select * From Invoice_header_detail;
Select * From Product;
Select * From Invoice_detail;
Select * From Customer;


select count (*) As Total_Items, (Select count(*)from Invoice_detail) As Total_Of_Invoice, SUM (Product_quantity_price) As total_quantity_Item_Price From Product;

SELECT Invoice_detail.Invoice_id As Number_of_Invoice, Invoice_detail.Invoice_date,Customer.Customer_full_name As Customer_name ,Customer.Number_of_items,Customer.Paid_amount As Total,Customer.Balance FROM Invoice_detail JOIN Customer ON Customer.Customer_id=Invoice_detail.Invoice_id;

SELECT Invoice_detail.Invoice_id, Product.Product_id
FROM Invoice_detail
INNER JOIN Product ON Invoice_detail.Item_id=Product.Product_id;



--Creating product table--
CREATE TABLE ITEMS(
    Item_id INTEGER PRIMARY KEY IDENTITY(1,1),
    Item_name varchar(100) NOT NULL,
    Unit_price DOUBLE NOT NULL,
    Quantity_amount Integer NOT NULL,
	Quantity_price DOUBLE NOT NULL,
    FOREIGN KEY (ColumnNAme) REFERENCES tableName(columnName)
);

--Creating Customer Table--
CREATE TABLE CUSTOMER(
    Customer_id INTEGER PRIMARY KEY IDENTITY(1,1),
    Customer_fullName varchar(100) NOT NULL,
    Phone_Number Integer NOT NULL,
    Invoice_date Date NOT NULL,
	Total_amount DOUBLE NOT NULL,
	Paid_amount DOUBLE NOT NULL,
	Balance DOUBLE NOT NULL,
    FOREIGN KEY (ColumnNAme) REFERENCES tableName(columnName)
);
--Creating Shop Table--
CREATE TABLE SHOP(
    Shop_id INTEGER PRIMARY KEY IDENTITY(1,1),
    Shop_name varchar(100) NOT NULL,

);
--Creating Invoice Table--
CREATE TABLE INVOICE(
    Invoice_id INTEGER PRIMARY KEY IDENTITY(1,1),
    Cuctomer_id Integer NOT NULL,
	Item_id Integer NOT NULL,
	FOREIGN KEY (Cuctomer_id) REFERENCES CUSTOMER(Customer_id),
	FOREIGN KEY (Item_id) REFERENCES ITEMS(Item_id)

);

