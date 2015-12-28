package auto.septech.steps;

import auto.septech.coreactions.PageCore;
import net.thucydides.core.annotations.Step;

public class AccountSteps extends EndUserBaseSteps {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
