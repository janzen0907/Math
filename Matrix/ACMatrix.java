/*
 *  Date submitted: Fall 2023
 *  Assignment number: N/A
 *  Course name:  MATH 282
 *  Instructor:  Michael Grzesina
 */

package matrix3;

/**
 * Abstract class for Matrix class<br>
 * for creating matrices and performing operations on them<br>
 * for Learning Outcomes 3 and 5<br>
 * 
 * @author MATH 282
 * @version Fall 2023
 */
public abstract class ACMatrix implements IMatrix
{
    /**
     * Number of rows in the matrix
     */
    private int iRows;

    /**
     * Number of columns in the matrix
     */
    private int iCols;


    /* (non-Javadoc)
     * @see matrix.IMatrix#getRows()
     */
    /**
     * Returns the number of rows in the invoking matrix
     * 
     * @return          Number of rows in the matrix
     */
    @Override
    public int getRows()
    {
        return this.iRows;
    }

    
    /* (non-Javadoc)
     * @see matrix.IMatrix#getCols()
     */
    /**
     * Returns the number of columns in the invoking matrix
     * 
     * @return          Number of columns in the matrix
     */
    @Override
    public int getCols()
    {
        return this.iCols;
    }

    
    /**
     * Sets the number of rows in the matrix
     * 
     * @param iRows     Number of rows in the matrix
     * @throws IllegalArgumentException     Number of rows is less than 1
     */
    protected void setRows(int iRows)
            throws IllegalArgumentException
    {
        if (iRows < 1)
        {
            throw new IllegalArgumentException("Matrix must have at least 1 row");
        }
        this.iRows = iRows;
    }
    
    
    /**
     * Sets the number of rows in the matrix
     * 
     * @param iRows     Number of rows in the matrix
     * @throws IllegalArgumentException     Number of rows is less than 1
     */
    protected void setCols(int iCols)
            throws IllegalArgumentException
    {
        if (iCols < 1)
        {
            throw new IllegalArgumentException("Matrix must have at least 1 row");
        }
        this.iCols = iCols;
    }
    
    
    /* (non-Javadoc)
     * @see matrix.IMatrix#getElement(int, int)
     */
    /**
     * Gets the element at the specified row and column in the invoking matrix
     * 
     * @param iRow      The row to get the element from
     * @param iCol      The column to get the element from
     * @return          Element in the matrix at the specified row and column
     */
    @Override
    public abstract double getElement(int iRow, int iCol);

    
    /**
     * Sets the element in the matrix in the specified row and column
     * to the specified value.
     * 
     * @param iRow      The row to set the element in
     * @param iCol      The column to set the element in
     * @param dValue    The value to set the element to
     */
    public abstract void setElement(int iRow, int iCol, double dValue);

    
    /**
     * Creates a new matrix of the specified size with all entries set to 0.0
     * 
     * @param iRows     The number of rows in the new matrix
     * @param iCols     The number of columns in the new matrix
     * @return          A new matrix of the specified size with all entries set to 0.0
     */
    protected abstract ACMatrix createMatrix(int iRows, int iCols);

    
    /**
     * Creates a new matrix that is exactly the same as the invoking matrix
     * 
     * @return          A new matrix with the same size and same entries as the invoking matrix
     */
    protected abstract ACMatrix copyMatrix();


