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

public class PalindromeChecker
{
    /* A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward. 
     * Allowances may be made for adjustments to capital letters, punctuation, and word dividers. 
     * Famous examples include "A man, a plan, a canal, Panama!", "Amor, Roma", "race car" and "No 'x' in Nixon".
     * via en.wikipedia.org/wiki/Palindrome
     */
    
    public static boolean isPalindrome( char[] sequence )
    {
        if( sequence.length <= 1 )
        {
            return true;
        }
    
        char[] normalized = new String( sequence ).replaceAll( "\\s", "" )
                                                                              .toLowerCase()
                                                                              .toCharArray();
        
        int  idxForward = 0;
        int idxBackwards =normalized.length - 1;;
        
        while( idxForward <= idxBackwards && normalized[idxForward++] == normalized[idxBackwards--] )
        {
        }
          
        return idxForward > idxBackwards;
    }
    
    public static void main( String args[] )
    {
        String a = "A man a plan a canal Panama";
        System.out.println( a + ( isPalindrome( a.toCharArray()  ) ? " is a palindrome"
                                                                                                     : "  is not a palindrome "  )  );
        
        String b = "Amor, Roma";
        System.out.println( b + ( isPalindrome( b.toCharArray()  ) ? " is a palindrome"
                                                                                                     : "  is not a palindrome "  )  );
        
        
        String c = "aloha";
        System.out.println( c + ( isPalindrome( c.toCharArray()  ) ? " is a palindrome"
                                                                                                     : "  is not a palindrome "  )  );
    }
}
