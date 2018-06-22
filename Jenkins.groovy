stage('Setting the variables values') {
    node {
    	echo '${env.Flavour}'
         sh '''#!/bin/bash
                fastlane tests 
         '''
    }
}