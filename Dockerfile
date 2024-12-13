# Usa una imagen base de Tomcat
FROM tomcat:9.0-jdk11

# Copia el archivo .war generado por Maven a la carpeta webapps de Tomcat
COPY target/FernanPaqWeb-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

# Expone el puerto 8080 para acceder a tu aplicación
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]


