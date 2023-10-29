/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.KF5008.AssessmentA;

import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 *
 * @author nickdalton
 */
public class StudentSimulationNGTest {
    
    public StudentSimulationNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception
    {
        
    }
    @Test
        void testMake( ) 
    { 
         // StudentSimulation instance = new StudentSimulation(1  ,0, 0 , 1 , 1);
         Assert.assertEquals(0, 0 );
         StudentSimulation instance = new StudentSimulation(10  ,0, 0 ,1_000  , 1_000);
         Assert.assertEquals(0, 0 );
    }
    /* 
       for some reason does not get past   StudentSimulation instance = new StudentSimulation(1  ,0, 0 , 1 , 1);
    */
    @Test 
     void testCorrectness() 
    {  
       System.out.println("correctness");
       
       MobilePhone m1 = new MobilePhone( 0,  0 ,  1 ,  1); 
   
       MobilePhone m2 = new MobilePhone( 0,  0 ,  1 ,  1);
       StudentSimulation instance = new StudentSimulation(10  ,0, 0 ,1_000  , 1_000);
      
       instance.getAllPhones().clear();
       
        m1.hoz = m1.vert = 0 ; 
        m1.vVel = m1.hVel = 1; 
        instance.allPhones.add(m1); 
       
        BaseLineSimulation baseline = new BaseLineSimulation( 10  ,0, 0 ,1_000  , 1_000) ; 
        baseline.getAllPhones().clear();
        m2.hoz = m2.vert = 0 ; 
        m2.vVel = m2.hVel = 1; 
        baseline.allPhones.add(m2); 
        
        //System.err.println("$$$$$$$ "  +instance.getAllPhones().hashCode() );
        //System.err .println("********** " + baseline.getAllPhones().hashCode() );
        
        long s,s2 ; 
        Assert.assertEquals(instance.getAllPhones().hashCode(), s = baseline.getAllPhones().hashCode());
       
        instance.step() ; baseline.step();// if they 
        
        Assert.assertEquals(instance.getAllPhones().hashCode(), s2= baseline.getAllPhones().hashCode());
        Assert.assertNotEquals(s, s2);
      //  System.err .println("---------------------" + baseline.getAllPhones().hashCode() );
        
    }

