use printreport
go

DECLARE @create_query VARCHAR(1000)

IF NOT EXISTS (select 1 from sysobjects where type='U' and name='WMI_CurrencyOrder')
BEGIN

select @create_query = 
'CREATE TABLE WMI_CurrencyOrder 
( 
	WMI_CurrencyOrder_Id    int IDENTITY NOT NULL,
	User_Id					int NOT NULL,
	Currency_ShortName      varchar(50) NOT NULL,
	Sort_Order              int NOT NULL,
	CONSTRAINT PK_WMI_CurrencyOrder PRIMARY KEY(WMI_CurrencyOrder_Id)
)' 

exec (@create_query)

END
go