    /* (non-Javadoc)
     * @see matrix.IMatrix#add(matrix.IMatrix)
     */
    /**
     * Adds together the invoking matrix and the passed-in matrix and returns
     * the sum matrix. Throws exception if matrices are not of equal size.
     * 
     * @param mRight    Matrix to be added to the invoking matrix
     * @return          Sum of invoking matrix and matrix passed in
     * @throws IllegalArgumentException     Matrices are not the same size and cannot be added
     */
    @Override
    public IMatrix add(IMatrix mRight)
            throws IllegalArgumentException
    {
        ACMatrix mLeftOp = this;
        ACMatrix mRightOp = (ACMatrix)mRight;
        ACMatrix mSum = null;
        
        // if the matrices are not the same size, throw an exception
        if (mLeftOp.iRows != mRightOp.iRows || mLeftOp.iCols != mRightOp.iCols)
        {
            throw new IllegalArgumentException("Matrices must be the same size for addition or subtraction");
        }
        
        // sum matrix is the same size as the operands
        mSum = createMatrix(mLeftOp.iRows, mLeftOp.iCols);
        
        // for every row in the sum matrix
        for (int r = 1; r <= mSum.iRows; r++)
        {
            // for every column in the current row of the sum matrix
            for (int c = 1; c <= mSum.iCols; c++)
            {
                // add corresponding elements in the operand matrices and put the result
                // in the same position in the sum matrix
                mSum.setElement(r, c, 
                        mLeftOp.getElement(r, c) + mRightOp.getElement(r, c));
            }
        }
        
        return mSum;
    }

    
    /* (non-Javadoc)
     * @see matrix.IMatrix#scalarMultiply(double)
     */
    /**
     * Multiplies all entries in the invoking matrix by the scalar value passed in.
     * 
     * @param dScalar   Value to multiply the matrix entries by
     * @return          Matrix with all entries multiplied by the scalar value passed in
     */
    @Override
    public IMatrix scalarMultiply(double dScalar)
    {
        ACMatrix mProduct = createMatrix(this.iRows, this.iCols);
        
        // for every row in the product matrix
        for (int r = 1; r <= mProduct.iRows; r++)
        {
            // for every column in the current row of the product matrix
            for (int c = 1; c <= mProduct.iCols; c++)
            {
                mProduct.setElement(r, c, this.getElement(r, c) * dScalar);
            }
        }
        
        return mProduct;
    }

    
    /* (non-Javadoc)
     * @see matrix.IMatrix#subtract(matrix.IMatrix)
     */
    /**
     * Subtracts the passed-in matrix from the invoking matrix and returns
     * the resultant matrix. Throws exception if matrices are not of equal size.
     * 
     * @param mRight    Matrix to be subtracted the invoking matrix
     * @return          Matrix that results from subtracting the passed-in matrix from the invoking matrix
     * @throws IllegalArgumentException     Matrices are not the same size and cannot be subtracted
     */
    @Override
    public IMatrix subtract(IMatrix mRight)
            throws IllegalArgumentException
    {
        // could be implemented separately for slight efficiency gain (still O(n^2))
        // but this is less code and uses already tested methods
        return this.add(mRight.scalarMultiply(-1.0));
    }

    
    /* (non-Javadoc)
     * @see matrix.IMatrix#multiply(matrix.IMatrix)
     */
    /**
     * Multiplies the invoking matrix by the passed-in matrix and returns
     * the product matrix. Throws exception if matrices cannot be multiplied.
     * 
     * @param mRight    Matrix to be multiplied against the invoking matrix
     * @return          Matrix that results from multiplying the invoking matrix by the passed-in matrix
     * @throws IllegalArgumentException     Matrices cannot be multiplied because they are the wrong sizes
     */
    @Override
    public IMatrix multiply(IMatrix mRight)
            throws IllegalArgumentException
    {
        // TODO Auto-generated method stub
        return null;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    /**
     * Returns the matrix as a string with each row on one line
     * and each column separated by tabs.
     * 
     * @return  String representation of the invoking matrix
     */
    @Override
    public String toString()
    {
        String s = "";
        
        // go through every row
        for (int r = 1; r <= this.iRows; r++)
        {
            s += "[\t";
            // go through every column in this row
            for (int c = 1; c <= this.iCols; c++)
            {
                s += this.getElement(r, c) + "\t";
            }
            s += "]\n";
        }
        
        return s;
    }


    /* (non-Javadoc)
     * @see matrix.IMatrix#gaussJordanElimination()
     */
    /**
     * Solves a system of linear equations given by an n by (n+1) matrix where the first n columns
     * are the coefficients for the n linear equations and the (n+1)st column contains the known vector.
     * Throws an exception if the matrix is not of size n by (n+1) or if the system of equations cannot
     * be solved.
     * 
     * @return          Matrix with solved linear equation (identity matrix plus solution vector)
     * @throws IllegalCallerException       Invoking matrix is not of size n by (n+1)
     * @throws ArithmeticException          System of equations cannot be solved
     */
    @Override
    public IMatrix gaussJordanElimination()
            throws IllegalCallerException, ArithmeticException
    {
        if (this.iRows != iCols -1)
        {
        	throw new IllegalCallerException("Must start with an augmented matrix");
        }
        
        ACMatrix mSolution = this.copyMatrix();
        
        for(int r=1; r<=mSolution.iRows; r++)
        {
        	mSolution.systemSolvable(r);
        	double dPivot = mSolution.getElement(r, r);
        	for(int c =1; c <= mSolution.iCols; c++)
        	{
        		mSolution.setElement(r, c, mSolution.getElement(r, c) / dPivot);
        	}
        	
        	for(int r1 = 1; r1 <= mSolution.iRows; r1++)
        	{
        		if(r1 != r)
        		{
        			//Find the entry in the pivot column in this row
        			double dFactor = -1.0 * mSolution.getElement(r1, r);
        			
        			for(int c = 1; c <=mSolution.iCols; c++)
        			{
        				double dValue = mSolution.getElement(r1, c) + mSolution.getElement(r, c) * dFactor;
        				mSolution.setElement(r1, c, dValue);
        			}
        		}
        		
        	}
        }
        
        
        return mSolution;
    }
    
    /**
     * Check if a non zero pivot element can be found in a matrix for Gauss-Jordan Elimination
     * and swap pivot row if necessary to get the pivot element to be non-zero
     * @param i	Pivot row being checked in Matrix
     * @throws ArithmeticException	Non-Zero pivot element cannot be fown
     */
    private void systemSolvable(int i)
    	throws ArithmeticException
    {
    	
    	double dPivot = this.getElement(i, i);
    	int iNextRow = i + 1;
    	
    	while(dPivot == 0.0 & iNextRow <= this.iRows)
    	{
    		//Try to get the element in the pivot column from the next row
    		dPivot = this.getElement(iNextRow, i);
    		
    		//If the new attempt pivot is non-zero, we have found a new pivot value 
    		//Swap the pivot row and the row where the the non-zero pivot was found
    		if(dPivot != 0.0)
    		{
    			for(int j=1; j <= this.iCols; j++)
    			{
    				double dTemp = this.getElement(i, j);
    				this.setElement(i, j, this.getElement(iNextRow, j));
    				this.setElement(iNextRow, j, dTemp);
    			}
    		}
    		else
    		{
    			iNextRow++;
    		}
    		
    	}
    	
    	if(dPivot == 0.0)
    	{
    		System.out.println(this.toString());
    		throw new ArithmeticException("System does not have a unique solution");
    	}
    	
    }

    
    /* (non-Javadoc)
     * @see matrix.IMatrix#leastSquares(int)
     */
    /**
     * Calculates the least squares polynomial of the given degree that matches the given data points.
     * Throws an exception if the degree given is less than 0, or if the invoking matrix is not a 2D
     * matrix of points, or if the number of points cannot create a least squares polynomial of the
     * given degree. Returns a matrix of size n by (n+1) with the identity matrix followed by the vector
     * of coefficients for the least squares polynomial.
     * 
     * @param m         Degree sought for the least squares polynomial
     * @return          Solved system of linear equations with the coefficients for the least squares polynomial
     * @throws IllegalCallerException       Invoking matrix is not a matrix of points
     * @throws IllegalArgumentException     Matrix of points given does not support the degree sought
     */
    @Override
    public IMatrix leastSquares(int m)
            throws IllegalCallerException, IllegalArgumentException
    {
        //if this is not a matroix of points (with 2 columns), throw exception
    	if(this.iCols != 2)
    	{
    		throw new IllegalCallerException("Invoking matrix must be a matrix of data point (N by 2)");
    	}
    	
    	//if the number of data points does not allow for degree chosen
    	//or the degree chosen is less than 0, throw exception
    	if(this.iRows < m +1 || m < 0)
    	{
    		throw new IllegalArgumentException("Points and degree do not match");
    	}
    	
    	
    	//There is a pattern that micheal showed for the position of the x sums
    	//Note that the xSum is always 2 less than the row# and column#
    	//Calculate x-sums
    	int numXSums = 2 * m + 1;
    	double[] xSums = new double[numXSums];
    	//Two options:
    	//1. For every x-sum,
    	//	Goo through every point and add x^(corresponding x-sum)
    	
    	for(int i=1; i < this.iRows; i++)
    	{
    		for(int j=1; j< this.iCols; j++)
    		{
    			//This may need to be i,i not i,0
    			double xValue = this.getElement(i, j);
    			xSums[j] += Math.pow(xValue, j);
    			System.out.println("X-Sums: " + xSums[j]);
    		}
    	}
    	//2. For every point 
    	//	Go though every x-sum and add x^(corresponding x-sum)
    	
    	//Calculate y-sums
    	int numYsums = m +1;
    	double[] ySums = new double[numYsums];
    	//Same two options as above to calucate the y-sums. 1. seems easier to me
    	//Recall that y-sums are x^(corresponding y-sum) * y 
    	for(int i=1; i<this.iRows; i++)
    	{
    		for(int j=1; j< this.iCols; j++)
    		{
    			double yValue = this.getElement(i, j);
    			ySums[j] += Math.pow(yValue, j) * yValue;
    		}
    	}
    	
    	
    	//Fill augmented matrix with x-sums and y-sums
    	ACMatrix mSolution = createMatrix(m + 1, m + 2);
    	
    	
    	//Call Gauss-Jordan elimination on the augmented matrix

        return mSolution.gaussJordanElimination();
    }
}
