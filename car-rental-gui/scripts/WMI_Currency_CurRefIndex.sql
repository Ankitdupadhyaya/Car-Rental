use printreport
go

DECLARE @create_query VARCHAR(1000)

IF NOT EXISTS (select 1 from sysobjects where type='U' and name='WMI_Currency_CurRefIndex')
BEGIN

select @create_query = 
'CREATE TABLE WMI_Currency_CurRefIndex
(
	WMI_Currency_CurRefIndex_Id INTEGER IDENTITY NOT NULL,
	Currency_ShortName VARCHAR(50) NOT NULL,
	CurRefIndex_ShortName VARCHAR(50) NOT NULL,
	CONSTRAINT PK_WMI_Currency_CurRefIndex PRIMARY KEY(WMI_Currency_CurRefIndex_Id)
)' 

exec (@create_query)

END
go
