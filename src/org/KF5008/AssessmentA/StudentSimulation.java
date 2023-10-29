/*
  * property of northumbria universty + you. 
 */
package org.KF5008.AssessmentA;


import java.util.*;

/**
 *   TO PROFILE YOUR CODE . 
 *    IN PROFILE MENU CLICK 
 * @author you 
 */


//******************************************************************************
//BEN SISK
//w19007620
//******************************************************************************



class Point {
    int x;
    int y;
    Object userData;

    Point (int x, int y) {
      this.x = x;
      this.y = y;
    }

    Point (int x, int y, Object data) {
        this.x = x;
        this.y = y;
        this.userData = data;
    }
}

class Rectangle {
    int x;
    int y;
    int w;
    int h;

    Rectangle (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    boolean contains(Point p) {
        return (p.x > this.x - this.w &&
            p.x < this.x + this.w &&
            p.y > this.y - this.h &&
            p.y < this.y + this.h);
    }

    boolean intersects (Rectangle range) {
        return !(range.x - range.w > this.x + this.w ||
            range.x + range.w < this.x - this.w ||
            range.y - range.h > this.y + this.h ||
            range.y + range.h < this.y - this.h);
        }
    }

class Circle {
    int x, y, r, rSquared;
    Circle (int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.rSquared = this.r * this.r;
    }

    boolean contains(Point point) {
        double d = Math.pow((point.x - this.x), 2) + Math.pow((point.y - this.y), 2);
        return d <= this.rSquared;
    }

    boolean intersects(Rectangle range) {
        double xDist = Math.abs(range.x - this.x);
        double yDist = Math.abs(range.y - this.y);

        int r = this.r;

        int w = range.w;
        int h = range.h;

        double edges = Math.pow((xDist - w), 2) + Math.pow((yDist - h), 2);

        if (xDist > (r + w) || yDist > (r + h))
          return false;

        if (xDist <= w || yDist <= h)
          return true;

        return edges <= this.rSquared;
    }
}

class QuadTree {
  Rectangle boundary;
  int capacity;
  List<Point> points;
  boolean divided = false;
  QuadTree northeast = null;
  QuadTree northwest = null;
  QuadTree southeast = null;
  QuadTree southwest = null;

  QuadTree (Rectangle boundary, int capacity) {
    this.boundary = boundary;
    this.capacity = capacity;
    this.points = new ArrayList<>();
  }


  void subdivide () {
    int x = this.boundary.x;
    int y = this.boundary.y;
    int w = this.boundary.w/2;
    int h = this.boundary.h/2;

    Rectangle ne = new Rectangle(x + w, y - h, w, h);
    this.northeast = new QuadTree(ne, this.capacity);
    Rectangle nw = new Rectangle(x - w, y - h, w, h);
    this.northwest = new QuadTree(nw, this.capacity);
    Rectangle se = new Rectangle(x + w, y + h, w, h);
    this.southeast = new QuadTree(se, this.capacity);
    Rectangle sw = new Rectangle(x - w, y + h, w, h);
    this.southwest = new QuadTree(sw, this.capacity);



    this.divided = true;
  }

  boolean insert (Point p) {
    if (!this.boundary.contains(p)) {
      return false;
    }

    if (this.points.size() < this.capacity) {
      this.points.add(p);
      return true;
    } else {
      if (!this.divided) {
        this.subdivide();
      }
    }

    if (this.northeast.insert(p)) {
      return true;
    } else if (this.northwest.insert(p)) {
      return true;
    } else if (this.southeast.insert(p)) {
      return true;
    } else if (this.southwest.insert(p)) {
      return true;
    } else {
      return false;
    }
  }

    ArrayList query (Circle range, ArrayList found) {

        if (!range.intersects(this.boundary)) {
            return new ArrayList<Point>();
        }

        for (Point p : this.points) {
            if (range.contains(p)) {
                found.add(p);
            }
        }

        if (this.divided) {
            this.northeast.query(range, found);  
            this.northwest.query(range, found);
            this.southeast.query(range, found);
            this.southwest.query(range, found);
        }        
        return found;
    }
}


public class StudentSimulation extends BaseLineSimulation  
{
    
