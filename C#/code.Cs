// Небезопасная генерация псевдорандомных чисел
Random rnd = new Random(123);
int num = rnd.nextInt();


// Инициализация пароля в исходном коде
String pswd;
// Инициализация пустого пароля
String pswd1 = "";
// Инициализация пароля значением null
String pswd2 = null;


// Присвоение пароля в исходном коде
pswd = "Pa$$word";
// Присвоение пустого пароля
pswd = "";
// Присвоение паролю значения null
pswd = null;


String login = Console.ReadLine();
// Специальная учётная запись
if (login.Equals("superAdmin@mail.com")) {
    // Some code
}


// Вызов GC.Collect()
GC.Collect();


String conn = "Some text";
if (conn.Equals(null)) {
    // Some code
}

