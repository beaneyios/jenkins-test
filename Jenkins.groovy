def notify

stage('Setting the variables values') {
    node {
    	notify = load '../Child@script/notify.groovy'
        notify.notifySuccess("GNL", "Unit tests", "iOS")
        notify.notifyFailure("GNL", "Unit tests", "iOS")
    }
}