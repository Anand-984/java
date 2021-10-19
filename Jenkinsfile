pipeline {
    agent any

    environment{
	PATH = "/opt/maven3.8.3/bin:$PATH"
	}

    stages{

	stage("Git Checkout"){
	steps{
	git credentialsId: 'anand', url: 'https://github.com/Anand-984/java.git'
	}
	}

    stage("Maven Build){
	steps{
	sh "mvn clean package"
	sh "mvn target/*.war target/myweb.war"
	}
	}
    
    stage("depoy-dev"){
	steps{
	sshagent(credentials: [''], ignoreMissing: true) {
	sh """
	scp -o StrictHostChecking=no target/myweb.war hari@54.243.3.148:/home/hari/apache-tomcat-9.0.54/webapps/
	
	ssh hari@54.243.3.148:/home/hari/apache-tomcat-9.0.54/bin/shutdown.sh
	
	ssh hari@54.243.3.148:/home/hari/apache-tomcat-9.0.54/bin/startup.sh
	
	"""
	}
    }
    }
    }
    }
    
