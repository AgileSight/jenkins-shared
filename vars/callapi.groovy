def callme(message) {
    def response = steps.httpRequest url:"http://ip.jsontest.com/"

    def responseContent = steps.readJSON text: response.content

    return responseContent
}