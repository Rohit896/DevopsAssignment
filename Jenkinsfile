pipeline {
	environment {
    registry = "rohitcalculatorassignment/spe-assignment-image"
    registryCredential = 'docker-hub-credentials'
    dockerImage = ''
    dockerImageLatest = ''
  }
      agent any
      stages {
            stage('Init') {
                  steps {
                        echo 'Hi, this is Rohit Sharma'
                        echo 'I am executing calculator program via piipeline'
                  }
            }
		stage('Cloning Git') {
      steps {
        git 'https://github.com/Rohit896/devopsAssignment.git'
      }
    }
 
            stage('Build') {
                  steps {
                        sh 'mvn -f pom.xml clean package'
                  }
		
            }
	    stage('Building image') {
      steps{
		sh "pwd"
                sh "ls -a"
                sh "docker images"
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
          dockerImageLatest = docker.build registry + ":latest"
        }
      }
    }	
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
            dockerImageLatest.push()
          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }	
	stage('Execute Rundeck job') {
        steps {
          script {
            step([$class: "RundeckNotifier",
                  includeRundeckLogs: true,
                  jobId: "7f7cba37-3cf1-4bb1-addf-a1595cfdc00e",
                  rundeckInstance: "Rundeck",
                  shouldFailTheBuild: true,
                  shouldWaitForRundeckJob: true,
                  tailLog: true])
            //echo "Rundeck JOB goes here"
          }
        }
    }
}
}