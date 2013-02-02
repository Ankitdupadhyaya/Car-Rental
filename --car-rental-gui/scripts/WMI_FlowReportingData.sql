use printreport
go

DECLARE @create_query VARCHAR(5000)

IF NOT EXISTS (select 1 from sysobjects where type='U' and name='WMI_FlowReportingData')
BEGIN

select @create_query = 
'create table WMI_FlowReportingData
(
	WMI_FlowReportingData_Id numeric(10) Identity PRIMARY KEY,
	Deal_Id numeric(20),
	Deal_Type varchar(20),
	Start_Date date,
	End_Date date,
	Month varchar(10),
	Month_Days_Number integer,
	Kplus_Folder varchar(20),
	Type_Of_Instr varchar(20),
	Currency varchar(20),
	Maturity varchar(20) null,
	Trade_Date date,
	Value_Date date,
	Maturity_Date date,
	Amount numeric(20),
	Days_Number integer,
	TRR float null,
	FTP float null,
	RMR float null,
	Liquidity_Margin numeric(20) null,
	Minimum_Commercial_Margin numeric(20) null,
	Client_Rate float null,
	Bor_Rate float null,
	Average_Amount_FirstLevel numeric(20) null,
	HardMargin_FirstLevel_Bp numeric(20) null,
	LiquidityMargin_FirstLevel_Bp numeric(20) null,
	CommercialMargin_FirstLevel_Bp numeric(20) null,
	MarginToBor_FirstLevel_Bp numeric(20) null,
	TotalMargin_FirstLevel_Bp numeric(20) null,
	TresoToBorMargin_FirstLevel_Bp numeric(20) null,
	AverageAmount_SecondLevel numeric(20) null,
	HardMargin_SecondLevel_Bp numeric(20) null,
	LiquidityMargin_SecondLevel_Bp numeric(20) null,
	CommercialMargin_SecondLevel_Bp numeric(20) null,
	MarginToBor_SecondLevel_Bp numeric(20) null,
	TotalMargin_SecondLevel_Bp numeric(20) null,
	TresoToBorMargin_SecondLevel_Bp numeric(20) null,
	AverageAmount_ThirdLevel numeric(20) null,
	HardMargin_ThirdLevel_Bp numeric(20) null,
	LiquidityMargin_ThirdLevel_Bp numeric(20) null,
	CommercialMargin_ThirdLevel_Bp numeric(20) null,
	MarginToBor_ThirdLevel_Bp numeric(20) null,
	TotalMargin_ThirdLevel_Bp numeric(20) null,
	TresoToBorMargin_ThirdLevel_Bp numeric(20) null,
	User_Id numeric(20),
	LastModifDate datetime
)' 

exec (@create_query)

END
go
