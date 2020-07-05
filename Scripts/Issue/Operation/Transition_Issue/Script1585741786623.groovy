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
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.impl.HttpFileBodyContent
import com.kms.katalon.core.testobject.impl.HttpFormDataBodyContent 
import com.kms.katalon.core.testobject.impl.HttpUrlEncodedBodyContent 
import com.kms.katalon.core.testobject.TestObjectProperty 
import com.kms.katalon.core.testobject.ConditionType

 

def slurper = new groovy.json.JsonSlurper()
println "###  in transition issue testCase"
println issueKey
println "transitionId inside test case = ${transitionId}"


// Set Request body

//Get  object repository
RequestObject transitionRequest = ((findTestObject('REST/Issue/TransitionIssue')))
try{
	//Set request URL
	transitionRequest.setRestUrl("https://${GlobalVariable.URL}/issue/${issueKey}/transitions")
	//Set request body
	transitionRequest.setBodyContent(new HttpTextBodyContent(body,"UTF-8", "application/json"))
	//Send request
	WS.sendRequest(transitionRequest)
}
catch(Exception ex){
println(ex)
}


