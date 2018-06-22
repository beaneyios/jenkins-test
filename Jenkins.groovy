stage('Setting the variables values') {
    node {
    	echo '${Flavour}'
         sh '''#!/bin/bash
                fastlane tests 
         '''
    }
}