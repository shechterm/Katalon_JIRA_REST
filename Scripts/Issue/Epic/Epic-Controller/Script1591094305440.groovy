import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.junit.After

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

//Init Params



//TODO: Change String body to json builder,
//Epic name = 

//Design required
// Requires Automation
// Documentation required
String body  = """
{
   \r\n    \"fields\":{
      \r\n       \"project\":\r\n      {
         \r\n          \"key\":\"${projectKey}\"         \r\n
      },
	 \r\n       \"customfield_10002\":\"${epicName}\",
      \r\n       \"summary\":\"${summary}\",
      \r\n       \"description\":\"${description}\",
	  \r\n       \"customfield_10504\":{\"value\": \"yes\" },
	  \r\n       \"customfield_11701\":{\"value\": \"Yes\" },
	  \r\n       \"customfield_12700\":{\"value\": \"Yes\" },
      \r\n       \"customfield_10113\":[
         {
            \"value\":\"${relevantPlatform}\"
         }
      ],
      \r\n        \"assignee\":{\"name\":\"${assignee}\"\r\n},
                \"reporter\":{
         \r\n      \"name\":\"${reporter}\"\r\n
      },
      \r\n    \"components\":[
         \r\n         {
            \r\n        \"name\":\"${component}\"\r\n
         }         \r\n
      ],
 
      \r\n          \"priority\":{
         \r\n      \"name\":\"${priority}\"\r\n
      },
      \r\n       \"issuetype\":{
         \r\n          \"name\":\"${issueType}\" \r\n
      }      \r\n
   }   \r\n
}\r\n
"""



println "body ="+body
//
// Call Create issue test case

WS.callTestCase(findTestCase('Issue/Operation/Create_Issue'),[('body'):body],FailureHandling.STOP_ON_FAILURE)

println "Epic controller response= $GlobalVariable.response"
//
//
//
//// ### Validate type of task after the create###. 
//println GlobalVariable.response
//
//String issueKey = GlobalVariable.response.key
String id = GlobalVariable.response.id

//println "issue key = ${issueKey} | key = ${id}"

////Check all issues another the epic was created
String  jql= "Epic Link =\"${id}\""
WS.callTestCase(findTestCase('/jql/runJql'),[('jql'):jql],FailureHandling.STOP_ON_FAILURE)
//
//
//
//
//
//
//
//
//
//
//
//// Call get transition testCase
//WS.callTestCase(findTestCase('Issue/Operation/getTransition'),[('issueKey'):issueKey],FailureHandling.STOP_ON_FAILURE)
//println "### get transition response from  controller  = ${GlobalVariable.response}  #####"
//
//GlobalVariable.response.transitions.each{ println it.name}
//
//println GlobalVariable.response
//
//requriedTransitionName = 'In Progres3'
//
//String transitionId = GlobalVariable.response.transitions.find{ it.name ==requriedTransitionName }.id
//println "transitionId = ${transitionId}"
//
//
////Call transitionIssue testCase
//// Set Request body - need to change
//body="""
//{
//   "fields":{
//   "fixVersions":[
//                  {
//                    "name":"SBC-M3100"
//         } 
//      ],
//      "description":"test-rest input1"
//   },
//   "transition":{
//      "id":"121"
//   }
//}
//"""
//WS.callTestCase(findTestCase('Issue/Operation/Transition_Issue'),[('issueKey'):issueKey,('transitionId'):transitionId,('body'):body],FailureHandling.STOP_ON_FAILURE)
//
//// Get transitions
//requriedTransitionName = 'Done'
//WS.callTestCase(findTestCase('Issue/Operation/getTransition'),[('issueKey'):issueKey],FailureHandling.STOP_ON_FAILURE)
//transitionId = GlobalVariable.response.transitions.find{ it.name ==requriedTransitionName }.id
//// Move issue to Done
//body="""
//{
//   "fields":{
//   "resolution": {
//                "name": "Tested"
//            }
//   },
//   "transition":{
//      "id":"${transitionId}"
//   }
//}
//"""
//WS.callTestCase(findTestCase('Issue/Operation/Transition_Issue'),[('issueKey'):issueKey,('transitionId'):transitionId,('body'):body],FailureHandling.STOP_ON_FAILURE)
//
//








