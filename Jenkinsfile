pipeline {
  agent any
  environment{
    SUITENAME='Regression suite'
    CREDENTIALS= credentials('7e79e38c-947a-4aa3-b579-6e23c2df9f0b')
  }
  parameters{
    string(name: 'Suite', defaultValue: '', description: 'Suite Type')
    choice(name: 'AutomationType', choices: ['UI','API'], description: 'Automation type')
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
            echo "suite name is ${Suite}"
            echo "Automation type is ${AutomationType}"
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