    public   StudentSimulation(  )
    { 
       super( );
       
       this.allPhones = new  LinkedList<MobilePhone>(  ); 
       communicatedGrowthData  = new LinkedList<>( ) ; 
       
       generate( 500, 0,0 , 1024, 800   ); // don't change this line.
       
    }
    //--------------------------------------------------------------------------
    public  StudentSimulation( int howMany  ,int minhoz, int minVert , int maxHoz , int maxVert )
    { 
       super( howMany  , minhoz,  minVert ,  maxHoz ,  maxVert ); 
       this.allPhones = new  LinkedList<MobilePhone>(  ); 
       communicatedGrowthData  = new LinkedList<>( ) ; 
       
       generate( howMany  , minhoz,  minVert ,  maxHoz ,  maxVert ); // don't change this line.
    }
    //--------------------------------------------------------------------------
    /**
     *  detect if a message can be sent between any two randomly selected phones. 
     *  Part of an on going experiment to see if the system works as predicted. 
     *  @Author Giles Motgomary Smith 
     */
    void findMessageRoute( )
    { 
        testforcomunication( ) ; 
        int phoneA = (int)( Math.random() * allPhones.size()) ; 
        int phoneB  ; 
        do
        { 
            phoneB = (int) (Math.random() * allPhones.size()) ; 
            System.out.printf(" %d %d " , phoneA, phoneB ); 
        } while( phoneB == phoneA  ); 
         
        
        MobilePhone from = allPhones.get( phoneA ); 
        //MobilePhone too = allPhones.get( phoneA ); 
        List< MobilePhone> innerSet = new ArrayList<> ( ) ; 
        List< MobilePhone> outerEdge = new ArrayList<> ( ) ; 
         
        for( MobilePhone it:allPhones  )it.setDepth( Integer.MAX_VALUE-10); 
        innerSet.add( from ); 
        from.setDepth(0);
        
        for( MobilePhone it: innerSet )
        { 
            for( int a = 0 ; a < it.interactedPhones.size( ) ; a ++ )
            {  
                MobilePhone other =  (MobilePhone) it.interactedPhones.get(a); 
             
                if( other == it ) continue ; 
                System.out.println( "depth before  " +  other.depth + " " + (it.depth+1) ); 
                if( other.depth > ( it.depth+1 ) )
                { 
                  
                    other.depth  = it.depth+1 ; 
                    if( !outerEdge.contains(it)) 
                    { 
                        outerEdge.add( it ) ;
                        System.out.println( "adding " +  other.depth);
                    }else 
                        System.out.println( "contains " +  other.depth);
                }
                System.out.println( "depth after  " +  other.depth);
            }
        }
        System.out.println( "--------DEPTHS size = " + outerEdge.size()); 
     
        for( MobilePhone it: outerEdge ) 
       { 
            System.out.println( it.depth ); 
       }
    }
         
    //--------------------------------------------------------------------------
    /****
     *  Move agents around. 
     */ 
    @Override
    public void move()
    {
        double check ;
        for( MobilePhone p: this.allPhones)
        { 
           p.step();
           //check = Math.hypot(p.getHoz(), p.getVert());
           
           if( ( p.getHoz() >= maxHoz)  || ( p.getHoz() <= minhoz )    )
           { 
               p.boundHoz();
           }
           if( ( p.getVert() >=  maxVert)  || ( p.getVert()<= minVert )  )
           { 
               p.bounceVert();
           }
        }
    }
    //--------------------------------------------------------------------------
    /** 
     * Slow version for students. 
     *  Test each phon  
     */
    @Override
    public void  testforcomunication()
    {
        Rectangle boundary = new Rectangle (this.maxHoz/2, this.maxVert/2, this.maxHoz/2, this.maxVert/2);
        QuadTree qtree = new QuadTree(boundary, 4);
        
        for(MobilePhone p : allPhones)
        {
            Point point = new Point (p.getHoz(), p.getVert(), p);
            qtree.insert(point);
        }
        
        
        ArrayList<Point> points;
        for (MobilePhone p : allPhones) {
          points = new ArrayList<>();
          Circle range = new Circle(p.getHoz(), p.getVert(), p.getCommuncationRadius());
          points = qtree.query(range, points);
          for (Point point : points) {
            MobilePhone other = (MobilePhone) point.userData;
            if (p != other && MobilePhone.isSperationLessThan( p.getHoz(), p.getVert() , 
                    other.getHoz() , other.getVert() , p.getCommuncationRadius())) {
              p.communicate(other);
            }
          }
        }
    } 
     //--------------------------------------------------------------------------
    /**
     * Note adding at location 0 is not critical to operation. 
     */
    public void  removeTheDead( )
    {
        double check = 0 ; 
        int countOfDead = 0 ; 
        List<MobilePhone>  theDead = new LinkedList< >( ) ; 
        for( int a = 0 ; a < getAllPhones().size() ; a++ )
        { 
            MobilePhone  who = getAllPhones().get(a);
            //check += Math.hypot(who.getHoz(), who.getVert());
            if( who.isDead())
            { 
                theDead.add(who);
                countOfDead++ ; 
            }
        }
       
        
        theDead = new ArrayList<>(theDead);
        check = 0 ; 
        int countOfDeadRemoved = 0 ; 
        for(  int b = 0 ; b <  theDead.size();b++)
        { 
            MobilePhone  who = theDead.get(b);
            for( int a = 0 ; a < getAllPhones().size() ; a++ )
            { 
                MobilePhone  it = getAllPhones().get(a);
                //check += Math.hypot(who.getHoz(), who.getVert());
                if( it == who ) 
                { 
                    getAllPhones().remove(a); 
                    countOfDeadRemoved ++ ; 
                    break ; 
                }
            }
        }
        assert countOfDeadRemoved == countOfDead ; 
    }
    
    
    //--------------------------------------------------------------------------
    /*
      - do something. which is very inefficent but easy to replace. 
        - perhaps buildin up set of infected. 
    
    Student: you have to ask your self is is everything here nessasry ? 
    could it be done in a more efficent manner  ? 
    
    feel free to remove stuff and see if the unit tests don't fail. 
    */
    @Override 
    public void  collectStatistics( )
    {
        HashSet<MobilePhone> uninfectedCount = new HashSet<>();
        HashSet<MobilePhone> infectedCount = new HashSet<>();
        double totalDist = 0 ;
        double uninfectedDensity = 0 ; 
        double infectedDensity = 0 ; 
        double check ; 
        
        
        for( MobilePhone p: allPhones)
        { 
            if( p.hasMessage( ) == false )
            { 
                if (uninfectedCount.contains(p) == false)
                {
                    uninfectedCount.add(p);
                }
            }else 
            { 
                if (infectedCount.contains(p) == false)
                {
                    infectedCount.add(p);
                }
            }
        }
    
        communicatedGrowthData.add(  infectedCount.size( ) ); 
        if( false ) System.out.printf(" INFECTED %d UNiNFECTED %d density %g, %g \n", infectedCount.size( ),
                                                   uninfectedCount.size() , 
                                                   ( totalDist/uninfectedCount.size() ) , 
                                                   (infectedDensity/infectedCount.size( ))  );
        numberOfInfected = uninfectedCount.size();  
    }
    
