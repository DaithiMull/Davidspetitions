# Use the latest Tomcat base image
FROM tomcat:latest

# Copy all WAR files from the target directory
ADD target/*.war /usr/local/tomcat/webapps/

# Expose port 9090 for container access
EXPOSE 9090

# Run the Tomcat server in the foreground
CMD ["catalina.sh", "run"]