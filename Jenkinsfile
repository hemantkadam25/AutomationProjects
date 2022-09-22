pipeline {
    agent any
    
    stages {
        stage('Preparing build') {
            steps { 
                
                echo "Project is ready to build"             
            }
            }
            
            stage('Clean') {
            steps {
           
                bat "mvn clean"
            }
            }
            
            stage('Test') {
            steps {
             
                bat "mvn test"
               
            }
            }
            
            stage('Ready To Deploy') {
            steps {
               

                // Run Maven on a Unix agent.
                echo "Project is ready to deploy"

                
            }
            }
        }
    }
