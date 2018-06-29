def notify

stage('Setting the variables values') {
    node {
    	notify = load '../Child@script/notify.groovy'
        notifySuccess(params.flavour, stageName)
        notifyFailure(params.flavour, stageName)
    }
}