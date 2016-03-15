package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Sergei on 25.02.2016.
 */
public class SubSolution extends Solution
{
    public SubSolution(Object pub1)
    {
        super(pub1);
    }

    public SubSolution(String pub2)
    {
        super(pub2);
    }

    public SubSolution(Integer pub3)
    {
        super(pub3);
    }

    protected SubSolution(Character prot1)
    {
        super(prot1);
    }

    protected SubSolution(Double prot2)
    {
        super(prot2);
    }

    SubSolution(Solution sol)
    {
        super(sol);
    }

    protected SubSolution(Exception prot3)
    {
        super(prot3);
    }

    SubSolution(SubSolution subSol)
    {
        super(subSol);
    }

    SubSolution(int intSol)
    {
        super(intSol);
    }


    private SubSolution(Number priv1){
        super(priv1);
    }
    private SubSolution(Boolean priv2){
        super(priv2);
    }
    private SubSolution(Float priv3){
        super(priv3);
    }
}