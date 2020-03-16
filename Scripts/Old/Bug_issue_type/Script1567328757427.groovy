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
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent

def slurper = new groovy.json.JsonSlurper()

//Create new Request
def request = (RequestObject)findTestObject('Old/CreateIssue')
print request
def  bugParams = GlobalVariable.testCaseParams
//println bugParams.projectKey



// Request  Body
String body  = """
{
   \r\n    \"fields\":{
      \r\n       \"project\":\r\n      {
         \r\n          \"key\":"${bugParams.projectKey}"         \r\n
      },
      \r\n       \"summary\":"${bugParams.summary}",
      \r\n       \"description\":"${bugParams.description}",
      \r\n       \"customfield_10107\":{
         \"value\":\"FieldBug\"
      },
      \r\n       \"customfield_10113\":[
         {
            \"value\":\"None\"
         }
      ],
      \r\n       \"customfield_10114\":\"3.1.2.89\",
      \r\n       \"customfield_10102\":{
         \r\n      \"value\":\"Functional\"\r\n
      },
      \r\n    \"customfield_10803\":\"AudioCodes Test\",
      \r\n    \"customfield_10601\":\"2705\",
      \r\n    \"customfield_10509\":\"180924-000152\",
      \r\n        \"assignee\":null,
      \r\n            \"reporter\":{
         \r\n      \"name\":\"DanielSh\"\r\n
      },
      \r\n    \"components\":[
         \r\n         {
            \r\n        \"name\":\"ETAS\"\r\n
         }         \r\n
      ],
      \r\n    \"versions\":[
         \r\n         {
            \r\n        \"name\":\"VOCAVB7.7.5\"\r\n
         }         \r\n
      ],
      \r\n          \"priority\":{
         \r\n      \"name\":\"Medium\"\r\n
      },
      \r\n       \"issuetype\":{
         \r\n          \"name\":"${bugParams.issueType}"\r\n
      }      \r\n
   }   \r\n
}\r\n

"""
try{
	request.setBodyContent(new HttpTextBodyContent(body,"UTF-8", "application/json"))
}
catch(Exception ex){
println(ex.detailMessage)
}
//Set Response object
def response  =  WS.sendRequest(request)
//Check  Response code is the 200  || stop if fail
WS.verifyResponseStatusCodeInRange(response, 200, 400,FailureHandling.STOP_ON_FAILURE)
def result = slurper.parseText(response.getResponseBodyContent())
// Get BugIsuueType key
GlobalVariable.testCaseParams.bugIssueKey = result.key  

println bugParams.bugIssueKey
//get bug issue object
request = (RequestObject)findTestObject('Old/GetIssue')

response = WS.sendRequestAndVerify(findTestObject('Old/GetIssue'))
println slurper.parseText(response.getResponseBodyContent())

// verify issueType
WS.verifyElementPropertyValue(response, 'fields.issuetype.name', 'Bug')





 

