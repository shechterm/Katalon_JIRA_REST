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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//Get response
'Create new issue'
response = WS.sendRequestAndVerify(findTestObject('null', [('URL') : GlobalVariable.URL]))

def issueTypePar = 'Bug'

//
def slurper = new groovy.json.JsonSlurper()

'Get issue result\r\n'
def result = slurper.parseText(response.getResponseBodyContent())

// Get new issue key
def LocalIssueKey = result.key

println("The new issueKey value -> $LocalIssueKey")

//Set global variable with issueKey
'Set  global variable issueKey '
GlobalVariable.IssueKey = LocalIssueKey

println("global variable value is -> $GlobalVariable.IssueKey")

//---------------------------------------------------------------
//Set response for getIssue
response = WS.sendRequestAndVerify(findTestObject('Old/GetIssue'))

// verify issueType
WS.verifyElementPropertyValue(response, 'fields.issuetype.name', 'Task')

'Adding a new componet to issue'
WS.sendRequestAndVerify(findTestObject('Old/UpdateIssue', [('URL') : GlobalVariable.URL, ('IssueKey') : GlobalVariable.IssueKey]))

'Transition issue'
WS.sendRequestAndVerify(findTestObject('Old/TransitionIssue', [('URL') : GlobalVariable.URL, ('IssueKey') : GlobalVariable.IssueKey
            , ('TransitionId') : '51']))

