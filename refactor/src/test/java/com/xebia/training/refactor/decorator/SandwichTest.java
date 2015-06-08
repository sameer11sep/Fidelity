package com.xebia.training.refactor.decorator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class SandwichTest {

	@Test
    public void shouldCreateASandwichWithWhiteBreadAndCheese(){
        AbstractSandwich sandwich=new PlainSandwich(BreadType.WHITE);
        sandwich = new CheeseSandwichDecorator(sandwich);
        assertEquals(BigDecimal.valueOf(20),sandwich.getPrice());
        assertTrue(sandwich.getDescription().toLowerCase().contains("white"));
        assertTrue(sandwich.getDescription().toLowerCase().contains("cheese"));
    }

    @Test
    public void shouldCreateASandwichWithBrownBreadAndMeat(){
        AbstractSandwich sandwich=new PlainSandwich(BreadType.BROWN);
        sandwich=new MeatSandwichDecorator(sandwich);
        assertEquals(BigDecimal.valueOf(40.0),sandwich.getPrice());
        assertTrue(sandwich.getDescription().toLowerCase().contains("brown"));
        assertTrue(sandwich.getDescription().toLowerCase().contains("meat"));
    }
    
    @Test
	public void shouldCreateASandwichWithSauceWhiteBreadAndMeat() throws Exception {
    	AbstractSandwich sandwich=new PlainSandwich(BreadType.BROWN);
        sandwich=new MeatSandwichDecorator(sandwich);
        sandwich = new SauceDecorator(sandwich);
        sandwich=new CheeseSandwichDecorator(sandwich);
        assertEquals(BigDecimal.valueOf(50.0), sandwich.getPrice());
	}


}
