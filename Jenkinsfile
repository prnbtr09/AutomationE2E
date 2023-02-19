pipeline {
  agent any
  environment{
    SUITENAME='Regression suite'
  }
  stages {
   stage('UIAutomation') {
      parallel {
        stage('UIAutomation') {
          steps {
            bat 'mvn test -pl UIAutomation'
          }
        }

        stage('APIAutomation') {
          steps {
            echo 'API Automation'
            echo "suite name is ${SUITENAME}"
          }
        }

      }
    }
   stage('Archive') {
      parallel {
        stage('Archive') {
          steps {
            archiveArtifacts(allowEmptyArchive: true, artifacts: 'UIAutomation/target')
          }
        }

      

      }
    }
   
   
   
 }
  
}

