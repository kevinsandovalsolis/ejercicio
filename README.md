# ejercicio BCI

1. Instalar java 8 o superior
2. Una vez clonado el repositorio ir a la ruta /jar por consola
2b. importar en algun IDE como projecto gradle
3. Ejecutar comando java -jar ejercicio-1.0.0-SNAPSHOT.jar
3b. Ejecutar boorRun en IDE
4. una vez que termine de ejecutar abrir en navegador ruta http://localhost:8080/h2-console
5. ingresar con 
   url: jdbc:h2:mem:usuario
   user:admin
   pass:123456
   **podra ver las tablas creadas sin datos
6. abrir cliente rest como postman e importar el siguiete curl

curl --location --request POST 'http://localhost:8080/usuario' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=8CC4AA306959B6149EB805772C4817EF' \
--data-raw '{
"nombre":"Juan Perez",
"correo":"Juan1@email.com",
"password":"pass123",
"telefonos":[{
"numero":"12345678",
"codigoCiudad":"2",
"codigoPais":"56"
}]
}'



Swagger:

curl --location --request GET 'http://localhost:8080/v2/api-docs' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=8CC4AA306959B6149EB805772C4817EF' \
--data-raw '{
"nombre":"kevin",
"correo":"kevin1@email.com",
"password":"asas",
"telefonos":[{
"numero":"123123",
"codigoCiudad":"1",
"codigoPais":"9"
}]
}'

