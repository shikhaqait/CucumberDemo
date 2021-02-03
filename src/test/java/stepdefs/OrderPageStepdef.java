package stepdefs;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.OrderPageKeywords;
import logger.MainLogger;

public class OrderPageStepdef {
	
	private OrderPageKeywords orderPageKeywords;

    public OrderPageStepdef() {
        this.orderPageKeywords = new OrderPageKeywords();
    }

	@Then("product should be added into the cart")
	public void product_should_be_added_into_the_cart() {
	   String productTitle = orderPageKeywords.getProductTile();
	   Assert.assertTrue(!productTitle.isEmpty());
	   MainLogger.logger().info("Product title is "+productTitle);
	}

	@When("user click on the delete product icon")
	public void user_click_on_the_delete_product_icon() {
	    orderPageKeywords.clickOnDeletProduct();
	    MainLogger.logger().info("Click on delete product");
	}

	@Then("product should be deleted from the cart")
	public void product_should_be_deleted_from_the_cart() {
		Assert.assertTrue("Cart is not empty",orderPageKeywords.getEmptyCartVisibility());
		MainLogger.logger().info("Assertion Passed : Shopping cart is empty");
	}
	
	@Then("empty cart should be displayed")
	public void empty_cart_should_be_displayed() {
		 Assert.assertTrue("Cart is not empty",orderPageKeywords.getEmptyCartVisibility());
		 MainLogger.logger().info("Assertion Passed : Shopping cart is empty");
	}
}
