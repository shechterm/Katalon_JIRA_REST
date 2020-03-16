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
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent

def slurper = new groovy.json.JsonSlurper()
def createIssueRequest = (RequestObject)findTestObject('REST/Issue/CreateIssue');
try{
	//Need to add auth params
	//createIssueRequest.setHttpHeaderProperties(null)
	createIssueRequest.setBodyContent(new HttpTextBodyContent(body,"UTF-8", "application/json"))
	println createIssueRequest
}
catch(Exception ex){
println(ex)
}
//Set Response object
def response  =  WS.sendRequest(createIssueRequest)
//GlobalVariable.response = slurper.parseText(response.getResponseBodyContent())

//Check  Response code is the 200  || stop if fail
WS.verifyResponseStatusCodeInRange(response, 200, 201,FailureHandling.STOP_ON_FAILURE)
//def result = slurper.parseText(response.getResponseBodyContent())
GlobalVariable.response = slurper.parseText(response.getResponseBodyContent())
//return result




/*
GlobalVariable.testCaseParams.bugIssueKey = result.key

println bugParams.bugIssueKey
//get bug issue object
request = (RequestObject)findTestObject('Old/GetIssue')
response = WS.sendRequestAndVerify(findTestObject('Old/GetIssue'))
println slurper.parseText(response.getResponseBodyContent())

// verify issueType
WS.verifyElementPropertyValue(response, 'fields.issuetype.name', 'Bug')
*/


