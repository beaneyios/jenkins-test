stage('Setting the variables values') {
    node {
         slackSend (color: '#FFFF00', message: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})", baseURL: "https://hooks.slack.com/services/T03N363D0/BB6671VMW/", token: "BaePQoyadJ45P5IJJbl8Uu3B", channel: "testjenkins")
    }
}