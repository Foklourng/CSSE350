/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scent;

import static org.junit.Assert.*;

/**
 *
 * @author Foklourng
 */
public class TestFile {
 public void testApiInput(){
     //JunitTesting test = new JunitTesting();
     //assertEquals
     JunitTesting test = new JunitTesting();
     int output = test.square(5);
     assertEquals(25, output);
 }   
 
 public int square(int a){
     return a*a;
 }
}
