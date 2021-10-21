pipeline {
    agent any

    environment{
	PATH = "/opt/maven3.8.3/bin/:$PATH"
	}

    stages{

	stage("Git Checkout"){
	steps{
	git 'https://github.com/Anand-984/java.git'
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
	sshagent(['tomcat-now']){
	sh """
	sudo sshpass -p "1" scp  target/myweb.war ec2-user@54.162.15.220:/opt/apache-tomcat-9.0.54/webapps/
	
	ssh ec2-user@54.162.15.220:/opt/apache-tomcat-9.0.54/bin/shutdown.sh
	
	ssh ec2-user@54.162.15.220:/opt/apache-tomcat-9.0.54/bin/startup.sh
	
	"""
	}
	}
    }
    }
    }
    
    
