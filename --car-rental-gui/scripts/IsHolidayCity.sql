use printreport
go

DECLARE @create_query VARCHAR(1000)

IF NOT EXISTS (select 1 from sysobjects where type='P' and name='IsHolidayCity')
BEGIN

select @create_query = 
'CREATE PROCEDURE IsHolidayCity
(
  @Cities_Id    int,
  @Date1        datetime,
  @ReturnStatus int OUTPUT
) AS 
BEGIN
    EXEC OpenKFS...Date_isholiday_city  @Cities_Id, @Date1, @ReturnStatus output
    select @ReturnStatus
END' 

exec (@create_query)

END
go
