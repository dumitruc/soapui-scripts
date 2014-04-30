String tag = " [Http forward] "

forwardToAutomationListner("http://localhost:8080/");

def forwardToAutomationListner(String destURL) {
    try {

    	def soapRequest = mockRequest.requestContent
    	def soapUrl = new URL(destURL)
		def connection = soapUrl.openConnection()
		
		connection.setRequestMethod("POST")
		connection.setRequestProperty("Content-Type" ,"text/html")
		connection.doOutput = true

		Writer writer = new OutputStreamWriter(connection.outputStream);
		writer.write(soapRequest)
		writer.flush()
		writer.close()
		connection.connect()
		requestContext.responseMessage = connection.content.text
		log.info(tag+"Forwarded successfully.")
    	}catch (Exception e){
    		log.error(tag+"failed forward")
    		log.error(tag+e);
    	}

    }