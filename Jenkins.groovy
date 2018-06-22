stage('Setting the variables values') {
    node {
    	print "${env.Flavour}"]
    	print params.Flavour
         sh '''#!/bin/bash
                fastlane tests 
         '''
    }
}