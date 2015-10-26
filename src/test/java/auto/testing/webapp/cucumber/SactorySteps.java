package auto.testing.webapp.cucumber;

import auto.testing.utilities.RandomData;
import auto.testing.webapp.steps.AccountSteps;
import auto.testing.webapp.steps.EndUserSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SactorySteps {
	
	RandomData randomData = new RandomData();
	String preData = randomData.getStr(5);

	@Steps
	EndUserSteps endUser;
	
	@Steps
	AccountSteps account;

	@When("^login with role is \"([^\"]*)\"$")
	public void login_with_role_is(String role) {
		switch (role) {
		case "admin":
			log_in("haianh_nt@septeni-technology.jp", "DQLmMla9");
			break;
		case "director":
			log_in("director_test@gmail.com", "pdewzZHj");
			break;
		case "designer":
			log_in("designer_test@gmail.com", "scwLVG6c");
			break;
		default:
			System.out.println("Only 3 roles are: admin | director | designer");
			break;
		}
	}
	
	@When("^go to user list$")
	public void go_to_user_list(){
		endUser.click_on_the("menu.MasterDataManagement");
		endUser.click_on_the("manage.user");
	}
	
	@When("^go to client list page$")
	public void go_to_client_list(){
		endUser.click_on_the("menu.MasterDataManagement");
		endUser.click_on_the("manage.client");
	}
	
	@When("^go to industry list page$")
	public void go_to_industry_list(){
		endUser.click_on_the("menu.MasterDataManagement");
		endUser.click_on_the("manage.industry");
	}
	
	@When("^add \"([^\"]*)\" account with email is \"([^\"]*)\"$")
	public void add_account_with_email_is(String username, String email){
		endUser.click_on_the("userList.addBtn");

		endUser.enter_into_the_field_with("addAccount.username", preData +" " + username);
		endUser.enter_into_the_field_with("addAccount.email", preData +"_" + email);
		endUser.click_on_the("addAccount.okBtn");
	}
	
	@Then("^\"([^\"]*)\" and \"([^\"]*)\" information is shown correctly$")
	public void and_information_is_show_correctly(String username, String email){
		endUser.the_text_element_should_contain("userlist.table", preData +" " + username);
		endUser.the_text_element_should_contain("userlist.table", preData +"_" + email);
	}
	
	@Then("^\"([^\"]*)\" and \"([^\"]*)\" information is disappread$")
	public void and_information_is_disappread(String username, String email){
		endUser.the_text_element_should_not_contain("userlist.table", preData +" " + username);
		endUser.the_text_element_should_not_contain("userlist.table", preData +"_" + email);
	}
	
	@When("^select account has email is \"([^\"]*)\" to edit$")
	public void select_account_has_email_is_to_edit(String email) {
		account.select_item_to_edit_by(email);
	}
	
	@When("^select account has email is \"([^\"]*)\" to delete$")
	public void select_account_has_email_is_to_delete(String email) {
		account.select_item_to_delete_by(email);
	}
	
	@When("^select \"([^\"]*)\" item in the list to edit$")
	public void select_item_in_the_list_to_edit(String textValue){
		account.select_item_to_edit_by(textValue);
	}

	@When("^select \"([^\"]*)\" item in the list to delete$")
	public void select_item_in_the_list_to_delete(String textValue){
		account.select_item_to_delete_by(textValue);
	}
	
	@When("^edit user name is \"([^\"]*)\" and email is \"([^\"]*)\"$")
	public void edit_user_name_is_and_email_is(String username, String email){
		endUser.type_into_the_field_with("editForm.username", preData +" " + username);
		endUser.type_into_the_field_with("editForm.email", preData +"_" + email);
		endUser.click_on_the("editForm.okBtn");
	}

	private void log_in(String email, String pwd){
		endUser.enter_into_the_field_with("loginPage.email", email);
		endUser.enter_into_the_field_with("loginPage.pwd", pwd);
		endUser.click_on_the("loginPage.submit");
	}
	
	
	@When("^create new industry with name is \"([^\"]*)\"$")
	public void create_new_industry_with_name_is(String indusName){
		endUser.type_into_the_field_with("industry.name", preData +" " + indusName);
	}
	
	@When("^edit industry name is \"([^\"]*)\"$")
	public void edit_industry_with_name_is(String indusName){
		endUser.type_into_the_field_with("industry.editName", preData +" " + indusName);
		endUser.click_on_the("industry.edit.ok");
	}
	
	@Then("^\"([^\"]*)\" industry information is shown correctly$")
	public void industry_information_is_shown_correctly(String industryName){
		endUser.the_text_element_should_contain("industry.table", preData +" " + industryName);
	}
	
	@Then("^\"([^\"]*)\" industry name information is disappread$")
	public void industry_name_information_is_disappread(String industryName){
		endUser.the_text_element_should_not_contain("industry.table", preData +" " + industryName);	
	}
	
	@When("^create \"([^\"]*)\" client with \"([^\"]*)\" industry$")
	public void create_client_with_industry(String clientName, String industryName) {
		endUser.type_into_the_field_with("client.name", preData +" " + clientName);
		endUser.click_on_the("client.industry");
		endUser.type_into_the_field_with("client.industrySearch", preData +" " + industryName);
		endUser.click_on_the("client.industryAtFirst");
		endUser.type_into_the_field_with("client.description", preData +" description");
		endUser.click_on_the("client.add.ok");
	}
	
	@Then("^\"([^\"]*)\" client information is shown correctly$")
	public void client_information_is_shown_correctly(String value){
		endUser.the_text_element_should_contain("client.table", preData +" " + value);
	}

}
