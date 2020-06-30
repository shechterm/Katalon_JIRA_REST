import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent


def slurper = new groovy.json.JsonSlurper()
println "###  in getTransition testCase"
println issueKey

def getTransitionRequest = ((findTestObject('REST/Issue/GetTransition')) as RequestObject)
		
try{
	//Need to add auth params
	//createIssueRequest.setHttpHeaderProperties(null)
	//createIssueRequest.setBodyContent(new HttpTextBodyContent(body,"UTF-8", "application/json"))
	println getTransitionRequest
}
catch(Exception ex){
println(ex)
}
//Set Response object
getTransitionRequest.setRestUrl("https://${GlobalVariable.URL}/issue/${issueKey}/transitions")
def response  =  WS.sendRequest(getTransitionRequest)
GlobalVariable.response = slurper.parseText(response.getResponseBodyContent())




//Check  Response code is the 200  || stop if fail
//WS.verifyResponseStatusCodeInRange(response, 200, 201,FailureHandling.STOP_ON_FAILURE)
//def result = slurper.parseText(response.getResponseBodyContent())
//GlobalVariable.response = slurper.parseText(response.getResponseBodyContent())
//return result


