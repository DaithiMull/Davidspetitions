# Use the latest Tomcat base image
FROM tomcat:latest

# Copy all WAR files from the target directory
ADD target/*.war /usr/local/tomcat/webapps/

# Expose port 8081 for container access
EXPOSE 8081

# Run the Tomcat server in the foreground
CMD ["catalina.sh", "run"]