    @Test
     public void testGetAllPhones() 
     {
      // this is a weak test. 
        System.out.println("getAllPhones");
        StudentSimulation instance = new StudentSimulation();
        List<MobilePhone> expResult = null;
        List<MobilePhone> result = instance.getAllPhones();
        Assert.assertNotNull(result);
    }
    @Test
    public void testGenerate() 
    {
        System.out.println("generate");
        int howMany = 55 ;
        StudentSimulation instance = new StudentSimulation();
        instance.generate(howMany, 0, 0, 1024, 800 );
        
        List<MobilePhone> result = instance.getAllPhones();
        Assert.assertNotNull(result);
        //System.out.println(" size"+ result.size());
       
        Assert.assertEquals(result.size(), howMany ); 
      
    }
    
    
    static long studentHash = 0L ;
    static long basicHash =  0L ; 
    @Test 
    static public void testSpeed()
    {
        int targeSize = 2_100; 
        final int DIM = 1_000;
        double speedFactor = 0 ; 
        double markScale = 100./5. ; 
       
        System.out.println( " STARTING  RUN 5  " +  targeSize );
        
        double baseSpeedSeconds = runBaseLineVersion(   2 ,  targeSize,   DIM  ) ;
        System.out.println( " END  RUN  " );
        System.out.println( " BASE  TIME "  + baseSpeedSeconds + " seconds" );
        
        double fastSystemInSeconds =  runFastVersion (   2 ,  targeSize,   DIM   ) ;
        System.out.println( " END  RUN  " );
        System.out.println( " FAST  TIME "  + fastSystemInSeconds + " seconds" );
                
        System.err.printf(" RAW SPEED increase %g \n", speedFactor = (baseSpeedSeconds / fastSystemInSeconds) ); 
         System.err.printf(" Unscaled  %.0g \n", Math.ceil( Math.log(baseSpeedSeconds / fastSystemInSeconds)  )    ); 
       
         System.err.printf("*********************************************************************************************\n");
         if(speedFactor  < 1.) 
        { 
               System.err.printf("####  happens due to NOISE. TRY TESTING AGAIN.  ####\n"); 
        }
        else if( speedFactor  < 1.25   )
        { 
             System.err.printf(" Warp factor Raw = %g , Mark  1(ish) ( \n", speedFactor, 
             (Math.ceil( Math.log(baseSpeedSeconds / fastSystemInSeconds)  )-1) * (markScale )  );
            System.err.println( "##### No real change from base line ( try again to check )  ####\n"); 
        }else 
        { 
             System.err.printf(" Warp factor Raw = %g , Roughtly Mark  %g%% See table for correct scale \n", speedFactor, 
             Math.ceil( Math.log(baseSpeedSeconds / fastSystemInSeconds)  ) * (markScale )  );
        }
        
        System.err.printf("*********************************************************************************************\n");
        System.err.printf(" %H , %H \n" , basicHash , studentHash ) ; 
        assertEquals( basicHash , studentHash ); 
        
       /* AnySimulationModel baseVersion = new BaseLineSimulation();
        
        int loops =  2; 
        int targeSize = 1_000; 
        final int DIM = 50_000;
        double baseSpeedSeconds  = Double.NaN; 
       
         // BASE VERSION 
        { 
            long startTime =  System.nanoTime();
            baseVersion.generate(targeSize, 0, 0, DIM , DIM );

            for( int a = 0 ; a < loops; a++ )  baseVersion.step();

            long endTime =  System.nanoTime(); 
            long diff = endTime - startTime ;
            baseSpeedSeconds = diff/(1_000_000_000.);

            System.err.println( " BASE  TIME "+ diff + " nano seconds (ns) = "  + baseSpeedSeconds + "seconds" );
        } 
        // TEST VERSION 
        double baseLineInSeconds = runBaseLineVersion( loops , targeSize ,  DIM ) ;  
        
        System.err.printf(" RAW SPEED increase %g \n", (baseSpeedSeconds / baseLineInSeconds) ); 
        */ 
    }
    //--------------------------------------------------------------------------
    public static double runBaseLineVersion (  int loops , int targeSize, final int DIM  ) 
    { 
        
        BaseLineSimulation studentVersion = new BaseLineSimulation() ; 
        
        double fastSystemInSeconds = Double.NaN; 
        long startTime =  System.nanoTime();
        MobilePhone.setSeed(0xFACE );
        studentVersion.generate(targeSize , 0, 0, DIM , DIM );
        
         if ( studentVersion.getAllPhones().get(0).hasMessage() !=true  )
         { 
             System.out .printf("INTERNAL ERRORRRR"); 
             assert false; 
         }
        basicHash = studentVersion.hashCode(); 
        System.err.printf(" {{ HASH OF STUDENT = %X }}  \n " , basicHash )  ;
       System.err.printf(" {{ HASH OF FAST ELEMENT = %X %d }}  \n " ,
                studentVersion.getAllPhones().get(0).hashCode(), 
                studentVersion.getAllPhones().size( ))  ;
        System.err.println(studentVersion.getAllPhones().get(0) );
        for( int a = 0 ; a < loops; a++ )  studentVersion.step();
        
        long endTime =  System.nanoTime(); 
        long diff = endTime - startTime ;
        fastSystemInSeconds = diff/(1_000_000_000.);
        
        System.err.println( " BASIC  TIME "+ diff + " nano seconds (ns) = "  + fastSystemInSeconds + " seconds" );
        
        return fastSystemInSeconds;
    }
    //--------------------------------------------------------------------------
    public static double runFastVersion (  int loops , int targeSize, final int DIM  ) 
    { 
        AnySimulationModel fastestVersion = new StudentSimulation() ; 
        double fastSystemInSeconds = Double.NaN; 
        long startTime =  System.nanoTime();
        
        MobilePhone.setSeed(0xFACE );
        fastestVersion.generate(targeSize , 0, 0, DIM , DIM );
        studentHash = fastestVersion.hashCode();
        System.err.printf(" {{ HASH OF FAST %h }} \n " ,  studentHash )  ;
        System.err.printf(" {{ HASH OF FAST ELEMENT = %X %d }}  \n " , fastestVersion.getAllPhones().get(0).hashCode(), 
                fastestVersion.getAllPhones().size( ))  ;
        System.err.println(fastestVersion.getAllPhones().get(0) );
        
        for( int a = 0 ; a < loops; a++ )  fastestVersion.step();
        
        long endTime =  System.nanoTime(); 
        long diff = endTime - startTime ;
         fastSystemInSeconds = diff/(1_000_000_000.);
        
        System.err.println( " FAST  TIME "+ diff + " nano seconds (ns) = "  + fastSystemInSeconds + " seconds" );
       
        return fastSystemInSeconds;
        
        //eturn StudentSimulation.run(loops, targeSize, DIM); 
     }
    
}
