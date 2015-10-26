package auto.testing.webapp.steps;

import auto.testing.webapp.pages.PageCore;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AccountSteps extends ScenarioSteps {
	
	PageCore pageCore;

	@Step
	public void select_item_to_edit_by(String valueText) {
		pageCore.$("//*[contains(text(),'"+valueText+"')]/following::a[contains(@ng-click,'BoxEdit')]").click();
	}

	@Step
	public void select_item_to_delete_by(String valueText) {
		pageCore.$("//*[contains(text(),'"+valueText+"')]/following::a[contains(@ng-click,'confirmDelete')]").click();
	}

}
