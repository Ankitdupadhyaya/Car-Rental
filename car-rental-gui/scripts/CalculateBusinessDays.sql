use printreport
go

DECLARE @create_query VARCHAR(1000)

IF NOT EXISTS (select 1 from sysobjects where type='P' and name='CalculateBusinessDays')
BEGIN

select @create_query = 
'CREATE PROCEDURE CalculateBusinessDays
(
  @Cities_Id    int,
  @Date1        datetime,
  @NbDays       int,
  @Date2        datetime OUTPUT
) AS 
BEGIN
    EXEC OpenKFS...Date_addbusydays_city  @Cities_Id, @Date1, @NbDays, @Date2 OUTPUT
    select @Date2
END' 

exec (@create_query)

END
go
