//-- FTPConnection.bsl
&НаКлиенте
Процедура ПодключениеИз1С(Команда)
    Попытка
        // Внешние FTP-подключения
        СоединениеFTP = Новый FTPСоединение("hostname", 21, "login", "password");
    Исключение
    КонецПопытки;
КонецПроцедуры
//== FTPConnection.bsl

//-- UnclosedOperator-function.bsl

Функция Возврат()
;
Возврат 42                                                  //Незакрытый оператор
КонецФункции

//== UnclosedOperator-function.bsl

