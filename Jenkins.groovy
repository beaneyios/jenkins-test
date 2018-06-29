def notify

stage('Setting the variables values') {
    node {
    	notify = load 'notify.groovy'

         notifySuccess(params.flavour, stageName)
         notifyFailure(params.flavour, stageName)
    }
}