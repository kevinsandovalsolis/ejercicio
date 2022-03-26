# ejercicio BCI

1. Instalar java 8 o superior
2. importar en algun IDE como projecto gradle
3. Ejecutar bootRun en IDE
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

7. enviar request 



Swagger:

curl --location --request GET 'http://localhost:8080/v2/api-docs' \
--header 'Cookie: JSESSIONID=8CC4AA306959B6149EB805772C4817EF'

