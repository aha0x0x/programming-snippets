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

package aha.datastructure.graph;

public class Vertex
{
    public static enum STATE
    {
        NOT_PRECESSED,
        IN_PROCESS,
        PROCESSED
    };
    
    private String id;
    private STATE state;
    
    public Vertex( final String id )
    {
        this.id = id;
        this.state = STATE.NOT_PRECESSED;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "Vertex [" )
                   .append( id ).append(":").append( state )
                   .append( "]" );
        
        return builder.toString();
    }
    
    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }

        if( !( o instanceof Vertex ) )
        {
            return false;
        }

        Vertex other = ( Vertex ) o;
        return this.id.equals( other.id  ) &&
                    this.state.equals( other.state);
    }
    
    public String getId()
    {
        return id;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( id.hashCode() );
//        result = prime * result + (  state.hashCode() );
        return result;
    }

    public STATE getState()
    {
        return state;
    }
    
    public void setState( STATE state )
    {
        this.state = state;
    }
}
    
    
