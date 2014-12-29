/*
 * Copyright (c) 2014 Abdul Hannan Ahsan <abdulhannan.ahsan@gmail.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package aha.snippet;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AnagramChecker
{
    /* An anagram is a type of word play, the result of rearranging the letters of a word or phrase to produce a new word or phrase, 
     * using all the original letters exactly once; for example Torchwood can be rearranged into Doctor Who.
     * via http://en.wikipedia.org/wiki/Anagram
     */
    
    private static String normalize( String input )
    {
        return input.replaceAll( "\\s+", "" )
                            .trim().toLowerCase();
     
    }
    
    private static String sortCharactersInString( String input   )
    {
        char[] chars = input.toCharArray();
        Arrays.sort( chars  );
        return new String ( chars );
    }
    public static boolean areAnagrams( String inputA, String inputB  )
    {
        String normalizedA = normalize( inputA );
        String normalizedB = normalize( inputB );
        
        if( normalizedA.length() != normalizedB.length() )
        {
            return false;
        }
        return sortCharactersInString( normalizedA ).equals( sortCharactersInString( normalizedB ) ); 
    }
    
    public static boolean areAnagrams2(  String inputA, String inputB )
    {
        // not a pretty solution but works if we cannot sort. 
        
        String normalizedA = normalize( inputA );
        String normalizedB = normalize( inputB );
        
        if( normalizedA.length() != normalizedB.length() )
        {
            return false;
        }
        
        Map<Character, Integer> charMapA = new HashMap<Character, Integer>();
        for( char c : normalizedA.toCharArray()  )
        {
            int count = charMapA.containsKey(c) ? charMapA.get(c) : 0;
            charMapA.put(c, count + 1);
          }
        
        for( char c : normalizedB.toCharArray() )
        {
            if( ! charMapA.containsKey( c ) )
            {
                return false;
            }
            
            int count = charMapA.get(c);
            charMapA.put( c, --count );
        }
        
        for( Integer i : charMapA.values() )
        {
            if( i != 0 )
            {
                return false;
            }
        }
        
        return true;
    }
    
    
    public static void main( String[] args )
    {
        String[] test1 = { "Doctor Who", "TorchWood" };
        System.out.println(  "Are " + Arrays.toString( test1 ) + " anagrams:" + 
                                          Boolean.toString ( areAnagrams( test1[0],  test1[1]  ) ) );
        
        System.out.println(  "Are " + Arrays.toString( test1 ) + " anagrams:" + 
                Boolean.toString ( areAnagrams2( test1[0],  test1[1]  ) ) );
        
        
        String[] test2 =  {  "William Shakespeare",  "I am a weakish speller" };
        System.out.println(  "Are " + Arrays.toString( test2 ) + " anagrams:" + 
                                          Boolean.toString ( areAnagrams( test1[0],  test1[1]  ) ) );
        
        System.out.println(  "Are " + Arrays.toString( test2 ) + " anagrams:" + 
                Boolean.toString ( areAnagrams2( test1[0],  test1[1]  ) ) );
    }
}
