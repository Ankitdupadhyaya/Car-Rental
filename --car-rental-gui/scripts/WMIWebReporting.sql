use KALM
go

IF NOT EXISTS (SELECT 1
               FROM   KondorApplication
               WHERE  App_Name = 'WMIWebReporting'
              )
BEGIN
	INSERT into KondorApplication (App_Name,Version,Go_Live,ContextRoot,App_Type)
	values ('WMIWebReporting','1.0.0',getdate(),'wmi-web-reporting/WMIWebReporting.html','J')
END
ELSE
	BEGIN
		UPDATE KondorApplication set Version='1.0.0', Go_Live=getdate() where App_Name='WMIWebReporting'
	END
go


IF NOT EXISTS (SELECT 1
               FROM   KondorApplicationCodifiers appCod, KondorApplication app, kplus..Codifiers cod
               WHERE appCod.App_Id = app.App_Id AND  appCod.Codifiers_Id = cod.Codifiers_Id
               AND App_Name = 'WMIWebReporting' and Codifiers_ShortName = 'WMIWREP'
              )
BEGIN
	insert into KondorApplicationCodifiers (Codifiers_Id, App_Id)
	select distinct Codifiers_Id, App_Id
	from KALM..KondorApplication, kplus..Codifiers
	where App_Name = 'WMIWebReporting' and Codifiers_ShortName = 'WMIWREP'
END

go
