import groovy.json.JsonSlurperClassic

stage("Wooo") {

    def body =  """
                    {
                        \"buildVersion\": \"5.3.0.3\",
                        \"status\": \"building\"
                    }
                """

    def response = httpRequest  url: "https://bbcnbuildmonitor.firebaseio.com/apps/BBCNews/GNL/builds.json", 
                                contentType: 'APPLICATION_JSON', 
                                requestBody: body, 
                                httpMode: "POST"
                                
    def content = response.getContent()
    def json = new JsonSlurperClassic().parseText(content)
    echo "color: ${json.name}"
    
}