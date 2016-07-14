package com.testhouse.Functions;

import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.testhouse.ObjectRepository.SchedulesObjects;
import com.testhouse.ObjectRepository.RenewalStrategyObjects;

public class RenewalStrategyFunctions extends RenewalStrategyObjects
{
	public static String testName;

	/**
	 * Method to create a new renewal startegy
	 * @param driver Object for webdriver
	 * @param client Object for selecting a client from the list
	 * @param brand Object for selecting a brand from the list
	 * @param opt Object to check / uncheck the optimistic check box
	 * @param cal Object to check / uncheck the Calendar check box
	 * @param act Object to check / uncheck the Active check box
	 * @param name Object for naming the schedule
	 * @param description Object defined for the schedule description
	 * @param type Object to select whether the schedule is an Issue / Product
	 * @param when Object for choosing when the event should be scheduled
	 * @param delType Object for selecting the event delivery type
	 * @param dest Object for selecting the destination option from the list
	 * @throws Exception To throw an exception whenever an unexpected failure occurs
	 */
	public void renewalStartegy(WebDriver driver, String client, String brand,String name, String description, String starDate, String enDate, String expDate, String act, String typeRenewal, String promotion, String offer) throws Exception
	{
		try
		{
			element(driver, accountAdminLink).click();	
			TimeUnit.SECONDS.sleep(10);
			for (String winHandle : driver.getWindowHandles()) 
			{
				driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
			element(driver, manageRenewal).click();
			TimeUnit.SECONDS.sleep(10);
			Select(element(driver, clientSelect)).selectByVisibleText(client);

			for (int i = 1; i <= 100; i++)
			{
				try
				{
					element(driver, brandSelect(brand)).click();
					TimeUnit.SECONDS.sleep(7);
					break;
				}

				catch (Exception e)
				{
					element(driver, fastFoward).click();
				}
			}	
			TimeUnit.SECONDS.sleep(8);

			try
			{
				element(driver, addRenewal).isEnabled();
				element(driver, addRenewal).click();
			}
			catch (Exception e)
			{
				TimeUnit.SECONDS.sleep(5);
				element(driver, addRenewal).click();
			}


			TimeUnit.SECONDS.sleep(3);
			DateTime dt = DateTime.now();
			String dateFolder = dt.toLocalDate().toString();

			element(driver, renewalName).click();
			element(driver, renewalName).clear();
			element(driver, renewalName).sendKeys(""+name+""+" "+dateFolder+"");
			TimeUnit.SECONDS.sleep(3);
			element(driver, renewalDesc).sendKeys(description);
			TimeUnit.SECONDS.sleep(3);
			element(driver, startDate).clear();
	        element(driver, startDate).sendKeys(starDate);
	        element(driver, startDate).clear();
			element(driver, endDate).sendKeys(enDate);
			element(driver, startDate).clear();
			element(driver, expiryDate).sendKeys(expDate);
			if(act.equals("Yes")||act.equals("yes"))
			{
			element(driver, activeCheck).click();
			}
			element(driver, type).sendKeys(typeRenewal);
			TimeUnit.SECONDS.sleep(3);
			element(driver, findDefaultPro).click();
			TimeUnit.SECONDS.sleep(3);
			element(driver, findPro).click();
			TimeUnit.SECONDS.sleep(3);
			element(driver, selectRPromotion(promotion)).click();
			TimeUnit.SECONDS.sleep(3);
			element(driver, selectPro).click();
			TimeUnit.SECONDS.sleep(3);
			element(driver, findDefaultOff).click();
			TimeUnit.SECONDS.sleep(3);
			element(driver, searchOffer).click();
			element(driver, selectROffer(offer)).click();
			TimeUnit.SECONDS.sleep(3);
			element(driver, selOffer).click();
			TimeUnit.SECONDS.sleep(3);
			element(driver, saveButton).click();
			TimeUnit.SECONDS.sleep(5);
			element(driver, backButton).click();
			TimeUnit.SECONDS.sleep(5);
			
			
			if(element(driver, findRenewal(""+name+""+" "+dateFolder+"")).isDisplayed())
			{
				ATUReports.add("Created and verified a new Renewal Strategy: "+""+name+""+" "+dateFolder+"", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			else
			{
				ATUReports.add("Unable to verify the newly Renewal Startegy", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				takeScreenShotOnFailure(driver, testName);
			}
			
		}

		catch (Exception e)
		{
			ATUReports.add("Unable to create a new schedule", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			takeScreenShotOnFailure(driver, testName);
		}
	}
	
}

