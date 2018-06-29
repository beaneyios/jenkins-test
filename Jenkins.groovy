def notify

stage('Setting the variables values') {
    node {
    	notify = load '../Child@script/notify.groovy'
        notifySuccess("GNL", "Unit tests")
        notifyFailure("GNL", "Unit tests")
    }
}