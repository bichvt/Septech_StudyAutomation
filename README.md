# AutoSepTech
======================================================

As a manual tester who have limited knowledge about the programming language but I would like to have a tool to allow me write automation test script by using the formal specification language. (Gherkins)

======================================================

Steps are used to write AT scripts

# I. Assertion
### Element
#### the text "target" element should be "valueText"
#### the text "target" element should not be "valueText"
#### the text "target" element should contain "valueText" 
#### the text "target" element should not contain "valueText"
#### the "target" element should be disabled		
#### the "target" element should be enabled	 	 
#### the "target" element should not be present
#### the "target" element should be present	 
#### the "target" element should be visible 	 
#### the "target" element should be hidden		

### Attribute 
#### the "attribute" attribute of "target" should contain "value"
#### the "attribute" attribute of "target" should be "value"
#### the "attribute" attribute of "target" should not contain "value"
#### the "attribute" attribute of "target" should not be "value"	 

### Comparesion
#### "var" variable should be "valueText"

### Browser
#### the page should contain "valueText"
#### the page should not contain "valueText"
#### the page title should contain "value"
#### the page title should not contain "value"
#### the page title should be "value"
#### the page title should not be "value"
#### the absolute URL of the current page should be "url"

### Field
#### the value of  "target" field should be "value"
#### the value of  "target" field should not be "value"
#### the value of  "target" field should contain "value"
#### the value of  "target" field should not contain "value"

### Listbox
#### the "visiableText" option label in "target" should be selected
#### the "visiableText" option label in "target" should not be selected

# II. Wait
#### wait for the "target" element to be clickable
#### wait for the "target" element to be visibile
#### wait for any "textValue" text to be present
#### wait for any "textValue" text to be disappread
#### wait for x seconds


# III. Stored var
#### store the text of "target" element in "var" variable 

# IV. Action

## Browser
#### open the home page
#### open the "url"
#### open "url" in new window and switch to it
#### open "target" link in a new window and switch to it
#### navigate to "url"
#### maximize the window
#### move forward one page
#### move backward one page
#### reload the page
#### change window size with width 500 px and height 800 px
#### close current window
#### scroll screen at 100 follow the horizontal line and 200 follow vertical line
#### switch back to the original window
#### move window to new position with coordinates at x and y on screen
#### click on the "target" to open pop-up window and switch to it

## Field box element
#### enter into the "target" field with "value"
#### enter into the ckeditor "target" field with "value"
#### type into the "target" field with "value"

## Dialogs and Alerts
#### follow confirm box "target" and accept the currently displayed dialog
#### follow confirm box "target" and dismiss the currently displayed dialog
#### follow prompt box "target" and answer the prompt on the dialog is "value"

## List box
#### select "visibleText" label from "target" drop-down list
#### select number index from "target" drop-down list
#### select "valueOption" value from "target" drop-down list
#### add multi-select "list" options from "target" drop-down list 
#### remove multi-select "list" options from "target" drop-down list

## Mouse
#### click on the "target"
#### click on the "target" at coordinates x and y
#### double click on the "target"
#### double click on the "target" at coordinates x and y
#### right click on the "target"
#### right click on the "target" at coordinates x and y
#### right click on the "target" and click on item has index is 1
#### right click the "target" at coordinates x and y and click on item has index is 1
#### drag the "resource" and drop to the "destination" 
#### drag the "resource" and drop to the "destination" at coordinates x and y [inprogress]
#### hold the "target" and move by offset 5 and 7 [inprogress]
#### click and hold the "target"
#### move mouse to "target"
#### move mouse to "target" at coordinates x and y
#### upload "filePath" file

# HTML 5
#### html5 - drag the "target" and drop to the "destination"

# Image
### capture an exact image of "target" element on the screen and save it in "pathStoreFile"
### capture an exact image of "target" element on the screen and save as "nameImage.png"
### actual "Image1.png" image and expected "Image2.png" image should be similar

# Other
### change "attr" attribute of "target" into "valueAttr"
### highlight "target" element
### set bound for "target" element

# Frame
### swich to "target" frame
### swich back to parent frame
### swich back to main frame

# Random
### enter random into "target" field with data length is x