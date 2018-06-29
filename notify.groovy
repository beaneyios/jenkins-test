void notifyFailure(flavour, stageName) {
    def color = "#f44242"
    def subject = "${flavour} failed to build."
    def title = "${flavour} failed on ${stageName}"
    def slackNotificationSucceeded = notifySlack(color, subject, title, jobName, buildNumber)

    if(slackNotificationSucceeded) {
        notifyEmail(stageName)
    }
}

void notifySuccess(flavour, stageName) {
    def color = "#0cb500"
    def subject = "${flavour} build succeeded."
    def title = "No errors to report."
    def slackNotificationSucceeded = notifySlack(color, subject, title, jobName, buildNumber)
}

Boolean notifySlack(color, subject, title) {
    def buildServerUrl = """https://mobile-ci.tvmp.dev.bbc.co.uk/job/News/job/${JOB_NAME}/${BUILD_NUMBER}/"""
    def body =  """
                    {
                        \"text\": \"${subject}\",
                        \"attachments\": [
                            {
                                \"title_link\": \"${buildServerUrl}\",
                                \"title\": \"${title}\",
                                \"color\": \"${color}\"
                            }
                        ]
                    }
                """

    def response = httpRequest  url: 'https://hooks.slack.com/services/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', 
                                contentType: 'APPLICATION_JSON', 
                                requestBody: body, 
                                httpMode: "POST"
    if(response.status != 200) {
        return false
    }

    return true
}

void notifyEmail(stageName, flavour) {
    emailext    attachLog: false,
                to: 'matthew.beaney@bbc.co.uk', 
                subject: flavour + ': ' + stageName + ' stage failed', 
                body: 'Go to Jenkins for more details.', 
                mimeType: 'text/html'
}