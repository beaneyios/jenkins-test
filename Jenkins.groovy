def notify

stage('Setting the variables values') {
    node {
    	notify = load '../Child@script/notify.groovy'
        notify.notifySuccess("GNL", "Unit tests", "iOS", "5.2.0.12")
        notify.notifyFailure("GNL", "Unit tests", "iOS", "5.2.0.12")
    }
}