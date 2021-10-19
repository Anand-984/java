pipeline {
    agent any

    environment{
	PATH = "/opt/maven3.8.3/bin/:$PATH"
	}

    stages{

	stage("Git Checkout"){
	steps{
	git credentialsId: 'anand', url: 'https://github.com/Anand-984/java.git'
	}
	}

    stage("Maven Build"){
	steps{
	sh "/opt/apache-maven-3.8.3/bin/mvn package"
	sh "mv target/*.war "
	}
	}
    
    stage("depoy-dev"){
	steps{
	sshagent(credentials: [''], ignoreMissing: true) {
	sh """
	scp -o StrictHostChecking=yes target/myweb.war hari@172.31.7.55:/opt/apache-tomcat-9.0.54/webapps/
	
	ssh hari@172.31.7.55:/opt/apache-tomcat-9.0.54/bin/shutdown.sh
	
	ssh hari@172.31.7.55:/opt/apache-tomcat-9.0.54/bin/startup.sh
	
	"""
	}
    }
    }
    }
    }
    
