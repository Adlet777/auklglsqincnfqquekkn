# Задание ""CRUD телефония"

## Тлеубай Адлет


### IMPORTANT NOTE! 
````                     
проект разрабатывался и разворачивался на Windows                          
никаких проблем с настрокой и запуском на других ОС быть не должно         
но желательно запускать на Windows если это возможно  
````                       

### 1. Информация о приложении                         
````
java version: 17
gradle version: gradle-8.5                      
postgres version:
    DBMS: PostgreSQL (ver. 10.23 (Ubuntu 10.23-1.pgdg20.04+1))
    Driver: PostgreSQL JDBC Driver (ver. 42.6.0, JDBC4.2)
mongo version:
    DBMS: Mongo DB (ver. 6.0.13)
    Driver: MongoDB JDBC Driver (ver. 1.18, JDBC4.2)
````

### 2. Базы данных

2.1 Проект не требует ручного подключения и настройки БД       
Все уже сконфигурировано в application.yml       
Но если нужно подключиться и посмотреть таблицы то можно подключиться к БД через IntelliJ IDEA (либо любую другую утилиту) используя эти данные:  

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

2.2 Алгоритм подключения к БД через IntelliJ IDEA:   

postgres:        
a) справа нажать на иконку Database -> + -> Data Source -> PostgreSQL          
b) нажать OK и подождать успешного подключения          
c) Если выйдет уведомление:             
````
Confirm closing all existing connections to '@manny.db.elephantsql.com'                    
````
то нажать "No"          
d) Далее в базе pokvxlhi можно увидеть public таблицу contacts          
          
mongo:          
a) справа нажать на иконку Database -> + -> Data Source -> MongoDB           
b) нажать OK и подождать успешного подключения           
c) Если выйдет уведомление:             
````
Confirm closing all existing connections to '@cluster0.peb9hqn.mongodb.net'                    
````
то нажать "No"               
d) Далее в базе cluster0 можно увидеть коллекцию contacts          


### 3. Запуск проекта                        
3.1. В удобном расположении склонировать проект с помощью команды:                     
````
git clone https://github.com/Adlet777/auklglsqincnfqquekkn.git
`````

3.2 
- Открыть IntelliJ IDEA 
- Нажать на File -> 
- Нажать на Open -> 
- Выбрать распложение склонированного проекта -> 
- Нажать "TrustProject" -> 
- Нажать на This Window

3.3 Подождать окончания индексации проекта 

3.4 Из терминала из под корневой папки проекта запустить команду сборки gradle: 
````
./gradlew build
```` 
Пример запуска Bash: 
````
adilet@Adlet MINGW64 ~/Desktop/greetgo-task-test/auklglsqincnfqquekkn (main)
$ ./gradlew build
```` 
Пример запуска Powershell:                           
````
PS C:\Users\adilet\Desktop\greetgo-task-test\auklglsqincnfqquekkn> ./gradlew build
````

3.5 Подождать появления уведомления "BUILD SUCCESSFUL in ?m ?s"


3.6 Запустить приложение командой Run 

### 4. Postman      
4.1       
- Открыть Postman
- Залогиниться в свой аккаунт 
- Нажать на Workspaces ->
- Нажать на My Workspace ->
- Нажать на Collections ->
- Нажать Import ->
- Нажать на "files" в строчке "Or select files or folders" -> 
- Выбрать расположение postman коллекции из корневой папки проекта 
````
C:\Users\adilet\Desktop\greetgo-task-test\auklglsqincnfqquekkn                                                  
````
- Выбрать файл "Contacts_REST_Adilet_Tleubay.postman_collection.json"

### 5. Эндпоинты
Во всех эндпоинтах где нужно ввести {id} или {phone_number} данные значения можно взять из ответов эндпоинтов getAllContacts             
В url просто необходимо будет заменить {id} и {phone_number} на существующие ID и номер телефона из БД 

5.1 Get All request для mongo. В параметрах можно задавать limit и offset. Возвращает список контактов 
````
curl --location 'http://localhost:8080/contacts/mongo?limit=5&offset=2'
````        
5.2 Get by ID request для mongo. Возвращает контакт 
````
curl --location 'http://localhost:8080/contacts/mongo/060a1b76-1c83-48ff-a49f-b8c9409cba5f'
````
В случае вызова несуществующего ID приходит ошибка (ID обязательно должен быть в формате UUID)
````
Contact with id={060a1b76-1c83-48ff-a49f-b8c9409cba55} not found
````       
5.3 Get by phone number для mongo 
````       
curl --location 'http://localhost:8080/contacts/mongo/phone-number/+7(777)-777-7772'        
````
В случае вызова несуществующего телефона приходит ошибка 
````
Contact with phone_number={+7(777)-777-7785} not found
```` 
5.4 Delete by ID для mongo 
````                                                  
curl --location --request DELETE 'http://localhost:8080/contacts/mongo/060a1b76-1c83-48ff-a49f-b8c9409cba5f'
````         
5.5 Delete by phone number для mongo 
````                                                                         
curl --location --request DELETE 'http://localhost:8080/contacts/mongo/phone-number/+7(777)-777-7755'
````        
5.6 Update by ID для mongo 
В request body можно указать поля которые нужно обновить. Их указывать необязательно  
````                       
{
    "name": "updated",
    "yearOfBirth": 1999,
    "phoneNumber": "+7(777)-777-7731",
    "secondPhoneNumber": "+7(777)-777-7731"
}
```` 
````         
curl --location --request PUT 'http://localhost:8080/contacts/mongo/f9d217e6-3c15-40cf-b6bd-40353ea51eb2' \
--header 'Content-Type: application/json' \
--data '{
    "name": "updated",
    "yearOfBirth": 1999,
    "phoneNumber": "+7(777)-777-7731",
    "secondPhoneNumber": "+7(777)-777-7731"
}'
````
В случае обновления значения телефона на тот который уже существует приходит ошибка т.к. это поле должно быть уникальным 
````
{
    "timestamp": "2024-01-25T11:27:32.660+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/contacts/mongo/f9d217e6-3c15-40cf-b6bd-40353ea51eb2"
}
````
5.7 Update by phone number для mongo
В request body можно указать поля которые нужно обновить. Их указывать необязательно
````
{
    "name": "updatedNumber",
    "yearOfBirth": 1999
}
````
````
curl --location --request PUT 'http://localhost:8080/contacts/mongo/phone-number/+7(777)-777-7777' \
--header 'Content-Type: application/json' \
--data '{
    "name": "updatedNumber",
    "yearOfBirth": 1999
}'
````

5.8 Для postgres эндпоинты аналогичны, только в url вместо /mongo/ нужно указать postgres/ 
````
http://localhost:8080/contacts/mongo
````
````
http://localhost:8080/contacts/postgres
````

### Сложности        
Изначально планировалось запускать image-ы postgres и mongo с помощью docker-compose но ОЗУ моего ноутбука не потянул одновременный запуск Docker Runner-а, проекта в Intellij IDEA и Postman-а           
Поэтому было решено использовать бесплатный инстанс PostgreSQL от ElephantSQL и бесплатный инстанс MongoDB от MongoDB Atlas 














