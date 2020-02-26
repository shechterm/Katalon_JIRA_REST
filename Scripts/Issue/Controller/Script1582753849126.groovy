import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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


//Set Params for create issu test case
String projectKey = 'SBC';
String description = "This is Description";
String summary = "This is Summary";
String issueType = "Bug";
//Request body
String body  = """
{
   \r\n    \"fields\":{
      \r\n       \"project\":\r\n      {
         \r\n          \"key\":\"${projectKey}\"         \r\n
      },
      \r\n       \"summary\":\"${summary}\",
      \r\n       \"description\":\"${description}\",
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
         \r\n          \"name\":\"${issueType}\" \r\n
      }      \r\n
   }   \r\n
}\r\n

"""

// Call Create issue test case
def crateIssueResponse =  WS.callTestCase(findTestCase('Issue/Create_Issue'),[('body'):body],FailureHandling.CONTINUE_ON_FAILURE)

println "crateIssueResponse = ${crateIssueResponse}"

