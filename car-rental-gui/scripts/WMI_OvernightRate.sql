use printreport
go

DECLARE @create_query VARCHAR(10000)

IF NOT EXISTS (select 1 from sysobjects where type='U' and name='WMI_OvernightRate')
BEGIN

select @create_query = 
'CREATE TABLE WMI_OvernightRate
(
	WMI_OvernightRate_Id INTEGER IDENTITY NOT NULL,
	Currency_ShortName VARCHAR(50) NOT NULL,
	FloatingRate_ShortName VARCHAR(50) NOT NULL,
	CONSTRAINT PK_WMI_OvernightRate PRIMARY KEY(WMI_OvernightRate_Id)
)

INSERT INTO WMI_OvernightRate(Currency_ShortName, FloatingRate_ShortName) VALUES (''AUD'', ''AUDOISON'')

INSERT INTO WMI_OvernightRate(Currency_ShortName, FloatingRate_ShortName) VALUES (''EUR'', ''EUR-OIS'')

INSERT INTO WMI_OvernightRate(Currency_ShortName, FloatingRate_ShortName) VALUES (''CAD'', ''CADOISON'')

INSERT INTO WMI_OvernightRate(Currency_ShortName, FloatingRate_ShortName) VALUES (''NZD'', ''NZDOISON'')

INSERT INTO WMI_OvernightRate(Currency_ShortName, FloatingRate_ShortName) VALUES (''USD'', ''USD-OIS'')

INSERT INTO WMI_OvernightRate(Currency_ShortName, FloatingRate_ShortName) VALUES (''SEK'', ''SEK-OIS'')

INSERT INTO WMI_OvernightRate(Currency_ShortName, FloatingRate_ShortName) VALUES (''GBP'', ''GBP-OIS'')

INSERT INTO WMI_OvernightRate(Currency_ShortName, FloatingRate_ShortName) VALUES (''CHF'', ''CHFOISON'')

INSERT INTO WMI_OvernightRate(Currency_ShortName, FloatingRate_ShortName) VALUES (''DKK'', ''DKKOISON'')

INSERT INTO WMI_OvernightRate(Currency_ShortName, FloatingRate_ShortName) VALUES (''SEK'', ''SEKOISON'')

INSERT INTO WMI_OvernightRate(Currency_ShortName, FloatingRate_ShortName) VALUES (''PLN'', ''PLN-OIS'')

INSERT INTO WMI_OvernightRate(Currency_ShortName, FloatingRate_ShortName) VALUES (''ILS'', ''ILSPRM-OIS'')
'

exec (@create_query)

END
go
