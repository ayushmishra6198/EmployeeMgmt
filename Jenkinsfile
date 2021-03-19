pipeline{
    agent any
    tools 
    {
        jdk 'Jenkins-Java'
    }
    stages{
        stage('Compile Stage'){
            
            steps{
            withMaven(maven:'Jenkins-Maven') {
                bat 'mvn clean compile'
                }
            }
        }

        stage('Testing Stage'){
            steps{
            withMaven(maven:'Jenkins-Maven') {
                bat 'mvn test'
                }
            }

        }
    }

}
