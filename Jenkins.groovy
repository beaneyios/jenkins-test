stage('Setting the variables values') {
    node {
         sh '''#!/bin/bash
                fastlane tests 
         '''
    }
}