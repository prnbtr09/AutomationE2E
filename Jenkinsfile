pipeline {
  agent any
 stages {
   stage('GitCheckout') {
 steps {
        git(url: 'https://github.com/prnbtr09/AutomationE2E.git', branch: 'master', credentialsId: '24a9edca-3ed2-4b07-b90f-fd439eb65fa8')
      }   
   }
   
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

