package org.jmfamily;

class Mulesoft implements Serializable {
    def steps

    Mulesoft(steps) {
        this.steps = steps
    }

    def CallApi() {
        def response = steps.httpRequest url:"http://ip.jsontest.com/"

        def responseContent = steps.readJSON text: response.content

        return responseContent
    }
}