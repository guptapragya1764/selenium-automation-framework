pipeline {

agent any

 

	
 
stages {
  stage('Git Checkout') {
     steps{
     checkout scm
     }
  }
  
  stage("Sonar Analysis"){
             steps{
             withSonarQubeEnv("Test_Sonar")
                 {
                 bat 'mvn sonar:sonar'
                 }
             }
         }
}
   
   post{
   always{
// 		 mail to: 'cutubittu@gmail.com',
//           subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
//           body: "Something is wrong with ${env.BUILD_URL}"
	    script {
	   if(params.MailingList || env.DEFUALT_MAIL_LIST){
                    emailext subject: "${env.JOB_NAME} - BuildId#${env.BUILD_NUMBER} is ${currentBuild.currentResult}!", mimeType: 'text/html', 
                            to: "${params.MailingList},${env.DEFUALT_MAIL_LIST}", body: '${SCRIPT, template="groovy-html.template"}'
                }
	    }
		}
   }
}