    //--------------------------------------------------------------------------
    /*
    
    */
    
    @Override
    public void step()
    { 
        move();
        testforcomunication() ;
        collectStatistics() ;
        removeTheDead() ;
    }
    
    //--------------------------------------------------------------------------
    @Override
    public int hashCode() 
    {
        // DO NOT CHANGE THIS !!!!!! will break assessment code.  
       return super.hashCode() ; 
    }
    //--------------------------------------------------------------------------
    @Override
    public boolean equals(Object obj) 
    {
       return super.equals(obj); 
    }
   
    //--------------------------------------------------------------------------
    public static double run (  int loops , int targeSize, final int DIM  ) 
    { 
        StudentSimulation fastestVersion = new StudentSimulation() ; 
        double fastSystemInSeconds = Double.NaN; 
        long startTime =  System.nanoTime();
        MobilePhone.setSeed(0xFACE );
        fastestVersion.generate(targeSize , 0, 0, DIM , DIM );
        System.err.printf(" Doing move. \n "  )  ;
        fastestVersion.move();
          System.err.printf(" Doing MoveDone. \n "  )  ;
        fastestVersion.findMessageRoute( ) ; 
         System.err.printf(" Find done  . \n "  )  ;
        long studentHash = fastestVersion.hashCode();
        
        System.err.printf(" HASH OF STUDENT = %X \n " , fastestVersion.hashCode() )  ;
        for( int a = 0 ; a < loops; a++ )  fastestVersion.step();
        
        long endTime =  System.nanoTime(); 
        long diff = endTime - startTime ;
         fastSystemInSeconds = diff/(1_000_000_000.);
        
        System.err.println( " FAST  TIME "+ diff + " nano seconds (ns) = "  + fastSystemInSeconds + " seconds" );
        
        return fastSystemInSeconds;
     }
    //--------------------------------------------------------------------------
    /* 
        this is a conveniance function -  you can use this to profile your code. 
    */
    public static void main(String args[])
    { 
        int loops =  100; 
        int targeSize = 2_100; // was 2_100 
       
        System.out.println( " STARTING  RUN Sudent  " + loops + " " + targeSize );
        final int DIM = 500;
         
        double baseLineInSeconds = StudentSimulation.run(   loops ,  targeSize,   DIM  ) ;
        
        if( baseLineInSeconds < 0.5)
        { 
            System.out.println( "#########################################################################" ) ; 
            System.out.println( " YOUR CODE WAS TOO FAST - MAKE THE NUMBER OF LOOPS TWICE AS BIG in main()" ) ; 
            System.out.println( "#########################################################################" ) ; 
        }
        System.out.println( " END  RUN  " );
        System.out.println(" Student  TIME "  + baseLineInSeconds + " seconds" );
    }
    //--------------------------------------------------------------------------
}