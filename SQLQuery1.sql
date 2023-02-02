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


SELECT * from Invoice_detail INNER JOIN Product ON Invoice_detail.Item_id=Product.Product_id where Invoice_id =1;


