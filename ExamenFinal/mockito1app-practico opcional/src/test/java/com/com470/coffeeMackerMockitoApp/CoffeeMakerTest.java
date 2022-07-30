package com.com470.coffeeMackerMockitoApp;
import com.com470.coffeeMackerMockitoApp.exceptions.InventoryException;
import com.com470.coffeeMackerMockitoApp.exceptions.RecipeException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CoffeeMakerTest {
	
	//-----------------------------------------------------------------------
	//	DATA MEMBERS
	//-----------------------------------------------------------------------
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	private Recipe recipe5;
	
	private Recipe [] stubRecipies; 
	
	/**
	 * The coffee maker -- our object under test.
	 */
	private CoffeeMaker coffeeMaker;
	
	/**
	 * The stubbed recipe book.
	 */
	private RecipeBook recipeBookStub;
	
	private Inventory inventory;
	
	@Before
	public void setUp() throws RecipeException {
		
		recipeBookStub = mock(RecipeBook.class);
		inventory = mock(Inventory.class);
		coffeeMaker = new CoffeeMaker(recipeBookStub, inventory);
		
		//Set up for recipe1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for recipe2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for recipe3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for recipe4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
		
		//Set up for recipe5 (added by MWW)
		recipe5 = new Recipe();
		recipe5.setName("Super Hot Chocolate");
		recipe5.setAmtChocolate("6");
		recipe5.setAmtCoffee("0");
		recipe5.setAmtMilk("1");
		recipe5.setAmtSugar("1");
		recipe5.setPrice("100");

		stubRecipies = new Recipe [] {recipe1, recipe2, recipe3};
	}
	
	
	//-----------------------------------------------------------------------
	//	Test Methods
	//-----------------------------------------------------------------------
	
	// put your tests here!
	
	/*@Test
	public void testCoffeeMaker() {
		throw new RuntimeException("not yet implemented");
	}*/
	
	@Test
	public void testAddRecipeOk() {
		Mockito.when(recipeBookStub.addRecipe(recipe1)).thenReturn(true);
		boolean result = coffeeMaker.addRecipe(recipe1);
		assertTrue(result);
	}
	
	@Test
	public void testAddRecipeNoOk() {
		Mockito.when(recipeBookStub.addRecipe(recipe1)).thenReturn(false);
		boolean result = coffeeMaker.addRecipe(recipe1);
		assertFalse(result);
	}

	@Test
	public void testDeleteRecipeOk() {
		int recipeIndex = 0;
		Mockito.when(recipeBookStub.deleteRecipe(recipeIndex)).thenReturn(stubRecipies[recipeIndex].getName());
		String nameRecipeDeleted = coffeeMaker.deleteRecipe(recipeIndex);
		assertEquals(recipe1.getName(), nameRecipeDeleted);
	}
	
	@Test
	public void testDeleteRecipeNoOk() {
		int recipeIndex = 3;
		Mockito.when(recipeBookStub.deleteRecipe(recipeIndex)).thenReturn(null);
		String nameRecipeDeleted = coffeeMaker.deleteRecipe(recipeIndex);
		assertNull(nameRecipeDeleted);
	}

	@Test
	public void testEditRecipeOk() {
		int recipeIndex = 0;
		Mockito.when(recipeBookStub.editRecipe(recipeIndex, recipe2)).thenReturn(recipe1.getName());
		String nameRecipeEdited = coffeeMaker.editRecipe(recipeIndex, recipe2);
		assertEquals(recipe1.getName(), nameRecipeEdited);
	}
	
	@Test
	public void testEditRecipeNoOk() {
		int recipeIndex = 0;
		Mockito.when(recipeBookStub.editRecipe(recipeIndex, recipe2)).thenReturn(null);
		String nameRecipeEdited = coffeeMaker.editRecipe(recipeIndex, recipe2);
		assertNull(nameRecipeEdited);
	}

	@Test
	public void testAddInventory() {
		try {
			coffeeMaker.addInventory("a", "b", "c", "d");
			Mockito.verify(inventory).addCoffee("a");
			Mockito.verify(inventory).addMilk("b");
			Mockito.verify(inventory).addSugar("c");
			Mockito.verify(inventory).addChocolate("d");
		} catch (InventoryException e) {
			
		}
	}

	@Test
	public void testCheckInventory() {
		Mockito.when(inventory.toString()).thenReturn("");
		String inventoryString = coffeeMaker.checkInventory();
		assertEquals(inventoryString, "");
	}

	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying more than 
	 * 		the coffee costs
	 * Then we get the correct change back.
	 */
	@Test
	public void testMakeCoffeeRecipeToPurchase1() {
		int recipeIndex = 2;
		int paid = 100;
		Mockito.when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
		int expectedChange = coffeeMaker.makeCoffee(recipeIndex, paid);
		assertEquals(expectedChange, paid);
	}
	
	@Test
	public void testMakeCoffeeRecipeToPurchase2() {
		int recipeIndex = 0;
		int paid = 100;
		Mockito.when(inventory.useIngredients(recipe1)).thenReturn(true);
		Mockito.when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
		int expectedChange = coffeeMaker.makeCoffee(recipeIndex, paid);
		assertEquals(expectedChange, paid - recipe1.getPrice());
	}
	
	@Test
	public void testMakeCoffeeRecipeToPurchase3() {
		int recipeIndex = 2;
		int paid = 100;
		Recipe [] recipes = new Recipe [] {null, null, null};
		Mockito.when(recipeBookStub.getRecipes()).thenReturn(recipes);
		int expectedChange = coffeeMaker.makeCoffee(recipeIndex, paid);
		assertEquals(expectedChange, paid);
	}
	
	@Test
	public void testMakeCoffeeRecipeToPurchase4() {
		int recipeIndex = 0;
		int paid = 40;
		Mockito.when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
		int expectedChange = coffeeMaker.makeCoffee(recipeIndex, paid);
		assertEquals(expectedChange, paid);
	}

	@Test
	public void testGetRecipes() {
		Mockito.when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
		Recipe [] expectedRecipes = coffeeMaker.getRecipes();
		assertEquals(expectedRecipes.length, stubRecipies.length);
		Mockito.verify(recipeBookStub).getRecipes();
	}
		
}
