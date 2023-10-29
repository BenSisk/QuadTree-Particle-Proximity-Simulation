/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.KF5008.AssessmentA;

import java.awt.Graphics2D;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import sun.jvm.hotspot.utilities.Assert;

/**
 *
 * @author nickdalton
 */
public class MobilePhoneNGTest {
    
    public MobilePhoneNGTest() {
    }
     MobilePhone aPhone ; 

    @BeforeMethod
    public void setUpMethod() throws Exception {
         aPhone = new MobilePhone(0,0,800,900  ) ; 
    }

    /**
     * Test of isDead method, of class MobilePhone.
     */
    @Test
    public void testIsDead() {
        System.out.println("isDead");
        MobilePhone instance = aPhone;
        boolean expResult = false;
        boolean result = instance.isDead();
        org.testng.Assert.assertEquals(result, expResult);
      
     
    }

    /**
     * Test of setDead method, of class MobilePhone.
     */
    @Test
    public void testSetDead() {
        System.out.println("setDead");
        boolean dead = false;
        MobilePhone instance = aPhone;
        instance.setDead(dead);
        org.testng.Assert.assertEquals(instance.dead , false ); 
    }

    /**
     * Test of isSperationLessThan method, of class MobilePhone.
     */
    @Test
    public void testIsSperationLessThan() {
       System.out.println("isSperationLessThan");
        double x = 0.0;
        double y = 10.0;
        double otherx = 0.0;
        double othery = 0.0;
        double critialDistance = 0.0;
        boolean expResult = true ;
        boolean result = MobilePhone.isSperationLessThan(x, y, otherx, othery, 11);
        assertEquals(expResult, result);
        
        result = MobilePhone.isSperationLessThan(x, 0, otherx, 100, 10);
        assertEquals(result, false);
       
    }

   

    /**
     * Test of hasMessage method, of class MobilePhone.
     */
    @Test
    public void testHasMessage() {
        System.out.println("hasMessage");
        MobilePhone instance = aPhone;
        boolean expResult = false;
        boolean result = instance.hasMessage();
        org.testng.Assert.assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setHasMessage method, of class MobilePhone.
     */
//    @Test
//    public void testSetHasMessage() {
//        System.out.println("setHasMessage");
//        boolean infected = false;
//        MobilePhone instance = aPhone;
//        instance.setHasMessage(infected);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getCommuncationRadius method, of class MobilePhone.
     */
//   @Test
//    public void testGetCommuncationRadius() {
//        System.out.println("getCommuncationRadius");
//        MobilePhone instance = aPhone;
//        int expResult = 0;
//        int result = instance.getCommuncationRadius();
//        org.testng.Assert.assertEquals(result, expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getHoz method, of class MobilePhone.
     */
//    @Test
//    public void testGetHoz() {
//        System.out.println("getHoz");
//        MobilePhone instance = aPhone;
//        int expResult = 0;
//        int result = instance.getHoz();
//        org.testng.Assert.assertEquals(result, expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getVert method, of class MobilePhone.
     */
//    @Test
//    public void testGetVert() {
//        System.out.println("getVert");
//        MobilePhone instance = aPhone;
//        int expResult = 0;
//        int result = instance.getVert();
//        org.testng.Assert.assertEquals(result, expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of gethVel method, of class MobilePhone.
     */
//    @Test
//    public void testGethVel() {
//        System.out.println("gethVel");
//        MobilePhone instance = aPhone;
//        double expResult = 0.0;
//        double result = instance.gethVel();
//        org.testng.Assert.assertEquals(result, expResult, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getvVel method, of class MobilePhone.
     */
//    @Test
//    public void testGetvVel() {
//        System.out.println("getvVel");
//        MobilePhone instance = aPhone;
//        double expResult = 0.0;
//        double result = instance.getvVel();
//        org.testng.Assert.assertEquals(result, expResult, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of boundHoz method, of class MobilePhone.
     */
//    @Test
//    public void testBoundHoz() {
//        System.out.println("boundHoz");
//        MobilePhone instance = aPhone;
//        instance.boundHoz();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of bounceVert method, of class MobilePhone.
     */
 //   @Test
//    public void testBounceVert() {
//        System.out.println("bounceVert");
//        MobilePhone instance = aPhone;
//        instance.bounceVert();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getDepth method, of class MobilePhone.
     */
 //   @Test
//    public void testGetDepth() {
//        System.out.println("getDepth");
//        MobilePhone instance = aPhone;
//        int expResult = 0;
//        int result = instance.getDepth();
//        org.testng.Assert.assertEquals(result, expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setDepth method, of class MobilePhone.
     */
 //   @Test
//    public void testSetDepth() {
//        System.out.println("setDepth");
//        int depth = 0;
//        MobilePhone instance = aPhone;
//        instance.setDepth(depth);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of draw method, of class MobilePhone.
     */
 //   @Test
//    public void testDraw() {
//        System.out.println("draw");
//        Graphics2D g = null;
//        MobilePhone instance = aPhone;
//        instance.draw(g);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of step method, of class MobilePhone.
     */
//    @Test
//    public void testStep() {
//        System.out.println("step");
//        MobilePhone instance = aPhone;
//        instance.step();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of communicate method, of class MobilePhone.
     */
//    @Test
//    public void testCommunicate() {
//        System.out.println("communicate");
//        MobilePhone other = aPhone;
//        MobilePhone instance = null;
//        instance.communicate(other);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of hashCode method, of class MobilePhone.
     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        MobilePhone instance = aPhone;
//        int expResult = 0;
//        int result = instance.hashCode();
//        org.testng.Assert.assertEquals(result, expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of equals method, of class MobilePhone.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        MobilePhone instance = aPhone;
        instance.hVel = 0 ; 
        instance.hoz = 1 ; 
        instance.vert = 2 ; 
        instance.vVel = 3.0 ; 
         
        boolean expResult = true;
        boolean result = instance.equals(aPhone);
        org.testng.Assert.assertEquals(result, expResult);
    
      
    }

    /**
     * Test of toString method, of class MobilePhone.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MobilePhone instance = aPhone;
         instance.hVel = 0 ; 
        instance.hoz = 1 ; 
        instance.vert = 2 ; 
        instance.vVel = 3.0 ;
        String expResult = "MobilePhone{radius=10, hoz= (1.0) , vert=2.0, hVel=0.0, vVel=3.0, infected=false, immune=false}";
        String result = instance.toString();
        System.out.println( result ); 
         System.out.println( expResult ); 
        org.testng.Assert.assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
      
    }

   
}
