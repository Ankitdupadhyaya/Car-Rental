use printreport
go

DECLARE @create_query VARCHAR(1000)

IF NOT EXISTS (select 1 from sysobjects where type='P' and name='CalculateCityLastWorkingDayOfMonth')
BEGIN

select @create_query = 
'CREATE PROCEDURE CalculateCityLastWorkingDayOfMonth
(
  @Date1 datetime,
  @Cities_Id int,
  @lastWorkingDayofMonth datetime OUTPUT
) AS 
BEGIN
	EXEC OpenKFS...Date_monthbusinessend_city @Date1, @Cities_Id, @lastWorkingDayofMonth output
    select @lastWorkingDayofMonth
END' 

exec (@create_query)

END
go
