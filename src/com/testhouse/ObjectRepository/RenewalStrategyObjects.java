package com.testhouse.ObjectRepository;

import org.openqa.selenium.By;

import com.testhouse.Functions.GeneralFunctions;

public class RenewalStrategyObjects extends GeneralFunctions
{
	/* Renewal Startegy Objects */
	public By accountAdminLink = By.linkText("Account Admin");
	public By manageRenewal = By.id("iconid_manageRS");
	public By clientSelect = By.id("form:client");
	
	public By brandSelect(String brand)
	{
		By brandSelect = By.linkText(brand);
		return brandSelect;
	}
	public By fastFoward = By.xpath("//td[text()='»']");
	public By addRenewal = By.id("form:id_addRenewalStrategyButton");
	
	/* New Renewal */
	public By renewalName = By.id("form:id_nameDecorator:name");
	public By renewalDesc = By.id("form:id_descriptionDecorator:desc");
	public By startDate = By.id("form:id_startDateDecorator:fromInputDate");
	public By endDate = By.id("form:id_endDateDecorator:toInputDate");
	public By expiryDate = By.id("form:id_expiryDateDecorator:expiresInputDate");
	public By activeCheck = By.id("form:id_activeDecorator:id_active");	
	public By type = By.id("form:j_id149comboboxField");
	public By findDefaultPro = By.id("form:j_id155");
	public By findPro = By.id("id_promoForm:j_id176");
	
	public By selectRPromotion(String promotion)
	{
		By selectRPromotion = By.xpath("//tr/td[@class='rich-table-cell center'  and text ()='"+promotion+"']/following-sibling::td/input");
		return selectRPromotion;
	}
	
	public By selectPro = By.id("id_promoForm:j_id196");
	
	public By findDefaultOff = By.id("form:findOfferButton");
	
	public By searchOffer = By.id("id_offerForm:j_id241");
	
	public By selectROffer(String offer)
	{
		By selectRoffer = By.xpath("//tr/td[@class='rich-table-cell center'  and text ()='"+offer+"']/following-sibling::td/input");
		return selectRoffer;
	}
	public By selOffer = By.id("id_offerForm:j_id256");
	public By saveButton = By.id("form:id_saveButton");
	public By backButton = By.id("form:id_backButton");
	
	public By eventDelivery = By.xpath("//*[@id='j_id99:j_id130_body']/table/tbody/tr[2]/td[2]/select");
	public By backDelivery = By.id("j_id99:id_IncludeOption:0");
	public By schButton = By.id("id_scheduleForm:id_schedulesButton");
	
	public By eventDelivery(String bIssues)
	{
		By eventDelivery = By.xpath("//tr[2]/td[2]/input");
		// By eventDelivery = By.xpath("//*[contains(text(),'JUL 05')]/parent::td/following::input");
        return eventDelivery;
	}
	
	public By test = By.id("j_id99:id_allbackIssues:1:id_selectedBackIssue");
	
	public By findRenewal(String name)
	 {
	  By brandSelect = By.xpath("//*[contains(text(),'"+name+"')]");
	  return brandSelect;
	 }

	/* Edit Schedule*/
	public By editSchedule(String schedule) 
	{
	By editSchedule	= By.xpath("//*[contains(text(),'"+schedule+"')]//following::td[3]");
	return editSchedule;
	}
	public By schOffer = By.id("id_scheduleForm:id_offersButton");
	public By offerManager = By.xpath("//*[contains(text(),'Offers')]");
	
	
	/* New Event */
	public By scheduleEventsBtn = By.id("id_scheduleForm:id_eventsButton");
	public By newEventBtn = By.id("form:j_id93");
	public By eventWhen = By.id("j_id99:eventWhen");
	public By eventDeliveryType = By.id("j_id99:deliverableType");
	public By eventNextBtn = By.id("j_id99:j_id149");
	public By eventDest = By.id("j_id99:destinationType");
	public By eventFinishBtn = By.id("j_id99:j_id150");
	public By eventSaveBtn = By.id("form:j_id94");
	public By eventBackBtn = By.id("form:j_id95");
}
