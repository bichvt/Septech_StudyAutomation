Feature: autoseptech demo
Background:
	When open the home page
	When open "demo.url" in new window and switch to it
	When open the "demo.registurl"
	When close current window
	When switch back to the original window
	When navigate to "demo.registurl" 
	When move backward one page
	When move forward one page
	When reload the page
	
Scenario: autoseptech demo
	#textbox
	When enter into the "demo.firstname" field with value "{!auto,J46}"
	When enter into the "demo.firstname" field with value "{!auto,S46}"
	When enter into the "demo.firstname" field with value "{!auto,s46}"
	When enter into the "demo.firstname" field with value "{!auto,N6}"
	When enter into "demo.lastname" field with random value that its length is 9
	When enter into the "demo.firstname" field with value "{!auto,S10,!test}" and store into variable "varfirstname"
	When enter into the "demo.lastname" field with value of variable "varfirstname"
	When enter into the "demo.email" field with value "{!auto,S8,!@gmail.com}"
	When enter into the "demo.email" field with value "phuongdt@gmail.com"
	When enter into the "demo.phone" field with value "084988045067"
	When enter into the "demo.username" field with value "phuongdt" and store into variable "varusername"
	When enter into the "demo.description" field with value "phuongdt" and store into variable "vardescription"
	When enter into the "demo.password" field with value "password"
	When enter into the "demo.confirmpassword" field with value "password" and store into variable "varpassword"
	
	#radio button
	When check on the "demo.single"
	
	#checkbox
	When click on the "demo.cricket"
	When check on the "demo.reading"
	When uncheck on the "demo.cricket"
	
	#dropdownbox
	When select the label "Albania" from  the drop down "demo.country"
	When select the value "Bahrain" from the drop down "demo.country"
	When select the index 0 from the drop down "demo.country"
	
	#upload file
	When upload on the element "demo.file" file "/src/test/resources/DataTest/jpg.jpg"
		
	#button
	#When press enter key
	When click on the "demo.submit"
	
	#other verify
	Then the page title should contain "| Demoqa"
	Then the page title should not contain "Registration1"
	Then the page title should be "Registration | Demoqa"
	Then the page title should not be "Registration | Demoqa1"
	Then the absolute URL of the current page should be "http://demoqa.com/registration/"
	
	#verify value
	Then the value of "demo.lastname" element should contain variable "varfirstname"
	Then the value of "demo.lastname" element should be variable "varfirstname"
	Then the value of "demo.email" element should contain "phuongdt@gmail.com"
	Then the value of "demo.email" element should be "phuongdt@gmail.com"
	
	Then the value of "demo.lastname" element should not contain variable "varpassword"
	Then the value of "demo.lastname" element should not be variable "varpassword"
	Then the value of "demo.email" element should not contain "description"
	Then the value of "demo.email" element should not be "description"
	
	#verify attribute
	Then the "value" attribute of "demo.email" should contain "phuongdt@gmail.com"
	Then the "value" attribute of  "demo.email" should not contain "description"
	Then the "value" attribute of "demo.email" should be "phuongdt@gmail.com"
	Then the "value" attribute of "demo.email" should not be "description"

	Then the "value" attribute of "demo.lastname" should contain variable "varfirstname"
	Then the "value" attribute of  "demo.lastname" should not contain variable "varpassword"
	Then the "value" attribute of "demo.lastname" should be variable "varfirstname"
	Then the "value" attribute of "demo.lastname" should not be variable "varpassword"
	
	#store text with variable
	When store the text of "demo.registmenu" element in "varregistmenu" variable
	When store the text of "demo.homemenu" element in "varhomemenu" variable
	Then the variable "varregistmenu" should be "Registration"
	Then the page should contain "Registration"
	Then the page should not contain "Registrationtest"
	
	#verify text
	Then the text of "demo.registmenu" element should contain variable "varregistmenu"
	Then the text of "demo.registmenu" element should be variable "varregistmenu"
	Then the text of "demo.registmenu" element should contain "Registration"
	Then the text of "demo.registmenu" element should be "Registration"
	
	Then the text of "demo.homemenu" element should not contain variable "varregistmenu"
	Then the text of "demo.homemenu" element should not be variable "varregistmenu"
	Then the text of "demo.homemenu" element should not contain "Registration"
	Then the text of "demo.homemenu" element should not be "Registration"
	
	#alert
	When navigate to "demo.url1"
	When open "Only Testing" link in a new window and switch to it
	When close current window
	When switch back to the original window
	#When change window size with width 450 px and height 320 px
	#When wait for 45 seconds
	When click on the element "demo.showmealert" and accept the alert popup
	When click on the element "demo.showmeconfirm" and dismiss the alert popup
	When click on the element "demo.showmepromt" and enter text "showmepromt" to alert popup
	Then click on the element "demo.showmealert" and alert popup should be message "demo.showmealertmsg" then accept alert
	Then click on the element "demo.showmeconfirm" and alert popup should be message "demo.showmeconfirmmsg" then dismiss alert
	Then click on the element "demo.showmealert" and alert popup should contain message "demo.showmealertmsg" then accept alert
	Then click on the element "demo.showmeconfirm" and alert popup should contain message "demo.showmeconfirmmsg" then dismiss alert
	
	#verify variable
	Then the variable "varusername" should be variable "vardescription"
	Then the variable "varfirstname" should not be variable "varpassword"
	Then the variable "varusername" should contain variable "vardescription"
	Then the variable "varfirstname" should not contain variable "varpassword"
	
	#enter editor
	When navigate to "demo.editorurl"
	When switch to "demo.editoriframe" frame
	When switch back to parent frame
	When enter into the editor "demo.editoriframe" field with value "texteditor"
    When enter into the editor "demo.editoriframe" field with value "texteditor2" and store into variable "vareditor"