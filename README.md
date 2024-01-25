# Задание ""CRUD телефония"

## Тлеубай Адлет


### IMPORTANT NOTE!!! WINDOWS                       

### (1. Информация о приложении)
java version: 17
gradle version: gradle-8.5                      
postgres version:
````
DBMS: PostgreSQL (ver. 10.23 (Ubuntu 10.23-1.pgdg20.04+1))
Driver: PostgreSQL JDBC Driver (ver. 42.6.0, JDBC4.2)
````
mongo version:
````
DBMS: Mongo DB (ver. 6.0.13)
Driver: MongoDB JDBC Driver (ver. 1.18, JDBC4.2)                     
````

### (2. Базы данных)
Проект не требует ручного подключения и настройки БД. Все уже сконфигурировано в application.yml 
о если нужно подключиться и посмотреть таблицы то можно подключиться к БД через IntelliJ IDEA либо любую другую утилиту используя эти данные:  

postgres:  
````
host: manny.db.elephantsql.com
port: 5432
user: pokvxlhi
password: LiF4parkcvrZPJ-C4j6JC4M_kL7Ts4TG
database: pokvxlhi
url: jdbc:postgresql://manny.db.elephantsql.com:5432/pokvxlhi
````
mongo: 
````
host: cluster0.peb9hqn.mongodb.net                     
user: user
password: DeEdgqXGvAMCd4YP
url: mongodb+srv://cluster0.peb9hqn.mongodb.net/
````

Алгоритм подключения через IntelliJ IDEA 

справа нажать на иконку Database -> + -> data Source -> PostgreSQL

OK and wait
Confirm closing all existing connections to '@manny.db.elephantsql.com'
then in database pokvxlhi you can view table contacts


справа нажать на иконку Database -> + -> data Source -> MongoDB
OK and wait
Confirm closing all existing connections to '@cluster0.peb9hqn.mongodb.net'
then in database cluster0 you can view collection contacts

### (Эндпоинты)


(Запуск проекта)
git clone https://github.com/Adlet777/auklglsqincnfqquekkn.git

in intellij File -> Open -> directory -> "TrustProject" -> This Window

wait

in console from the root of the project

./gradlew build

Bash:
adilet@Adlet MINGW64 ~/Desktop/greetgo-task-test/auklglsqincnfqquekkn (main)
$ ./gradlew build

Powershell:
PS C:\Users\adilet\Desktop\greetgo-task-test\auklglsqincnfqquekkn> ./gradlew build

wait    for BUILD SUCCESSFUL in 1m 41s


then run application 

### (postman) 
Workspaces -> My Workspace -> Collections -> Import 
"Or select files or folders" 
in root directory ex: C:\Users\adilet\Desktop\greetgo-task-test\auklglsqincnfqquekkn 
select file "Contacts_REST_Adilet_Tleubay.postman_collection.json"
done! 

{id} and {phone_number} 
import in postman       

### (Сложности) 















